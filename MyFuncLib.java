/*This is the Functional Library Class*/
package com.mypackage.MyLib;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MyFuncLib {

	/*This Method reads the API URL where the request method parameter is 'GET' and prints the acceptance criteria*/
	public void readJson(String filename, String apiMethod) throws Exception{

		Scanner scanObj = null;
		String strObj = null;
		URL url = null;
		HttpURLConnection conn = null;
		JSONObject jsonObject = null;
		try{
			url = new URL(filename);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(apiMethod);
			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException("Failed : HTTP error code obtained is : " + conn.getResponseCode());
			}
			scanObj = new Scanner(url.openStream());
			strObj = new String();
			while (scanObj.hasNext())
				strObj = strObj + scanObj.nextLine();
			jsonObject = (JSONObject)new JSONParser().parse(strObj);
			System.out.println("Acceptance Criteria:" + "\n");
			String name = (String)jsonObject.get("Name");
			System.out.println("\t" + "a) " +"Name = " +"\""+name+"\"");
			Boolean canReList = (Boolean)jsonObject.get("CanRelist");
			System.out.println("\t" + "b) " +"CanRelist = " +canReList);
			JSONArray my_array = (JSONArray) jsonObject.get("Promotions");
			for (int i = 0; i<my_array.size()-1; i++){
				String mystr = my_array.get(i).toString();
				if (mystr.contains(MyConstants.seachedText))
				{
					jsonObject = (JSONObject)new JSONParser().parse(mystr);
					String description = (String) jsonObject.get("Description");
					System.out.println("\t" + "c) " + "The Promotions element with Name = " + "\"Gallery\" "+ "has a Description that contains the text " +"\"" + description + "\"");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			scanObj.close();
		}
	}
}
