package model.element;

import java.awt.Image;

public interface IElement extends ISquare {

	Sprite getSprite();

	    
    Permeability getPermeability();

    Image getImage();

}
