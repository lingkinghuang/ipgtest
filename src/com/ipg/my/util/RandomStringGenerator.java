package com.ipg.my.util;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;

import com.ipg.my.IpgConstant;


/**
 * Generates a random string 
 * 
 * @author lingking
 *
 */
public class RandomStringGenerator {
	private static SecureRandom secureRandom = null;
	private static RandomStringGenerator instance = null; 

	private RandomStringGenerator() {
	}

	private static RandomStringGenerator getInstance() {
		if (instance == null) {
			instance = new RandomStringGenerator(); 
			secureRandom = new SecureRandom(); 
		}

		return instance; 
	}

	/**
	 * generate a random string, accepts a certain number of length
	 * maximum permissible string length to be generated is 10 while 
	 * minimum length must be bigger than 1 else length will be taken from 
	 * IpgConstant.DEFAULT_GENERATED_LENGTH
	 * 
	 * @param length (character length)
	 * @return random string
	 */
	public static String generateString(int length) {
		if (instance == null) {
			getInstance();
		}
		byte bytes[] = new byte[IpgConstant.DEFAULT_BYTE_SIZE];

		secureRandom.nextBytes(bytes);

		Encoder encoder = Base64.getUrlEncoder().withoutPadding();
		String encodedString = encoder.encodeToString(bytes);

		if (length > 100 || length < 1) {
			length = IpgConstant.DEFAULT_GENERATED_LENGTH;
		}

		return encodedString.substring(0, length);
	}
}
