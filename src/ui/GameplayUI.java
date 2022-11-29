package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.SpriteNotFoundException;
import entity.towers.TowerType;
import main.GamePanel;
import main.Main;
import tile.ImageScaler;

public class GameplayUI {
	
	private GamePanel gp;
	private JPanel shop;
	private JLabel healthLabel, moneyLabel, shopLabel, turretLabel, cannonLabel, sniperLabel;
	private JButton turretButton, cannonButton, sniperButton;
	private BufferedImage heart, coin, turretShop, cannonShop, sniperShop;
	private Font arial30, arial50;
	
	public GameplayUI() throws SpriteNotFoundException{
		gp = GamePanel.getInstance();
		
		arial30 = new Font("arial", Font.PLAIN, 30);
		arial50 = new Font("arial", Font.PLAIN, 50);
		
		try {
			heart = ImageIO.read(getClass().getResourceAsStream("/ui/Lives.png"));
			heart = ImageScaler.scaleImage(heart, 30, 30);
			
			coin = ImageIO.read(getClass().getResourceAsStream("/ui/Money.png"));
			coin = ImageScaler.scaleImage(coin, 30, 30);
			
			turretShop = ImageIO.read(getClass().getResourceAsStream("/ui/UITurretButton.png"));
			turretShop = ImageScaler.scaleImage(turretShop, gp.TILE_SIZE * 2, gp.TILE_SIZE * 2);
			
			cannonShop = ImageIO.read(getClass().getResourceAsStream("/ui/UICannonButton.png"));
			cannonShop = ImageScaler.scaleImage(cannonShop, gp.TILE_SIZE * 2, gp.TILE_SIZE * 2);
			
			sniperShop = ImageIO.read(getClass().getResourceAsStream("/ui/UISniperButton.png"));
			sniperShop = ImageScaler.scaleImage(sniperShop, gp.TILE_SIZE * 2, gp.TILE_SIZE * 2);
		}
		catch(Exception e) {
			throw new SpriteNotFoundException("GameplayUI");
		}
		
		int shopX = gp.SCREEN_WIDTH - (4*gp.TILE_SIZE);
		shop = new JPanel();
		shop.setBounds(shopX, 0, gp.TILE_SIZE * 4, gp.SCREEN_HEIGHT);
		shop.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		shop.setAlignmentX(Component.CENTER_ALIGNMENT);
		shop.setBackground(new Color(94, 67, 15));
		shop.setOpaque(true);
		Main.getPane().add(shop, Integer.valueOf(1));
		
		shopLabel = new JLabel();
		setupLabel(shopLabel, arial50, "SHOP", Color.white, null);
		shopLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		shop.add(shopLabel, c);
		
		turretButton = new JButton(new ImageIcon(turretShop));
		turretButton.setBorder(BorderFactory.createEmptyBorder());
		turretButton.setContentAreaFilled(false);
		c.gridy++;
		shop.add(turretButton, c);
		
		turretLabel = new JLabel();
		setupLabel(turretLabel, arial30, String.valueOf(TowerType.TURRET.getCost()), Color.white, new ImageIcon(ImageScaler.scaleImage(coin, 30, 30)));
		turretLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridy++;
		shop.add(turretLabel, c);
		
		cannonButton = new JButton(new ImageIcon(cannonShop));
		cannonButton.setBorder(BorderFactory.createEmptyBorder());
		cannonButton.setContentAreaFilled(false);
		c.gridy++;
		shop.add(cannonButton, c);
		
		cannonLabel = new JLabel();
		setupLabel(cannonLabel, arial30, String.valueOf(TowerType.CANNON.getCost()), Color.white, new ImageIcon(ImageScaler.scaleImage(coin, 30, 30)));
		cannonLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridy++;
		shop.add(cannonLabel, c);
		
		sniperButton = new JButton(new ImageIcon(sniperShop));
		sniperButton.setBorder(BorderFactory.createEmptyBorder());
		sniperButton.setContentAreaFilled(false);
		c.gridy++;
		shop.add(sniperButton, c);
		
		sniperLabel = new JLabel();
		setupLabel(sniperLabel, arial30, String.valueOf(TowerType.SNIPER.getCost()), Color.white, new ImageIcon(ImageScaler.scaleImage(coin, 30, 30)));
		sniperLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridy++;
		shop.add(sniperLabel, c);
		
		healthLabel = new JLabel();
		setupLabel(healthLabel, arial30, String.valueOf(200), Color.white, new ImageIcon(heart));
		healthLabel.setHorizontalAlignment(JLabel.CENTER);
		healthLabel.setVerticalAlignment(JLabel.CENTER);
		healthLabel.setBounds(20, 20, 100, 30);
		Main.getPane().add(healthLabel, Integer.valueOf(1));
		
		moneyLabel = new JLabel();
		setupLabel(moneyLabel, arial30, String.valueOf(350), Color.white, new ImageIcon(coin));
		moneyLabel.setHorizontalAlignment(JLabel.CENTER);
		moneyLabel.setVerticalAlignment(JLabel.CENTER);
		moneyLabel.setBounds(120, 20, 150, 30);
		Main.getPane().add(moneyLabel, Integer.valueOf(1));
	}
	
	private void setupLabel(JLabel label, Font font, String text, Color foreground, ImageIcon icon) {
		label.setFont(font);
		label.setText(text);
		label.setForeground(foreground);
		label.setIcon(icon);
	}
	
}
