package order;

import derivative.Derivative;

public class StopOrder extends Order{

	private float stopprice;
	
	public StopOrder(Derivative underlying, String buysell, float s) {
		super(underlying, buysell);
		// TODO Auto-generated constructor stub
		this.stopprice = s;
	}

	public float getstopprice(){
		return stopprice;
	}
	
	public String toString(){
		return super.toString()+",Stop,"+getstopprice();
	}
	
	public StopOrder(String id, String strategyid, String longshort,
			 String tag, Derivative underlying, String s) {
		super(id, strategyid, longshort, tag, underlying);
		this.stopprice = Float.parseFloat(s);

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
