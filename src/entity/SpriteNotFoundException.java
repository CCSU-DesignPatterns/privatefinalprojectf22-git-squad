package entity;

import java.io.IOException;

public class SpriteNotFoundException extends IOException {
	
	public SpriteNotFoundException(String path) {
		super("Sprite could not be found at " + path + ".");
	}
}
