package com.crm.vtiger.GenericUtils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
/**
 * 
 * @author Rahul
 *
 */
public class DataBaseUtility {
	Connection con = null;
	ResultSet result= null;
	Driver driverref;

	/**
	 * @throws Throwable 
	 */
	public void connectToDb() throws Throwable {
		DriverManager.registerDriver(driverref);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","root");
	}
	
	/**
	 * 
	 * @throws Throwable
	 */
	public void closeDb() throws Throwable {
		con.close();
	}
	
	/**
	 * 
	 * @param query
	 * @param coloumnindex
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromDb(String query, int coloumnindex) throws Throwable {
		String value= null;
		result = con.createStatement().executeQuery(query);
		while (result.next()) {
			value = result.getString(coloumnindex);
		}
		return value;	
	}
	
	/**
	 * 
	 * @param query
	 * @param coloumnName
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromDb(String query, int coloumnName,String expData) throws Throwable {
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while (result.next()) {
			if(result.getString(coloumnName).equalsIgnoreCase(expData)) {
				flag = true;
				break;
			}
			if(flag) {
				System.out.println(expData+""+"data verified");
				return expData;
			}
			else {
				System.out.println(expData+""+"data not verified");
			}
		}
		return expData;
		
	}
	
}
