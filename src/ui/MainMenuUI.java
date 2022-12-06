package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.SpriteNotFoundException;
import entity.enemies.Difficulty;
import entity.enemies.EnemyManager;
import entity.towers.TowerManager;
import levels.Level;
import levels.Level1;
import levels.Level2;
import levels.Level3;
import levels.LevelDifficulty;
import main.GamePanel;
import main.GameplayState;
import main.Main;
import main.Player;
import main.UtilityCenter;

/**
 * Responsible for displaying and updating the swing components of the main menu
 * @author Ryan Sharp
 *
 */
public class MainMenuUI {
	private GamePanel gp;
	private JLabel title, credits, levels, difficulties;
	private JButton play, quit, level1, level2, level3, easy, medium, hard, backButton;
	private JPanel titleScreen, levelSelect, difficultySelect;
	private BufferedImage turret, cannon, sniper, redEnemy, blueEnemy, greenEnemy, orangeEnemy, purpleEnemy, back;
	private Font arial20, arial40, arial80;
	private MainMenuUIButtonHandler listener;
	private int screen;
	private Level selectedLevel;
	private Difficulty selectedDifficulty;
	private LevelDifficulty selectedLevelDifficulty;
	
	/**
	 * Create new Main Menu UI
	 * @throws SpriteNotFoundException 
	 */
	public MainMenuUI() throws SpriteNotFoundException {
		gp = GamePanel.getInstance();
		listener = new MainMenuUIButtonHandler();
		screen = 0;
		
		arial20 = new Font("arial", Font.PLAIN, 20);
		arial40 = new Font("arial", Font.PLAIN, 40);
		arial80 = new Font("arial", Font.PLAIN, 80);
		
		try {
			turret = ImageIO.read(getClass().getResourceAsStream("/towers/Turret.png"));
			turret = UtilityCenter.scaleImage(turret, gp.TILE_SIZE * 2, gp.TILE_SIZE * 2);
			
			cannon = ImageIO.read(getClass().getResourceAsStream("/towers/Cannon.png"));
			cannon = UtilityCenter.scaleImage(cannon, gp.TILE_SIZE * 2, gp.TILE_SIZE * 2);
			
			sniper = ImageIO.read(getClass().getResourceAsStream("/towers/Sniper.png"));
			sniper = UtilityCenter.scaleImage(sniper, gp.TILE_SIZE * 2, gp.TILE_SIZE * 2);
			
			redEnemy = ImageIO.read(getClass().getResourceAsStream("/enemies/EnemyRed.png"));
			redEnemy = UtilityCenter.scaleImage(redEnemy, gp.TILE_SIZE * 2, gp.TILE_SIZE * 2);
			
			blueEnemy = ImageIO.read(getClass().getResourceAsStream("/enemies/EnemyBlue.png"));
			blueEnemy = UtilityCenter.scaleImage(blueEnemy, gp.TILE_SIZE * 2, gp.TILE_SIZE * 2);
			
			greenEnemy = ImageIO.read(getClass().getResourceAsStream("/enemies/EnemyGreen.png"));
			greenEnemy = UtilityCenter.scaleImage(greenEnemy, gp.TILE_SIZE * 2, gp.TILE_SIZE * 2);
			
			orangeEnemy = ImageIO.read(getClass().getResourceAsStream("/enemies/EnemyOrange.png"));
			orangeEnemy = UtilityCenter.scaleImage(orangeEnemy, gp.TILE_SIZE * 2, gp.TILE_SIZE * 2);
			
			purpleEnemy = ImageIO.read(getClass().getResourceAsStream("/enemies/EnemyPurple.png"));
			purpleEnemy = UtilityCenter.scaleImage(purpleEnemy, gp.TILE_SIZE * 2, gp.TILE_SIZE * 2);
			
			back = ImageIO.read(getClass().getResourceAsStream("/ui/BackButton.png"));
			back = UtilityCenter.scaleImage(back, gp.TILE_SIZE, gp.TILE_SIZE);
		}
		catch(Exception e) {
			throw new SpriteNotFoundException("GameplayUI");
		}
		
		titleScreen = new JPanel();
		titleScreen.setBounds(0,0, gp.SCREEN_WIDTH, gp.SCREEN_HEIGHT);
		titleScreen.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		titleScreen.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleScreen.setBackground(new Color(23, 102, 27));
		titleScreen.setOpaque(true);
		titleScreen.setVisible(true);
		
		title = new JLabel();
		title.setFont(arial80);
		title.setText("Tower Defense");
		title.setForeground(Color.white);
		title.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		titleScreen.add(title, c);
		
		credits = new JLabel();
		credits.setFont(arial20);
		credits.setText("A game by Ryan Sharp and Ricardo Almeida");
		credits.setForeground(Color.white);
		credits.setHorizontalAlignment(JLabel.CENTER);
		c.gridy++;
		titleScreen.add(credits, c);
		
		play = new JButton();
		play.setFont(arial40);
		play.setText("PLAY");
		play.addActionListener(listener);
		play.setActionCommand("Play");
		c.gridy++;
		c.insets = new Insets(gp.TILE_SIZE * 2, 0, 0, 0);
		titleScreen.add(play, c);
		
		quit = new JButton();
		quit.setFont(arial40);
		quit.setText("QUIT");
		quit.addActionListener(listener);
		quit.setActionCommand("Quit");
		c.gridy++;
		c.insets = new Insets(gp.TILE_SIZE, 0, 0, 0);
		titleScreen.add(quit, c);
		
		Main.getPane().add(titleScreen, Integer.valueOf(1));
		
		levelSelect = new JPanel();
		levelSelect.setBounds(0,0, gp.SCREEN_WIDTH, gp.SCREEN_HEIGHT);
		levelSelect.setLayout(new GridBagLayout());
		levelSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
		levelSelect.setBackground(new Color(23, 102, 27));
		levelSelect.setOpaque(true);
		levelSelect.setVisible(false);
		
		levels = new JLabel();
		levels.setFont(arial40);
		levels.setText("Level Select");
		levels.setForeground(Color.white);
		levels.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		levelSelect.add(levels, c);
		
		level1 = new JButton();
		level1.setFont(arial40);
		level1.setText("GRASS");
		level1.addActionListener(listener);
		level1.setActionCommand("Level 1");
		c.gridy++;
		levelSelect.add(level1, c);
		
		level2 = new JButton();
		level2.setFont(arial40);
		level2.setText("SAND");
		level2.addActionListener(listener);
		level2.setActionCommand("Level 2");
		c.gridy++;
		levelSelect.add(level2, c);
		
		level3 = new JButton();
		level3.setFont(arial40);
		level3.setText("SNOW");
		level3.addActionListener(listener);
		level3.setActionCommand("Level 3");
		c.gridy++;
		levelSelect.add(level3, c);
		
		Main.getPane().add(levelSelect, Integer.valueOf(1));
		
		difficultySelect = new JPanel();
		difficultySelect.setBounds(0,0, gp.SCREEN_WIDTH, gp.SCREEN_HEIGHT);
		difficultySelect.setLayout(new GridBagLayout());
		difficultySelect.setAlignmentX(Component.CENTER_ALIGNMENT);
		difficultySelect.setBackground(new Color(23, 102, 27));
		difficultySelect.setOpaque(true);
		difficultySelect.setVisible(false);
		
		difficulties = new JLabel();
		difficulties.setFont(arial40);
		difficulties.setText("Difficulty Select");
		difficulties.setForeground(Color.white);
		difficulties.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		difficultySelect.add(difficulties, c);
		
		easy = new JButton();
		easy.setFont(arial40);
		easy.setText("EASY");
		easy.addActionListener(listener);
		easy.setActionCommand("Easy");
		c.gridy++;
		difficultySelect.add(easy, c);
		
		medium = new JButton();
		medium.setFont(arial40);
		medium.setText("MEDIUM");
		medium.addActionListener(listener);
		medium.setActionCommand("Medium");
		c.gridy++;
		difficultySelect.add(medium, c);
		
		hard = new JButton();
		hard.setFont(arial40);
		hard.setText("HARD");
		hard.addActionListener(listener);
		hard.setActionCommand("Hard");
		c.gridy++;
		difficultySelect.add(hard, c);
		
		Main.getPane().add(difficultySelect, Integer.valueOf(1));
		
		backButton = new JButton(new ImageIcon(back));
		backButton.setBounds((int)(gp.SCREEN_WIDTH - (1.5 * gp.TILE_SIZE)), (int)(gp.SCREEN_HEIGHT - (1.5 * gp.TILE_SIZE)), gp.TILE_SIZE, gp.TILE_SIZE);
		backButton.setBorder(BorderFactory.createEmptyBorder());
		backButton.setContentAreaFilled(false);
		backButton.addActionListener(listener);
		backButton.setActionCommand("Back");
		backButton.setVisible(false);
		
		Main.getPane().add(backButton, Integer.valueOf(2));
	}
	
