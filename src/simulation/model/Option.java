package simulation.model;

public class Option extends Derivative{

	public Stock getUnderlying() {
		return underlying;
	}

	public void setUnderlying(Stock underlying) {
		this.underlying = underlying;
	}

	public String getMaturity() {
		return maturity;
	}

	public void setMaturity(String maturity) {
		this.maturity = maturity;
	}

	public float getStrike() {
		return strike;
	}

	public void setStrike(float strike) {
		this.strike = strike;
	}

	public enum optiontype{call, put};
	
	private Stock underlying;
	private String maturity;
	private float strike;
	private optiontype type;
	
	public Option(float price, int volume, String symbol, Stock underlying,
			String maturity, float strike, optiontype type) {
		super(price, volume, symbol);
		this.underlying = underlying;
		this.maturity = maturity;
		this.strike = strike;
		this.type = type;
	}


}
