package org.howard.edu.lsp.assignment5.implementation;

/**
 * Exception class for IntegerSetException which is thrown in by IntegerSet
 * objects
 * 
 * @author tanneruzzell uzzelltanner@gmail.com
 *
 */
public class IntegerSetException extends Exception {
	/**
	 * Constructor for Integer set exception
	 * 
	 * @param message String that user wants to declare the IntegerSetException as
	 */
	public IntegerSetException(String message) {
		super(message);
	}
}
