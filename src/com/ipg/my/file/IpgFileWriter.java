package com.ipg.my.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.ipg.my.exception.InvalidFileException;
import com.ipg.my.util.MemoryChecker;
import com.ipg.my.util.RandomStringGenerator;

/**
 * The class responsible for file writing
 * 
 * @author lingking
 *
 */
public class IpgFileWriter {

	/**
	 * write to file
	 * 
	 * @param file File
	 * @param lines number of lines
	 * @throws InvalidFileException
	 * @throws IOException 
	 */
	public static void write(File file, int lines) throws InvalidFileException, IOException {
		FileWriter fileWrite = null;
		BufferedWriter bufferedWriter = null; 

		if (file == null) {
			throw new InvalidFileException("File is null");
		}

		try {
			// delete file if it exists in the first place
			if (file.exists()) {
				file.delete();
			}

			fileWrite = new FileWriter(file, true);
			bufferedWriter = new BufferedWriter(fileWrite);

			for (int i=0 ; i<lines; i++) {
				// writes random string to file
				bufferedWriter.write(RandomStringGenerator.generateString(100));
				bufferedWriter.newLine();

				// print out something every now and then... 
				if ((i+1) % 100000 == 0) {
					MemoryChecker.checkMemoryConsumption(i+1);
				}
			}

		} catch (IOException e) {
			throw new IOException(e.getMessage(), e);
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
				if (fileWrite != null) {
					fileWrite.close();
				}
			} catch (IOException e) {
				throw new IOException(e.getMessage(), e);
			}
		}
	}
}
