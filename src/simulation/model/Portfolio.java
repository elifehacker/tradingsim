package simulation.model;

import java.util.LinkedList;

import view.SimulationView;

public class Portfolio {

	public LinkedList<Derivative> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(LinkedList<Derivative> portfolio) {
		this.portfolio = portfolio;
	}

	private void updateIndexTable(){
		indextable = simulation.get_indextable();

	}
	
	public float getUnderlyingPrice(String sym){
		if(simulation.newtablecontent == true){
			updateIndexTable();
			simulation.newtablecontent = false;
		}
		float price = 0;
		for(String[] row : indextable){
			if(row[0].equals(sym)){
				price = Float.parseFloat(row[1]);
				break;
			}
		}
		return price;
	}
	
	private LinkedList<Derivative> portfolio;
	private SimulationView simulation;
	private String[][] indextable;
	
	public Portfolio(LinkedList<Derivative> portfolio, SimulationView sv) {
		super();
		this.portfolio = portfolio;
		this.simulation = sv;
	}




	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
