package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import entity.SpriteNotFoundException;
import entity.towers.CannonTower;
import entity.towers.SniperTower;
import entity.towers.TowerType;
import entity.towers.TurretTower;
import main.GamePanel;
import main.GameplayState;
import main.InsufficientFundsException;
import main.Main;
import main.PlacementState;
import tile.ImageScaler;
import levels.Level;

/**
 * UI class to display the proper UI during the gameplay state
 * @author Ryan Sharp
 *
 */
public class GameplayUI {
	
	private GamePanel gp;
	private JPanel shop;
	private JLabel healthLabel, moneyLabel, shopLabel, turretLabel, cannonLabel, sniperLabel;
	private JButton turretButton, cannonButton, sniperButton, startButton, toggleShopButton;
	private BufferedImage heart, coin, turretShop, cannonShop, sniperShop, start, wait;
	private Font arial30, arial50;
	private GameplayUIButtonHandler listener;
	private boolean waveRunning = false;
	
	/**
	 * Create new gameplay UI
	 * @throws SpriteNotFoundException - Thrown if the images needed cannot be found.
	 */
	public GameplayUI() throws SpriteNotFoundException{
		gp = GamePanel.getInstance();
		listener = new GameplayUIButtonHandler();
		
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
			
			start = ImageIO.read(getClass().getResourceAsStream("/ui/StartButton.png"));
			start = ImageScaler.scaleImage(start, gp.TILE_SIZE * 2, gp.TILE_SIZE * 2);
			
			wait = ImageIO.read(getClass().getResourceAsStream("/ui/WaitButton.png"));
			wait = ImageScaler.scaleImage(wait, gp.TILE_SIZE * 2, gp.TILE_SIZE * 2);
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
		
		shopLabel = new JLabel();
		setupLabel(shopLabel, arial50, "SHOP", Color.white, null);
		shopLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		shop.add(shopLabel, c);
		
		turretButton = new JButton(new ImageIcon(turretShop));
		turretButton.setBorder(BorderFactory.createEmptyBorder());
		turretButton.setContentAreaFilled(false);
		turretButton.addActionListener(listener);
		turretButton.setActionCommand("Buy Turret");
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
		cannonButton.addActionListener(listener);
		cannonButton.setActionCommand("Buy Cannon");
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
		sniperButton.addActionListener(listener);
		sniperButton.setActionCommand("Buy Sniper");
		c.gridy++;
		shop.add(sniperButton, c);
		
		sniperLabel = new JLabel();
		setupLabel(sniperLabel, arial30, String.valueOf(TowerType.SNIPER.getCost()), Color.white, new ImageIcon(ImageScaler.scaleImage(coin, 30, 30)));
		sniperLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridy++;
		shop.add(sniperLabel, c);
		
		startButton = new JButton(new ImageIcon(start));
		startButton.setBorder(BorderFactory.createEmptyBorder());
		startButton.setContentAreaFilled(false);
		startButton.addActionListener(listener);
		startButton.setActionCommand("Start");
		c.gridy++;
		shop.add(startButton, c);
		
		Main.getPane().add(shop, Integer.valueOf(1));
		
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
	
	/**
	 * Helper method to set up labels more concisely. Set the label, font, text, foreground color, and icon of a label.
	 * @param label
	 * @param font
	 * @param text
	 * @param foreground
	 * @param icon
	 */
	private void setupLabel(JLabel label, Font font, String text, Color foreground, ImageIcon icon) {
		label.setFont(font);
		label.setText(text);
		label.setForeground(foreground);
		label.setIcon(icon);
	}
	
	/**
	 * Removes the UI from the screen. Used when switching states. Otherwise the UI will still be visible in other states.
	 */
	public void remove() {
		Main.getPane().remove(shop);
		Main.getPane().remove(healthLabel);
		Main.getPane().remove(moneyLabel);
	}
	
	/**
	 * Set whether the enemy wave is currently running
	 * @param running - True if running, false otherwise
	 */
	public void setWaveRunning(boolean running) {
		if(running != waveRunning) {
			waveRunning = running;
			if(running) {
				startButton.setIcon(new ImageIcon(wait));
			}
			else {
				startButton.setIcon(new ImageIcon(start));
			}
		}
	}
	
	/**
	 * Set the text of the health label to the value given
	 * @param amt - Value label should be set to
	 */
	public void setHealth(int amt) { healthLabel.setText(String.valueOf(amt)); }
	
	/**
	 * Set the text of the money lable to the value given
	 * @param amt - Value label should be set to
	 */
	public void setMoney(int amt) { moneyLabel.setText(String.valueOf(amt)); }
	
	private class GameplayUIButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Player pressed button: " + e.getActionCommand());
			
			Point p = MouseInfo.getPointerInfo().getLocation();
			SwingUtilities.convertPointFromScreen(p, gp);
			
			GameplayState current = (GameplayState)gp.getState();
			
			switch(e.getActionCommand()) {
			case ("Buy Turret"):
				try {
					gp.getState().getPlayer().removeMoney(TowerType.TURRET.getCost());
					gp.updateState(new PlacementState(current.getLevel(), current.getTowerManager(), current.getEnemyManager(), current.getPlayer(), new TurretTower(p.x, p.y)));
				}
				catch(InsufficientFundsException ex) {
					System.out.println(ex.getMessage());
				}
			
				break;
			case ("Buy Cannon"):
				try {
					gp.getState().getPlayer().removeMoney(TowerType.CANNON.getCost());
					gp.updateState(new PlacementState(current.getLevel(), current.getTowerManager(), current.getEnemyManager(), current.getPlayer(), new CannonTower(p.x, p.y)));
				}
				catch(InsufficientFundsException ex) {
					System.out.println(ex.getMessage());
				}
				
				break;
			case("Buy Sniper"):
				try {
					gp.getState().getPlayer().removeMoney(TowerType.SNIPER.getCost());
					gp.updateState(new PlacementState(current.getLevel(), current.getTowerManager(), current.getEnemyManager(), current.getPlayer(), new SniperTower(p.x, p.y)));
				}
				catch(InsufficientFundsException ex) {
					System.out.println(ex.getMessage());
				}
				
				break;
			case("Start"):
				if(!waveRunning) {
					gp.getState().getEnemyManager().getWaves().nextWave();
					setWaveRunning(true);
				}
				break;
			}
			
			gp.requestFocusInWindow();
		}
		
	}
	
}
