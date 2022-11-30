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
			PlacementState currentState = (PlacementState) gp.getState();
			if(currentState.getTower().getCollision() == false) {
				System.out.println("Attempting to place tower...");
				gp.TOWER_MANAGER.add(currentState.getTower());
				gp.updateState(new GameplayState(gp.TILE_MANAGER, gp.TOWER_MANAGER, gp.ENEMY_MANAGER));
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
