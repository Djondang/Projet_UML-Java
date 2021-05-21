package controller;

import model.ISurf;

public interface IBoulderDashController {
	public void play() throws InterruptedException;
	public IOrderPerformer getOrderPerformer();
	public void saveCircuit(ISurf surf);


}
