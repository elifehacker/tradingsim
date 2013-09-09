package simulation.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import order.LimitOrder;
import order.Order;
import order.StopLimitOrder;
import order.StopOrder;

import derivative.Derivative;
import derivative.Option;
import derivative.Option.optiontype;

import view.SimulationView;

public class Portfolio {

	public LinkedList<Derivative> getOnhand() {
		return onhand;
	}
	
	public LinkedList<Order> getOrder() {
		return orders;
	}
	
	/*
	public float getUnderlyingPrice(String sym){
		if(simulation.getNewTableFlag() == true){
			updateIndexTable();
			simulation.setNewTableFlag(false);
		}
		float price = 0;
		for(String[] row : indextable){
			if(row[0].equals(sym)){
				price = Float.parseFloat(row[1]);
				break;
			}
		}
		return price;
	}*/
	
	public void checkOrders(String[][] it){
		indextable = it;

		float newprice = 0;
		float netchange = 0;

		int total = orders.size();
		int c = 0; //table counter
		HashSet<String> hs = new HashSet<String>();
		for(int i = 0; i < orders.size(); i ++){
			hs.add(orders.get(i).getUnderlying().getSymbol());
		}
		int sym_col = SimulationView.get_index_title_index("Symbol");
		int last_col = SimulationView.get_index_title_index("Last");
		int net_col = SimulationView.get_index_title_index("Net Change");
		while(c < indextable.length){

			String row[] = it[c]; 
			if(hs.contains(row[sym_col])){
				LinkedList<Order> pendingOrder = new LinkedList<Order>();
				LinkedList<Order> removingOrder = new LinkedList<Order>();
				
				for(Order o : orders){
					if(o.getUnderlying().getSymbol().equals(row[sym_col])){
						newprice = Float.parseFloat(row[last_col]);
						netchange = Float.parseFloat(row[net_col]);
				
						if (o instanceof LimitOrder){
							LimitOrder lo = (LimitOrder) o;
							if(o.getLongShort().equals("Long") && newprice < lo.getlimitprice()){
								purchase(o, removingOrder);
								
							}else if(o.getLongShort().equals("Short") && newprice > lo.getlimitprice()){
								sell(o, removingOrder);
								
							}
							
						}else if (o instanceof StopLimitOrder || o instanceof StopOrder){
							// Stop order and stop limit order shares some similarity
							
							float diff = 0;
							if(o instanceof StopOrder){
								StopOrder so = (StopOrder) o;
								diff =  newprice - so.getstopprice();
							}else if(o instanceof StopLimitOrder){
								StopLimitOrder slo = (StopLimitOrder) o;
								diff =  newprice - slo.getstopprice();
							}
							if((netchange<0 && diff<0 && abs(diff)< abs(netchange))||
									(netchange>0 && diff>0 && diff< netchange)){
								//triggered
								if(o instanceof StopOrder){
									if(o.getLongShort().equals("Long")) purchase(o, removingOrder);
									if(o.getLongShort().equals("Short")) sell(o, removingOrder);									
								}else if(o instanceof StopLimitOrder){
									LimitOrder lo = new LimitOrder(o.getUnderlying(), o.getLongShort(), ((StopLimitOrder) o).getlimitprice());

									removingOrder.add(o);
									pendingOrder.add(lo);						
								}
							}//end of trigger action
						}//market order executes immediately
					}
				}
				for(Order o : pendingOrder){
					//check again, because limit order might be executed in the same cycle
					if (o instanceof LimitOrder){
						LimitOrder lo = (LimitOrder) o;
						if(o.getLongShort().equals("Long") && newprice < lo.getlimitprice()){
							purchase(o, removingOrder);
							
						}else if(o.getLongShort().equals("Short") && newprice > lo.getlimitprice()){
							sell(o, removingOrder);
							
						}else{
							orders.add(o);
						}
					}
				}
				for(Order o : removingOrder){
					orders.remove(o);
				}
			}
			c++;
		}
	}
	
