package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Generic toolbox class, currently only used to resize images
 * @author Ryan Sharp
 *
 */
public class UtilityCenter {
	
	/**
	 * rescale a given image to the given width and height desired
	 * @param image
	 * @param width
	 * @param height
	 * @return
	 */
	public static BufferedImage scaleImage(BufferedImage image, int width, int height) {
		BufferedImage scaledImage = new BufferedImage(width, height, image.getType());
		Graphics2D g2 = scaledImage.createGraphics();
		g2.setBackground(null);
		g2.drawImage(image, 0, 0, width, height, null);
		g2.dispose();
		return scaledImage;
	}
}
