/*
 * Resources used: Google and tutorial
 * 
 * */

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	// this method returns the buffered image object of our 
	//loaded image
	
	private BufferedImage image;
	public  BufferedImage loadImage(String path)throws IOException
	{
		image = ImageIO.read(getClass().getResource(path));

		return image;
	}
}
 