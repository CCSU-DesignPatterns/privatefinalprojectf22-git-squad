package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import main.UtilityCenter;

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
	private BufferedImage heart, coin, turretShop, cannonShop, sniperShop, start, wait, openShop, closeShop;
	private Font arial30, arial20;
	private GameplayUIButtonHandler listener;
	private boolean waveRunning;
	
	/**
	 * Create new gameplay UI
	 * @throws SpriteNotFoundException - Thrown if the images needed cannot be found.
	 */
	public GameplayUI() throws SpriteNotFoundException{
		waveRunning = false;
		gp = GamePanel.getInstance();
		listener = new GameplayUIButtonHandler();
		
		arial30 = new Font("arial", Font.PLAIN, 30);
		arial20 = new Font("arial", Font.PLAIN, 20);
		
		try {
			heart = ImageIO.read(getClass().getResourceAsStream("/ui/Lives.png"));
			heart = UtilityCenter.scaleImage(heart, 30, 30);
			
			coin = ImageIO.read(getClass().getResourceAsStream("/ui/Money.png"));
			coin = UtilityCenter.scaleImage(coin, 30, 30);
			
			turretShop = ImageIO.read(getClass().getResourceAsStream("/ui/UITurretButton.png"));
			turretShop = UtilityCenter.scaleImage(turretShop, gp.TILE_SIZE, gp.TILE_SIZE);
			
			cannonShop = ImageIO.read(getClass().getResourceAsStream("/ui/UICannonButton.png"));
			cannonShop = UtilityCenter.scaleImage(cannonShop, gp.TILE_SIZE, gp.TILE_SIZE);
			
			sniperShop = ImageIO.read(getClass().getResourceAsStream("/ui/UISniperButton.png"));
			sniperShop = UtilityCenter.scaleImage(sniperShop, gp.TILE_SIZE, gp.TILE_SIZE);
			
			start = ImageIO.read(getClass().getResourceAsStream("/ui/StartButton.png"));
			start = UtilityCenter.scaleImage(start, gp.TILE_SIZE, gp.TILE_SIZE);
			
			wait = ImageIO.read(getClass().getResourceAsStream("/ui/WaitButton.png"));
			wait = UtilityCenter.scaleImage(wait, gp.TILE_SIZE, gp.TILE_SIZE);
			
			openShop = ImageIO.read(getClass().getResourceAsStream("/ui/ShopButton.png"));
			openShop = UtilityCenter.scaleImage(openShop, 30, 30);
			
			closeShop = ImageIO.read(getClass().getResourceAsStream("/ui/CloseButton.png"));
			closeShop = UtilityCenter.scaleImage(closeShop, 30, 30);
		}
		catch(Exception e) {
			throw new SpriteNotFoundException("GameplayUI");
		}
		
		int shopX = gp.SCREEN_WIDTH - (3*gp.TILE_SIZE);
		shop = new JPanel();
		shop.setBounds(shopX, 0, gp.TILE_SIZE * 3, gp.SCREEN_HEIGHT / 2);
		shop.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		shop.setAlignmentX(Component.CENTER_ALIGNMENT);
		shop.setBackground(new Color(94, 67, 15));
		shop.setOpaque(true);
		
		shopLabel = new JLabel();
		setupLabel(shopLabel, arial30, "SHOP", Color.white, null);
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
		setupLabel(turretLabel, arial20, String.valueOf(TowerType.TURRET.getCost()), Color.white, new ImageIcon(UtilityCenter.scaleImage(coin, 20, 20)));
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
		setupLabel(cannonLabel, arial20, String.valueOf(TowerType.CANNON.getCost()), Color.white, new ImageIcon(UtilityCenter.scaleImage(coin, 20, 20)));
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
		setupLabel(sniperLabel, arial20, String.valueOf(TowerType.SNIPER.getCost()), Color.white, new ImageIcon(UtilityCenter.scaleImage(coin, 20, 20)));
		sniperLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridy++;
		shop.add(sniperLabel, c);
		
		Main.getPane().add(shop, Integer.valueOf(1));
		
		toggleShopButton = new JButton(new ImageIcon(closeShop));
		toggleShopButton.setBounds(gp.SCREEN_WIDTH - 50, 20, 30, 30);
		toggleShopButton.setBorder(BorderFactory.createEmptyBorder());
		toggleShopButton.setContentAreaFilled(false);
		toggleShopButton.addActionListener(listener);
		toggleShopButton.setActionCommand("Toggle Shop");
		shop.add(toggleShopButton, c);
		Main.getPane().add(toggleShopButton, Integer.valueOf(2));
		
		
		startButton = new JButton(new ImageIcon(start));
		startButton.setBounds((int)(gp.SCREEN_WIDTH - (1.5 * gp.TILE_SIZE)), (int)(gp.SCREEN_HEIGHT - (1.5 * gp.TILE_SIZE)), gp.TILE_SIZE, gp.TILE_SIZE);
		startButton.setBorder(BorderFactory.createEmptyBorder());
		startButton.setContentAreaFilled(false);
		startButton.addActionListener(listener);
		startButton.setActionCommand("Start");
		Main.getPane().add(startButton, Integer.valueOf(2));
		
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
		Main.getPane().remove(startButton);
		Main.getPane().remove(toggleShopButton);
	}
	
	/**
	 * Set whether the enemy wave is currently running
	 * @param running - True if running, false otherwise
	 */
	public void setWaveRunning(boolean running) {
		if(running != waveRunning) {
			System.out.println("updating running status");
			this.waveRunning = running;
			if(waveRunning) {
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
			case("Toggle Shop"):
				if(shop.isVisible()) {
					shop.setVisible(false);
					toggleShopButton.setIcon(new ImageIcon(openShop));
				}
				else {
					shop.setVisible(true);
					toggleShopButton.setIcon(new ImageIcon(closeShop));
				}
				break;
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
