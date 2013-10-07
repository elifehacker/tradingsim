package action;

import derivative.Derivative;

public class Action {

	public String getTime() {
		return time;
	}

	public String getDesc() {
		return desc;
	}

	public Derivative getUnderlying() {
		return underlying;
	}

	private String time;
	private String desc;
	
	private Derivative underlying;
	
	public Action(String time, String desc, Derivative underlying) {
		super();
		this.time = time;
		this.desc = desc;
		this.underlying = underlying;
	}

	public String toString(){
		return time+","+desc;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
