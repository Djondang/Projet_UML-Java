package model;

import java.util.Observable;

import Element.IElement;

public interface ISurf {

	public int getWidth();

   
  //  private void setWidth(final int width) {
    //    this.width = width;
    //}

 
    public  int getHeight();

    //private void setHeight(final int height) {
      //  this.height = height;
    //}
    
    public IElement getOnTheSurfXY(int x,int y);
    
    void setMobileHasChanged();

  
    Observable getObservable();
    
    
}
