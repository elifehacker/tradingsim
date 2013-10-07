package order;

import derivative.Derivative;

public class StopLimitOrder extends Order {

	private float limitprice;
	private float stopprice;
	
	public StopLimitOrder(Derivative underlying, String buysell, float s, float l) {
		super(underlying, buysell);
		// TODO Auto-generated constructor stub
		limitprice = l;
		stopprice = s;
		
	}

	public float getstopprice(){
		return stopprice;
	}
	
	public float getlimitprice(){
		return limitprice;
	}
	
	public String toString(){
		return super.toString()+",StopLimit,"+getstopprice()+","+getlimitprice();
	}
	
	public StopLimitOrder(String id, String strategyid, String longshort,
			 String tag, Derivative underlying, String s, String l) {
		super(id, strategyid, longshort, tag, underlying);
		this.limitprice = Float.parseFloat(l);
		this.stopprice = Float.parseFloat(s);

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
