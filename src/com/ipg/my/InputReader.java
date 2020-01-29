package com.ipg.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ipg.my.exception.EmptyOrNullInputException;
import com.ipg.my.exception.InvalidInputTypeException;
import com.ipg.my.util.InputValidator;

public class InputReader {
	
	static float x; 

	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

		String name = null;
		boolean isValid = false; 
		try {
			name = reader.readLine();
			try {
			 isValid = InputValidator.isInputValid(name);
			} catch (InvalidInputTypeException | EmptyOrNullInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 

		System.out.println(name + " -- " + isValid);
	}
}
