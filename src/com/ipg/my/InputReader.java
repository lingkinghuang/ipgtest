package com.ipg.my;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ipg.my.exception.EmptyOrNullInputException;
import com.ipg.my.exception.InvalidFileException;
import com.ipg.my.exception.InvalidInputTypeException;
import com.ipg.my.file.FileChecker;
import com.ipg.my.file.IpgFileWriter;
import com.ipg.my.util.InputValidator;

/**
 * Main class responsible to read from user input and to call the function to execute the file write 
 * 
 * @author lingking
 *
 */
public class InputReader {

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

		String input = null;
		boolean isValid = false; 
		try {
			System.out.print("Key in any number: ");
			input = reader.readLine();
			try {
				isValid = InputValidator.isInputValid(input);
			} catch (InvalidInputTypeException | EmptyOrNullInputException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 

		if (isValid) {
			File file = new File(IpgConstant.FILE_PATH); 

			System.out.println("File will be written to: " + file.getAbsolutePath());

			long start = System.currentTimeMillis();

			writeToFile(input, file); 

			long end = System.currentTimeMillis();
			System.out.println("Time Taken: " + (end - start)/1000 + " seconds");

			// Checks on the number of lines in the generated file
			resultCheck(input, file);
		} else {
			System.out.println("Invalid input - no processing will be done");
		}
	}

	/**
	 * write to file 
	 * @param input
	 * @param file
	 */
	private static void writeToFile(String input, File file) {
		try {
			IpgFileWriter.write(file, Integer.parseInt(input));
		} catch (NumberFormatException | InvalidFileException | IOException e ) {
			e.printStackTrace();
		}
	}
	
	/**
	 * result check line numbers in result file against user input
	 * @param input
	 * @param file
	 */
	private static void resultCheck(String input, File file) {
		try {
			System.out.println("User input:" + input + " vs line no found in file: " + 
					FileChecker.getLineNo(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
