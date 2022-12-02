package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UtilityCenter {
	public static BufferedImage scaleImage(BufferedImage image, int width, int height) {
		BufferedImage scaledImage = new BufferedImage(width, height, image.getType());
		Graphics2D g2 = scaledImage.createGraphics();
		g2.setBackground(null);
		g2.drawImage(image, 0, 0, width, height, null);
		g2.dispose();
		return scaledImage;
	}
}
