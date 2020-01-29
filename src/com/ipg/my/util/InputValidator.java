package com.ipg.my.util;

import com.ipg.my.exception.EmptyOrNullInputException;
import com.ipg.my.exception.InvalidInputTypeException;

/**
 * Validates the input string to the format needed 
 * 
 * @author lingking
 *
 */
public class InputValidator {

	/**
	 * Checks the input string is valid 
	 * 
	 * @param input
	 * @return
	 * @throws InvalidInputTypeException 
	 * @throws EmptyOrNullInputException 
	 */
	public static boolean isInputValid(String input) throws InvalidInputTypeException, 
			EmptyOrNullInputException {
		
		boolean isStringValid = true; 

		if (input == null || input.equals("")) {
			isStringValid = false; 
			throw new EmptyOrNullInputException("Empty or null input detected");
		} else {
			try {
				Float.valueOf(input);
			} catch (Exception e) {
				throw new InvalidInputTypeException(e.getMessage(), e);
			}
		}

		return isStringValid; 
	}
}
