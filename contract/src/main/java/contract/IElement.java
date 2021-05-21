package contract;

import java.awt.Image;
public interface IElement {
	Sprite getSprite();

    Permeability getPermeability();

    Image getImage();
    
    String getName();
}
