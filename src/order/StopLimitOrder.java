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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
