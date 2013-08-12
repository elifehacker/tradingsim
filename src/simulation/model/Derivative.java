package simulation.model;

public abstract class Derivative {
	
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


	public Derivative(float price, int volume, String symbol) {
		super();
		this.price = price;
		this.volume = volume;
		this.symbol = symbol;
	}

	public String getSymbol(){
		return symbol;
	}

	public float getTotal(){
		return price * volume;
	}

	
	
	
}
