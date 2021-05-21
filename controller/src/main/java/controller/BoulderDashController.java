package controller;

import java.io.IOException;

public class BoulderDashController implements IBoulderDashController,IOrderPerformer  {

    private static final int     speed = 30;

  
    private IBoulderDashView  view;

    private IBoulderDashModel model;

    private UserOrder            stackOrder;

    public BoulderDashController(final IBoulderDashView view, final IBoulderDashModel model) {
        this.setView(view);
        this.setModel(model);
        this.clearStackOrder();
    }

    public final void play() throws InterruptedException {
        while (this.getModel().getMyVehicle().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getPlayer().moveRight();
                    break;
                case LEFT:
                    this.getModel().getPlayer().moveLeft();
                    break;
                case DOWN;
                	this.getModel().getPlayer().moveDown();
                	break;
                case UP;
                	this.getModel().getPlayer().moveUp();
                	break;
                case NOP:
                default:
                    this.getModel().getPlayer().doNothing();
                    break;
            }
            this.clearStackOrder();
            if (this.getModel().getPlayer().isAlive()) {
                this.getModel().getPlayer().moveDown();
            }
            this.getView().followPlayer();
        }
        this.getView().displayMessage("CRASH !!!!!!!!!.");
    }

    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }

    private IBoulderDashView getView() {
        return this.view;
    }

    private void setView(final IBoulderDashView view) {
        this.view = view;
    }

    private IBoulderDashModel getModel() {
        return this.model;
    }

    private void setModel(final IBoulderDashModel model) {
        this.model = model;
    }

    private UserOrder getStackOrder() {
        return this.stackOrder;
    }

    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }

    public IOrderPerformer getOrderPeformer() {
        return this;
    }
	

}
