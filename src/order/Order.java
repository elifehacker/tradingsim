package order;

import derivative.Derivative;

public abstract class Order implements Comparable<Order>{

	public static void incStrategyTotalid() {
		strategytotal++;
	}
	
	public String getTag(){
		return tag;
	}
	
	public void setTag(String t){
		tag = t;
		underlying.setTag(t);
	}
	
	public void setStrategyid(int s) {
		strategyid = s;
	}
	
	public void incStrategyid() {
		strategyid++;
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
	
	private static int total=0;
	private int id=0;
	
	private static int strategytotal = 0;
	private  int strategyid = 0;

	private String tag="";
	
	public Order(Derivative underlying, String buysell) {
		this.underlying = underlying;
		this.longshort = buysell;
		id = total;
		strategyid = strategytotal;
		underlying.setStrategyid(strategyid);
		total++;
	}

	public String toString(){
		return id+","+strategyid+","+longshort+","+tag;
	}

	public Order(String id, String strategyid, String longshort,
			 String tag, Derivative underlying) {
		super();
		this.underlying = underlying;
		this.longshort = longshort;
		this.id = Integer.parseInt(id);
		this.strategyid = Integer.parseInt(strategyid);
		this.tag = tag;
		if(total<=this.id){
			total = this.id+1;
		}
		if(strategytotal<=this.strategyid){
			strategytotal = this.strategyid+1;
		}
	}

	@Override
	public int compareTo(Order o) {
		// TODO Auto-generated method stub
		return id-o.getId();
	}

}
