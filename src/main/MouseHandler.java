package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * {@summary Handles input detection from the user's mouse.}
 * @author Ryan Sharp
 *
 */
public class MouseHandler implements MouseListener{
	
	GamePanel gp = GamePanel.getInstance();
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(gp.getState().getType().equals(StateType.PLACEMENT)) {
			PlacementState current = (PlacementState) gp.getState();
			if(current.getTower().getCollision() == false) {
				System.out.println("Attempting to place tower...");
				current.getTowerManager().add(current.getTower());
				gp.updateState(new GameplayState(current.getTileManager(), current.getTowerManager(), current.getEnemyManager(), current.getPlayer()));
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