	/**
	 * Remove this UI from the screen
	 */
	public void remove() {
		Main.getPane().remove(titleScreen);
		Main.getPane().remove(levelSelect);
		Main.getPane().remove(difficultySelect);
		Main.getPane().remove(backButton);
	}
	
	private class MainMenuUIButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Player pressed button: " + e.getActionCommand());
			
			switch(e.getActionCommand()) {
			case("Play"):
				titleScreen.setVisible(false);
				levelSelect.setVisible(true);
				backButton.setVisible(true);
				screen = 1;
				break;
			case("Quit"):
				System.exit(0);
				break;
			case("Level 1"):
				selectedLevel = new Level1();
				levelSelect.setVisible(false);
				difficultySelect.setVisible(true);
				screen = 2;
				break;
			case("Level 2"):
				selectedLevel = new Level2();
				levelSelect.setVisible(false);
				difficultySelect.setVisible(true);
				screen = 2;
				break;
			case("Level 3"):
				selectedLevel = new Level3();
				levelSelect.setVisible(false);
				difficultySelect.setVisible(true);
				screen = 2;
				break;
			case("Easy"):
				selectedDifficulty = Difficulty.EASY;
				selectedLevelDifficulty = LevelDifficulty.EASY;
				gp.updateState(new GameplayState(selectedLevel, new TowerManager(), new EnemyManager(selectedLevel, selectedDifficulty), new Player(selectedLevelDifficulty.getStartingHealth(), selectedLevelDifficulty.getStartingMoney())));
				break;
			case("Medium"):
				selectedDifficulty = Difficulty.MEDIUM;
				selectedLevelDifficulty = LevelDifficulty.MEDIUM;
				gp.updateState(new GameplayState(selectedLevel, new TowerManager(), new EnemyManager(selectedLevel, selectedDifficulty), new Player(selectedLevelDifficulty.getStartingHealth(), selectedLevelDifficulty.getStartingMoney())));
				break;
			case("Hard"):
				selectedDifficulty = Difficulty.HARD;
				selectedLevelDifficulty = LevelDifficulty.HARD;
				gp.updateState(new GameplayState(selectedLevel, new TowerManager(), new EnemyManager(selectedLevel, selectedDifficulty), new Player(selectedLevelDifficulty.getStartingHealth(), selectedLevelDifficulty.getStartingMoney())));
				break;
			case("Back"):
				if(screen == 2) {
					difficultySelect.setVisible(false);
					levelSelect.setVisible(true);
					screen = 1;
				}
				else if(screen == 1) {
					levelSelect.setVisible(false);
					titleScreen.setVisible(true);
					screen = 0;
					backButton.setVisible(false);
				}
				break;
			}
		}
		
	}
}
