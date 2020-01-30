package com.ipg.my.util;

import com.ipg.my.IpgConstant;
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
	 * @return {@code true} if input is valid 
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
			int inputInteger = 0; 
			try {
				inputInteger = Integer.parseInt(input);
			} catch (Exception e) {
				throw new InvalidInputTypeException(e.getMessage(), e);
			}
			isStringValid = withinNumericRange(inputInteger);
		}

		return isStringValid; 
	}
	
	/**
	 * checks the value of the user input is within 1 to [Math.pow(2,30) minus 1]
	 * @param x
	 * @return {@code true} if within range
	 */
	private static boolean withinNumericRange(int x) {
		if (x >= IpgConstant.MIN_NUMBER && x <= IpgConstant.MAX_NUMBER) {
			return true;
		}
		
		return false; 
	}
}
