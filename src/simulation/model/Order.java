package simulation.model;

public class Order implements Comparable<Order>{

	public Derivative getUnderlying() {
		return underlying;
	}


	public String getLongShort() {
		return longshort;
	}


	public String getType() {
		return type;
	}


	public float getPrice() {
		return price;
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
	
	
	public Order(Derivative underlying, String buysell, String type, float price) {
		super();
		this.underlying = underlying;
		this.longshort = buysell;
		this.type = type;
		this.price = price;
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
