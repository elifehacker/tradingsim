package order;

import derivative.Derivative;

public class LimitOrder extends Order{

	private float limitprice;
	
	public LimitOrder(Derivative underlying, String buysell, float l) {
		super(underlying, buysell);
		// TODO Auto-generated constructor stub
		this.limitprice = l;
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
