package Element;

import java.awt.Image;

public class Element {
	private Sprite sprite;
	
	private Permeability permeability;
	
	public Element(final Sprite sprite, final Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
    }

	public Sprite getSprite() {
		return this.sprite;
	}

	protected final void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}

	public Permeability getPermeability() {
		return permeability;
	}

	private void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}
	
	  public final Image getImage() {
	        return this.getSprite().getImage();
	    }
	

}
