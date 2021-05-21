package model.element.mobile;

import java.awt.Point;

public interface IMobile extends IPawn, IElement {
	
	void moveUp();

    void moveLeft();

    void moveDown();

    void moveRight();

    void doNothing();

    int getX();

    int getY();

    Boolean isAlive();

    Boolean isCrashed();

    Point getPosition();


}
