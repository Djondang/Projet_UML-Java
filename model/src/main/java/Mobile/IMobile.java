package Mobile;

import java.awt.Point;

public interface IMobile {

	public void moveRigth();
	
	public  void moveLeft();
	
	public  void moveUp();

	public void moveDown();

	public void doNothing(); 

	
	public int getX();
	
	public int getY();
	
	public Boolean isAlive();
	
	public Boolean iscrached();
	
	public Point getposition();
}
