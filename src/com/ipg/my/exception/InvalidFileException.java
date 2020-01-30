package com.ipg.my.exception;

/**
 * Invalid file exception which might be caused by unspecified file 
 * 
 * @author lingking
 *
 */
public class InvalidFileException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1231248339L;
	
	public InvalidFileException(String errorMessage) {
        super(errorMessage);
    }

	public InvalidFileException(String errorMessage, Throwable throwable) {
		super(errorMessage, throwable);
	}
}
