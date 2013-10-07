package derivative;

public class Stock extends Derivative {

	public Stock(float price, int volume, String symbol) {
		super(price, volume, symbol);
		// TODO Auto-generated constructor stub
	}
	public Stock( String id, String strategyid, String symbol,
			String price, String volume, String tag) {
		super( id,  strategyid,  symbol, price,  volume,  tag);
	}
}
