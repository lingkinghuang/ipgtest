package com.ipg.my.exception;

/**
 * Invalid Input Type which might be caused by invalid type (non-numeric)
 * 
 * @author lingking
 *
 */
public class InvalidInputTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1650337161746848339L;
	
	public InvalidInputTypeException(String errorMessage) {
        super(errorMessage);
    }

	public InvalidInputTypeException(String errorMessage, Throwable throwable) {
		super(errorMessage, throwable);
	}
}
