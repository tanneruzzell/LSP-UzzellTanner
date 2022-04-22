package org.howard.edu.lsp.finalExam;

/**
 * Exception class for NullMapException which is thrown in by MapUtilities
 * methods
 * 
 * 
 * @author tanneruzzell uzzelltanner@gmail.com
 *
 */

public class NullMapException extends Exception {
	/**
	 * Constructor for NullMapException
	 * 
	 * @param message String that user wants to declare the IntegerSetException as
	 */
	public NullMapException(String message) {
		super(message);
	}
}
