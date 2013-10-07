package order;

import derivative.Derivative;

public class MarketOrder extends Order{
	
	public MarketOrder(Derivative underlying, String buysell) {
		super(underlying, buysell);
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return super.toString()+",Market";
	}
	
	public MarketOrder(String id, String strategyid, String longshort,
			 String tag, Derivative underlying, String limitprice) {
		super(id, strategyid, longshort, tag, underlying);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
