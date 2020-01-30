package com.ipg.my.util;

import java.text.NumberFormat;

public class MemoryChecker {

	public static void checkMemoryConsumption(int currentLineNo) {
		Runtime runtime = Runtime.getRuntime();
		NumberFormat format = NumberFormat.getInstance();

		StringBuilder sb = new StringBuilder();
		
		long freeMemory = runtime.freeMemory();
		long totalMemory = runtime.totalMemory();

		sb.append("current line: ").append(currentLineNo);
		sb.append(", used memory: ").append(format.format((totalMemory - freeMemory) / (1024 * 1024)));
		
		System.out.println(sb.toString());
	}
}
