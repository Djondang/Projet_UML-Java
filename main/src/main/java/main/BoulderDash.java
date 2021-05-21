package main;

import controller.IBoulderDashController;
import model.IBoulderDashModel;
import view.BoulderDashView;

import java.io.IOException;

import contract.*;

public abstract class BoulderDash {
	 
    private static final int startX = 5;

    private static final int startY = 0;

    public static void main(final String[] args) throws IOException, InterruptedException {
        final IBoulderDashModel model = new IBoulderDashModel("Surf1.txt", startX, startY);
        final BoulderDashView view = new BoulderDashView(model.getSurf(), model.getPlayer());
        final IBoulderDashController controller = new IBoulderDashController(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());
        //controller.play();
        controller.saveCircuit(model.getSurf());
    }
}
