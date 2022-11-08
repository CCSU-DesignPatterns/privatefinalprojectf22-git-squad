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
	
	@Override
	public String toString() {
		
	}
}
