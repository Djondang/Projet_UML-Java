package contract;

public interface IBoulderDashController {
	 void play() throws InterruptedException;

	    IOrderPerformer getOrderPeformer();

		void saveCircuit(ISurf circuit);
}
