package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileUtility {
//common data like property file json etc.
	/*
	 * author@RAHUL BHAT
	 */
	/**
	 * method to read data from Properties and return the value based on key specified
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertykeyvalue(String key) throws Throwable{
		FileInputStream file = new FileInputStream(IpathConstant.PROPERTY_FILEPATH);
		Properties prop= new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}	
		/**
		 * method to return json value based on json key
		 * @param jsonKey
		 * @return jsonValue
		 * @throws Throwable
		 */
		public String getDataFromJson(String jsonKey) throws Throwable{
		FileReader reader= new FileReader(IpathConstant.JSONFILEPATH);
		JSONParser parser = new JSONParser();
		Object object= parser.parse(reader);
		JSONObject jsonObject= (JSONObject)object;
		String value = jsonObject.get(jsonKey).toString();
		return value;
	}
}

