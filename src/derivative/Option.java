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
	public String getType() {
		return type;
	}
	
	public boolean compare(Option o){
		boolean b = super.compare(o);
		if(b == false) return false;
		if(!maturity.equals(o.getMaturity())) return false;
		if(strike!= o.getStrike()) return false;
		if(type.equals(o.getType())) return false;
		return true;
	}
		
	private String maturity;
	private float strike;
	private String type;
	
	public Option(float price, int volume, String symbol,
			String maturity, float strike, String type) {
		super(price, volume, symbol);
		this.maturity = maturity;
		this.strike = strike;
		this.type = type;
	}

	public Option( String id, String strategyid, String symbol,
			String price, String volume, String tag,
			String type, String strike,String maturity) {
		super( id,  strategyid,  symbol, price,  volume,  tag);
		this.maturity = maturity;
		this.strike = Float.parseFloat(strike);
		this.type = type;
		
	}
	
	public String toString(){
		return super.toString()+","+type+","+strike+","+maturity;
	}

}
