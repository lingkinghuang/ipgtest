package com.ipg.my.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Final Check on created file using the getLineNo function
 * 
 * @author lingking
 *
 */
public class FileChecker {

	public static int getLineNo(File file) throws IOException {
		int count = 0; 

		// returns lineNo = 0 if file doesn't exist
		if (file == null || !file.exists()) {
			return count;
		}

		try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
			byte[] c = new byte[1024];
			int readChars = 0;
			while ((readChars = inputStream.read(c)) != -1) {
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
			}
		} catch (IOException e) {
			throw new IOException(e.getMessage(), e);
		}
		return count;
	}
}
