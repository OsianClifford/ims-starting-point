package com.qa.ims.utils;

import java.util.Scanner;

public class Utils {

	public static final String MYSQL_URL = "localhost:3306";
	public static final Scanner SCANNER = new Scanner(System.in);

	private Utils() {
	}

	public static String getInput() {
		return SCANNER.nextLine();
	}

	public static Double getDoubleInput() {
		return SCANNER.nextDouble();
	}

	public static Long getLongInput() {
		return SCANNER.nextLong();
	}
}
