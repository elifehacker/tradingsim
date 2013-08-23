package simulation.model;

public abstract class Derivative implements Comparable<Derivative>{
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	private float price;
	private int volume;
	private String symbol;
	private static int total=0;
	private int id=0;

	
	public Derivative(float price, int volume, String symbol) {
		super();
		this.price = price;
		this.volume = volume;
		this.symbol = symbol;
		id = total;
		total++;
	}

	public int getId(){
		return id;
	}
	
	public String getSymbol(){
		return symbol;
	}

	public float getTotal(){
		return price * volume;
	}	
	public int compareTo(Derivative s) {
		// TODO Auto-generated method stub
		System.out.println("compareTo "+id+" "+s.getId());

		int num = this.getId() - s.getId();		
		return num;
	}
}
