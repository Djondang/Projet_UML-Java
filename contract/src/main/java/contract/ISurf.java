package contract;

import java.util.Observable;

@SuppressWarnings("deprecation")
public interface ISurf {
	
	 int getWidth();

	 int getHeight();

	 IElement getOnTheRoadXY(int x, int y);

	 void setMobileHasChanged();

	 Observable getObservable();
}
