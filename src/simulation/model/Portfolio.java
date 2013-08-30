package simulation.model;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import simulation.model.Option.optiontype;
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
		int total = orders.size();
		int o_counter = 0; //order counter
		int t_counter = 0; //table counter
		while(o_counter < total && t_counter < indextable.length){
			String row[] =  indextable[t_counter];
			Order o = orders.get(o_counter);
			
			int result = row[0].compareTo(o.getUnderlying().getSymbol());
			if(result ==0){
				
				newprice = Float.parseFloat(row[1]);

				Derivative s = o.getUnderlying();

				//only considered stock, one one type of order, change this later
				if(o.getLongShort().equals("Long")){
					//user placed a buy order of stock
					if(newprice < s.getPrice()){
						
						purchase(s);
					}
					
				}else if(o.getLongShort().equals("Short")){
					
					if(newprice > s.getPrice()){
						
						sell(s, newprice);
					}

				}
				o_counter++;
				t_counter++;

			}else if(result > 0){
				//symbol in the table is larger
				o_counter++;
			}else{
				t_counter++;
			}
			
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
	
	public void purchase(Derivative d){
		if(credit>d.getTotal()){
			credit -= d.getTotal();
			onhand.add(d);
			System.out.println("purchase "+d.getId());
			removeOrder(d);
		}
	}
	
	public void purchase(Derivative d, float spotprice){
		if(credit>d.getTotal()){
			credit -= d.getVolume()*spotprice;
			onhand.add(d);
			System.out.println("purchase "+d.getId());
			removeOrder(d);
		}
	}
	
	public void sell(Derivative d, float spotprice){
		if(onhand.remove(d)){
			credit += d.getVolume()*spotprice;
			removeOnhand(d);
			removeOrder(d);
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
				removeOrder(o);
			}
		}else{
			JOptionPane.showMessageDialog(null,
				    "Option has no value at the moment, better wait until expiration");
		}

	}
	
	public void makeOrder(Order newo){
		int i = 0;
		for(Order o: orders){
			if(o.getUnderlying().getSymbol().compareTo(newo.getUnderlying().getSymbol())> 0){
				orders.add(i, newo);
				break;
			}
			i++;
		}
		if(i == orders.size())orders.add(newo);
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
