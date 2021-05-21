package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

public class Surf implements ISurf{
	private int width;
	private int height;
	private IElement[][] onTheSurf;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	Surf(final String fileName) throws IOException {
		super();
		this.loadFile(fileName);
	}
	
	private void loadFile(final String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheRoad = new IElement[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheSurfXY(MotionlessElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
    }

    public final IElement getOnTheSurfXY(final int x, final int y) {
        return this.onTheSurf[x][y];
    }

    private void setOnTheSurfXY(final IElement element, final int x, final int y) {
        this.onTheSurf[x][y] = element;
    }
    
    public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    public Observable getObservable() {
        return this;
    }


}
