package main;

/**
 * Custom exception used when the player tries to spend more money than they have
 * @author Ryan Sharp
 *
 */
public class InsufficientFundsException extends Exception {
	
	/**
	 * Create new exception with the given message
	 * @param message - Text to be written to the console
	 */
	public InsufficientFundsException(String message) {
		super(message);
	}
}
