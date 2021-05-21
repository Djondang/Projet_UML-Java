package model;

import java.io.IOException;
import java.util.Observable;

import Element.IElement;

public class Surf extends Observable implements ISurf {
	
	/** The width. */
    private int          width;

    /** The height. */
    private int          height;
    
    private IElement[][] onTheSurf;

	public int getWidth() {
		return this.width;
	}

	public void setWidth(final int width) {
		this.width = width;
	}

	public int getHeight() {
		return  this.height;
	}

	public void setHeight(final int height) {
		this.height = height;
	}

	Surf(final String fileName) throws IOException {
        super();
        this.loadFile(fileName);
  }

	public final IElement getOnTheSurfXY(final int x, final int y) {
        return this.onTheSurf[x][y];
    }

    private void setOnTheSurfXY(final IElement element, final int x, final int y) {
        this.onTheSurf[x][y] = element;
    }
	private void loadFile(String fileName) {
		// TODO Auto-generated method stub
		
	}

	public void setMobileHasChanged() {
		// TODO Auto-generated method stub
		
	}

	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}
}
