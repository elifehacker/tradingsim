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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
