package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class BoulderDashView implements Runnable, KeyListener, IBoulderDashView{
	
	private static final int surfView   = 10;

    private static final int squareSize = 50;

    private Rectangle        closeView;

    private ISurf            surf;

    private IMobile          player;

    private int              view;

    private IOrderPerformer  orderPerformer;

    public InsaneVehiclesView(final IRoad road, final IMobile myVehicle) throws IOException {
        this.setView(surfView);
        this.setSurf(surf);
        this.setPlayer(player);
        this.getPlayer().getSprite().loadImage();
        this.setCloseView(new Rectangle(0, this.getPlayer().getY(), this.getSurf().getWidth(), surfView));
        SwingUtilities.invokeLater(this);
    }

    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public final void run() {
        final BoardFrame boardFrame = new BoardFrame("Close view");
        boardFrame.setDimension(new Dimension(this.getSurf().getWidth(), this.getSurf().getHeight()));
        boardFrame.setDisplayFrame(this.closeView);
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setHeightLooped(true);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);

        for (int x = 0; x < this.getSurf().getWidth(); x++) {
            for (int y = 0; y < this.getSurf().getHeight(); y++) {
                boardFrame.addSquare(this.Surf.getOnTheSurfXY(x, y), x, y);
            }
        }
        boardFrame.addPawn(this.getPlayer());

        this.getSurf().getObservable().addObserver(boardFrame.getObserver());
        this.followSurf();

        boardFrame.setVisible(true);
    }

    public final void show(final int yStart) {
        int y = yStart % this.getSurf().getHeight();
        for (int view = 0; view < this.getView(); view++) {
            for (int x = 0; x < this.getSurf().getWidth(); x++) {
                if ((x == this.getPlayer().getX()) && (y == yStart)) {
                    System.out.print(this.getPlayer().getSprite().getConsoleImage());
                } else {
                    System.out.print(this.getSurf().getOnTheRoadXY(x, y).getSprite().getConsoleImage());
                }
            }
            y = (y + 1) % this.getSurf().getHeight();
            System.out.print("\n");
        }
    }

    private static UserOrder keyCodeToUserOrder(final int keyCode) {
        UserOrder userOrder;
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                userOrder = UserOrder.RIGHT;
                break;
            case KeyEvent.VK_LEFT:
                userOrder = UserOrder.LEFT;
                break;
            case KeyEvent.VK_DOWN:
                userOrder = UserOrder.DOWN;
                break;
            case KeyEvent.VK_UP:
                userOrder = UserOrder.UP;
                break;
            default:
                userOrder = UserOrder.NOP;
                break;
        }
        return userOrder;
    }

    public void keyTyped(final KeyEvent keyEvent) {
     
    public final void keyPressed(final KeyEvent keyEvent) {
        try {
            this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }

    public void keyReleased(final KeyEvent keyEvent) {
        // Nop
    }

    public final void followPlayer() {
        this.getCloseView().y = this.getPlayer().getY() - 1;
    }

    private ISurf getSurf() {
        return this.Surf;
    }

    private void setSurf(final ISurf surf) throws IOException {
        this.surf = surf;
        for (int x = 0; x < this.getSurf().getWidth(); x++) {
            for (int y = 0; y < this.getSurf().getHeight(); y++) {
                this.getSurf().getOnTheSurfXY(x, y).getSprite().loadImage();
            }
        }
    }

    private IMobile getPlayer() {
        return this.Player;
    }

    private void setPlayer(final IMobile player) {
        this.player = player;
    }

    private int getView() {
        return this.view;
    }

    private void setView(final int view) {
        this.view = view;
    }

    private Rectangle getCloseView() {
        return this.closeView;
    }

    private void setCloseView(final Rectangle closeView) {
        this.closeView = closeView;
    }

    private IOrderPerformer getOrderPerformer() {
        return this.orderPerformer;
    }

    public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }
	

}
