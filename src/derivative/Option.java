package derivative;

public class Option extends Derivative{

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
	public optiontype getType() {
		return type;
	}
	
	public boolean compare(Option o){
		boolean b = super.compare(o);
		if(b == false) return false;
		if(!maturity.equals(o.getMaturity())) return false;
		if(strike!= o.getStrike()) return false;
		if(type!= o.getType()) return false;
		return true;
	}
	
	public static enum optiontype{call, put};
	
	private String maturity;
	private float strike;
	private optiontype type;
	
	public Option(float price, int volume, String symbol,
			String maturity, float strike, optiontype type) {
		super(price, volume, symbol);
		this.maturity = maturity;
		this.strike = strike;
		this.type = type;
	}


}
