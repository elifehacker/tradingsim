package order;

import derivative.Derivative;

public abstract class Order implements Comparable<Order>{

	public static int getStrategyTotalid() {
		return strategytotal++;
	}

	public void setStrategyid(int s) {
		strategyid = s;
	}

	public int getStrategyid() {
		return strategyid;
	}
	
	public Derivative getUnderlying() {
		return underlying;
	}


	public String getLongShort() {
		return longshort;
	}

	public int getId() {
		return id;
	}

	private Derivative underlying;
	private String longshort;
	private String type;
	
	private float price;
	private static int total=0;
	private int id=0;
	
	private static int strategytotal = 0;
	private  int strategyid = 0;

	public Order(Derivative underlying, String buysell) {
		super();
		this.underlying = underlying;
		this.longshort = buysell;
		id = total;
		total++;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	@Override
	public int compareTo(Order o) {
		// TODO Auto-generated method stub
		return id-o.getId();
	}

}
