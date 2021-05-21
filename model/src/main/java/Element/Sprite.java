package Element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	
	private Image image;
	
	private String imageName;
	
	private char consoleImage;
	
	private boolean imageLoaded;

	
	public Image getImage() {
		return image;
	}

	public void setImage(final Image image) {
		this.image = image;
	}

	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(final String imageName) {
		this.imageName = imageName;
	}

	public char getConsoleImage() {
		return this.consoleImage;
	}

	public void setConsoleImage(final char consoleImage) {
		this.consoleImage = consoleImage;
	}
	
	 public final boolean isImageLoaded() {
	        return this.imageLoaded;
	    }
	    public final void setImageLoaded(final boolean isImageLoaded) {
	        this.imageLoaded = isImageLoaded;
	    }
	    
	    public Sprite(final char character, final String imageName) {
	        this.setConsoleImage(character);
	        this.setImageName(imageName);
	    }
	
	    public Sprite(final char character) {
	        this(character, "noimage.jpg");
	    }
	    
	    public final void loadImage() throws IOException {
	        this.setImage(ImageIO.read(new File("images/" + this.getImageName())));
	    }
}
