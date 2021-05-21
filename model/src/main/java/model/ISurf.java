package model;

import java.util.Observable;

public interface ISurf {
	public int getWidth();
	public int getHeight();
	public IElement getOnTheSurfXY(int x, int y);
	public void setMobileHasChanged();
	public Observable getObservable();

}
