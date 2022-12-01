package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.GamePanel;

/**
 * Test ui class used for learning. Will be refactored as paused state UI
 * @author Wizen
 *
 */
public class UI {
	GamePanel gp;
	Font arial_40;
	
	public UI() {
		gp = GamePanel.getInstance();
		arial_40 = new Font("Arial", Font.PLAIN, 40);
	}
	
	public void draw(Graphics2D g2) {
		g2.setFont(arial_40);
		g2.setColor(Color.WHITE);
		g2.drawString("Testing... Hello!", 50, 50);
	}
}
