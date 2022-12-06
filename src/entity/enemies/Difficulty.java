package entity.enemies;

/**
 * Enumeration for the difficulty of the game
 * @author Ryan Sharo, Ricardo Almeida
 *
 */
public enum Difficulty {
	
	EASY("/difficulties/Easy-Difficulty.txt"),
	MEDIUM("/difficulties/Medium-Difficulty.txt"),
	HARD("/difficulties/Hard-Difficulty.txt");
	
	private String path;
	
	private Difficulty(String path) {
		this.path = path;
	}
	
	/**
	 * Get the file path of the corresponding difficulty file
	 * @return file path in String
	 */
	public String getPath() { return path; }
}
