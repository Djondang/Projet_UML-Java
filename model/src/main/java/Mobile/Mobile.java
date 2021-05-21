package Mobile;

import java.awt.Point;

import Element.Permeability;
import Element.Sprite;
import model.ISurf;

public class Mobile {
	
	private Point   position;

	private Boolean alive = true;
	
	private ISurf surf;
	
	public Point getPosition() {
		return position;
	}

	public void setPosition(final Point position) {
		this.position = position;
	}

	 Mobile( final Sprite sprite, final ISurf surf, final Permeability permeability) {
	        super();
	       // this.setsurf(surf);
	        this.position = new Point();
	    }
	 Mobile(final int x, final int y, final Sprite sprite, final ISurf surf, final Permeability permeability) {
	        this(sprite, surf, permeability);
	        this.setX(x);
	        this.setY(y);
	
	 }  
	 public void moveUp() {
		 this.setY(this.getY() - 1);
	        this.setHasMoved();
	 }
	 public void Left() {
		 this.setY(this.getY() - 1);
	        this.setHasMoved();
	 }
	 public void Down() {
		 this.setY(this.getY() + 1);
	        this.setHasMoved();
	 }
	 public void Right() {
		 this.setY(this.getY() + 1);
	        this.setHasMoved();
	 }
	 public void doNothing() {
	        this.setHasMoved();
	 }
	 
	 private void setHasMoved() {
	        //return this.getboard().getOnTheboardXY(this.getx(), this.getY()).getPermeability() == Permeability.BLOCKING;
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
	        this.getPosition().y = (y + this.getSurf().getHeight()) % this.getSurf().getHeight();
	        if (this.isCrashed()) {
	            this.die();
	        }
	 }
	 
	 public ISurf getSurf() {
		 return this.getSurf();
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
	 
	        
	        
}

		
