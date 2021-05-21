package model.element.mobile;

import java.awt.Point;

import model.ISurf;
import model.element.Permeability;
import model.element.Sprite;
import model.*;

public abstract class Mobile extends Element implements IMobile {

	private Point   position;

    private Boolean alive = true;

    private ISurf   surf;

    private IBoard  board;

    Mobile(final Sprite sprite, final ISurf surf, final Permeability permeability) {
        super(sprite, permeability);
        this.setSurf(surf);
        this.position = new Point();
    }

    Mobile(final int x, final int y, final Sprite sprite, final ISurf surf, final Permeability permeability) {
        this(sprite, surf, permeability);
        this.setX(x);
        this.setY(y);
    }

    public void moveUp() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
    }

    public void moveLeft() {
        this.setX(this.getX() - 1);
        this.setHasMoved();
    }

    public void moveDown() {
        this.setY(this.getY() - 1);
        this.setHasMoved();
    }
    
    public void moveRight() {
        this.setX(this.getX() + 1);
        this.setHasMoved();
    }

    public void doNothing() {
        this.setHasMoved();
    }

    private void setHasMoved() {
        this.getSurf().setMobileHasChanged();
    }

    public final int getX() {
        return this.getPosition().x;
    }

    public final void setX(final int x) {
        this.getPosition().x = x;
        if (this.isCrashed()) {
            this.die();
        }
    }

    public final int getY() {
        return this.getPosition().y;
    }

    public final void setY(final int y) {
        this.getPosition().y = (y + this.getRoad().getHeight()) % this.getRoad().getHeight();
        if (this.isCrashed()) {
            this.die();
        }
    }

    public ISurf getSurf() {
        return this.surf;
    }

    private void setSurf(final ISurf surf) {
        this.surf = surf;
    }

    public Boolean isAlive() {
        return this.alive;
    }

    protected void die() {
        this.alive = false;
        this.setHasMoved();
    }

    public Boolean isCrashed() {
        return this.getSurf().getOnTheSurfXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }
    
    public Point getPosition() {
        return this.position;
    }

    public void setPosition(final Point position) {
        this.position = position;
    }
    
    protected IBoard getBoard() {
        return this.board;
    }

}
