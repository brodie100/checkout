package com.assignments.checkout.exceptions;

/**
 * @author BMC
 *
 */
public class InvalidFunctionException extends Exception {
	
	private static final long serialVersionUID = -5993733284799913874L;
	
	// Should be externalised
	private static final String MSG = "Invalid number of functions defined.  Please ensure to only specify one";  
	
	/**
	 * Create Invalid Function Exception with default message.
	 */
	public InvalidFunctionException(){
		super(MSG);
	}
	
}
