package com.ipg.my.exception;

/**
 * Null or empty input exception 
 * 
 * @author lingking
 *
 */
public class EmptyOrNullInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1650337323423439L;
	
	public EmptyOrNullInputException(String errorMessage) {
        super(errorMessage);
    }

	public EmptyOrNullInputException(String errorMessage, Throwable throwable) {
		super(errorMessage, throwable);
	}
}
