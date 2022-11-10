package common;

public class Rectangle {
	private int length = 1;
	private int width = 1;
	
	/**
	 * Default constructor. Creates a 1x1 square
	 */
	public Rectangle() { }
	
	/**
	 * Constructor that takes integer values for length and width
	 * @param l The length of the rectangle
	 * @param w The width of the rectangle
	 */
	public Rectangle(int l, int w) {
		setLength(l);
		setWidth(w);
	}
	
	/**
	 * Sets the length of the rectangle instance
	 * @param l Length of the rectangle
	 */
	public void setLength(int l) {
		if(l > 0)
			this.length = l;
	}
	
	/**
	 * Sets the width of the rectangle instance
	 * @param w Width of the rectangle
	 */
	public void setWidth(int w) {
		if(w > 0)
			this.width = w;
	}
	
	/**
	 * Returns the length of the rectangle instance
	 * @return Length of the rectangle
	 */
	public int getLength() { return length; }
	
	/**
	 * Returns the width of the rectangle instance
	 * @return Width of the rectangle
	 */
	public int getWidth() { return width; }
	
	/**
	 * Equals override
	 * @return boolean True or False
	 */
	@Override
	public boolean equals(Object obj) {
		// Not yet implemented
		return false;
	}
	
	/**
	 * toString override
	 * @return String representation of the current instance
	 */
	@Override
	public String toString() {
    // Not yet implemented
		return null;
	}
	
	/**
	 * hashCode override
	 * @return integer representing the hashcode for the current instance
	 */
	@Override
	public int hashCode() {
		// Not yet implemented
		return 0;
	}
}
