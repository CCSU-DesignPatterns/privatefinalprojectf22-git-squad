package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.GamePanel;
import main.Main;
import main.MainMenuState;

/**
 * UI class used to create the pause menu
 * @author Ryan Sharp
 *
 */
public class PauseUI {
	private GamePanel gp;
	private Font arial40;
	private JPanel pauseMenu;
	private JButton menu;
	private JLabel pause;
	private PauseUIButtonHandler listener;
	
	/**
	 * Create pause menu UI
	 */
	public PauseUI() {
		gp = GamePanel.getInstance();
		arial40 = new Font("Arial", Font.PLAIN, 40);
		listener = new PauseUIButtonHandler();
		
		pauseMenu = new JPanel();
		pauseMenu.setBounds(0,0, gp.SCREEN_WIDTH, gp.SCREEN_HEIGHT);
		pauseMenu.setLayout(new GridBagLayout());
		pauseMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		pauseMenu.setVisible(true);
		pauseMenu.setOpaque(false);
		GridBagConstraints c = new GridBagConstraints();
		
		pause = new JLabel();
		pause.setFont(arial40);
		pause.setText("PAUSED");
		pause.setForeground(Color.white);
		pause.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		pauseMenu.add(pause, c);
		
		menu = new JButton();
		menu.setFont(arial40);
		menu.setText("EXIT TO MENU");
		menu.addActionListener(listener);
		menu.setActionCommand("Menu");
		c.insets = new Insets(gp.TILE_SIZE, 0, 0, 0);
		c.gridy++;
		pauseMenu.add(menu, c);
		
		Main.getPane().add(pauseMenu, Integer.valueOf(1));
	}
	
	/**
	 * Remove this UI from the screen
	 */
	public void remove() {
		Main.getPane().remove(pauseMenu);
	}
	
	private class PauseUIButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Player pressed button: " + e.getActionCommand());
			
			switch(e.getActionCommand()) {
			case("Menu"):
				gp.updateState(new MainMenuState());
				break;
			}
		}
		
	}
	
}
