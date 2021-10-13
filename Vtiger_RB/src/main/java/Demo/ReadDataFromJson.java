package Demo;

import java.io.FileReader;
import java.util.HashMap;

//import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;
public class ReadDataFromJson{
	@Test
//public void getDataFromJson() throws Throwable{
//	FileReader reader = new FileReader("./Data/CommonData.json");
//	JSONParser parser = new JSONParser();
//	Object object= parser.parse(reader);
//	JSONObject jsonobject = (JSONObject)object;
//	String Url = jsonobject.get("url").toString();
//	String Browser = jsonobject.get("browser").toString();
//	String us = jsonobject.get("username").toString();
//	String pwd = jsonobject.get("password").toString();
//	System.out.println(Url);
//	System.out.println(Browser);
//	System.out.println(us);
//	System.out.println(pwd);
//	}
	
	public void readDataFromJson() throws Throwable{
		//read data from json file using file reader
		FileReader file = new FileReader("./Data/CommonData.json");
		//convert the json file into java object 
		JSONParser jsonobj = new JSONParser();
		Object jobj = jsonobj.parse(file);
		
		// explicit type cast java obj to hashmap
		@SuppressWarnings("rawtypes")
		HashMap map = (HashMap)jobj;
		String Url = map.get("url").toString();
		String Browser = map.get("browser").toString();
		String us = map.get("username").toString();
		String pwd = map.get("password").toString();
		System.out.println(Url);
		System.out.println(Browser);
		System.out.println(us);
		System.out.println(pwd);
		
	}
} 