package simulation.control;

import view.SimulationView;
import simulation.model.SimulationModel;

public class SimulationControl {

	private SimulationModel model;
	private static SimulationView view;
	
	public SimulationControl(SimulationModel m, SimulationView v) {
		// TODO Auto-generated constructor stub
		this.model = m;
		this.view = v;
		
		//add listeners, if have to
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