	public float getCredit(){
		return credit;
	}
	
	private void removeOnhand(Derivative gone){
		for(Derivative d: onhand){
			if(d.getId() == gone.getId()){
				onhand.remove(d);
				break;
			}
		}
	}
	
	private void removeOrder(Derivative gone){
		for(Order o: orders){
			if(o.getUnderlying().getId() == gone.getId()){
				orders.remove(o);
				break;
			}
		}
	}
	
	public void test_purchase(Derivative d){
		if(credit>d.getTotal()){
			credit -= d.getTotal();
			onhand.add(d);
			System.out.println("purchase "+d.getId());
			removeOrder(d);
		}
	}
	
	
	public void test_purchase(Derivative d, float spotprice){
		if(credit>d.getTotal()){
			credit -= d.getVolume()*spotprice;
			onhand.add(d);
			System.out.println("purchase "+d.getId());
			removeOrder(d);
		}
	}
	 	
	public void test_sell(Derivative d, float spotprice){

	 		if(onhand.remove(d)){
				credit += d.getVolume()*spotprice;
				removeOnhand(d);
				removeOrder(d);

	 		}
	 }
	
	private void purchase(Order o, LinkedList<Order> list){
		Derivative d =o.getUnderlying(); 
		if(credit>d.getTotal()){
			credit -= d.getTotal();
			onhand.add(d);
			System.out.println("order executed in purchase"+d.getId());
			//orders.remove(o);
			list.add(o);

		}
	}
	
	private void sell(Order o, LinkedList<Order> list){
		Derivative d =o.getUnderlying(); 
		if(onhand.remove(d)){
			credit += d.getTotal();
			if(!onhand.remove(d)){
				credit -= d.getTotal();
			}
			System.out.println("order executed in sell"+d.getId());
			//orders.remove(o);
			list.add(o);
		}
	}
	
    public static float abs(float a) {
        return (a <= 0.0F) ? 0.0F - a : a;
    }
	
	public void sellOption(Option o, float spotprice){
		
		if(spotprice>o.getStrike() ^ o.getType()==optiontype.put){
			if(onhand.remove(o)){
				credit += o.getVolume()*(abs(spotprice - o.getStrike()));
				removeOnhand(o);
				//removeOrder(o);
			}
		}else{
			JOptionPane.showMessageDialog(null,
				    "Option has no value at the moment, better wait until expiration");
		}

	}
	
	public void makeOrder(Order newo){
		orders.add(newo);
	}

	public void printAll(){
		System.out.println("------------");
		System.out.println("Orders:");
		for(Order o : orders){
			Derivative d = o.getUnderlying();
			System.out.println("OID: "+o.getId()+" DID: "+d.getId()+" "+d.getSymbol()+" "+d.getTotal());
		}
		System.out.println("Derivatives:");
		for(Derivative d : onhand){
			System.out.println("DID: "+d.getId()+" "+d.getSymbol()+" "+d.getTotal());
		}		
		
	}
	
	public float sellOnhandbyId(int id){
		for(Derivative d : onhand){
			if(d.getId() == id){
				float price = d.getTotal();
				orders.remove(d);
				return price;
			}
		}
		return 0;
	}
	
	public void removeOrderbyId(int id){
		for(Order o : orders){
			if(o.getUnderlying().getId() == id){
				orders.remove(o);
				break;
			}
		}
	}
	
	private LinkedList<Derivative> onhand;
	private LinkedList<Order> orders;

	private String[][] indextable;
	
	private float credit;
	
	public Portfolio(LinkedList<Derivative> portfolio, LinkedList<Order> od, float c) {
		this.onhand = portfolio;
		this.orders = od;
		credit = c;
	}

	public Portfolio( float c) {
		this.onhand = new LinkedList<Derivative>();
		this.orders = new LinkedList<Order>();
		credit = c;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
