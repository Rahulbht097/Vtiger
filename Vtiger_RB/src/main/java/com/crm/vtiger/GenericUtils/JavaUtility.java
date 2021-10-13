package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/*
	 * author@RAHUL BHAT
	 */
	/**
	 * METHOD used to generate random number to avoid duplicates
	 * @return
	 */
	public static int getRandomData() {
		Random random = new Random();
		int ran= random.nextInt(1000);
		return ran;
	}
	/**
	 * @RAHUL BHAT
	 * METHOD used to generate currentdate
	 * @return currentdate
	 */
	public static String getCurrentDate() {
		Date date= new Date();
		String currentdate= date.toString();
		return currentdate;
	}
}
