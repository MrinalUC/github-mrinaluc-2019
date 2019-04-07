/*This program fetches the JSON Object from the API based on the key provided
 * 
 * Authored : Mrinal Jyoti Kumar
 * Place: ChristChurch, NZ
 * Date: 06/04/2019
 * */
package com.mypackage.main;
import com.mypackage.MyLib.MyConstants;
import com.mypackage.MyLib.MyFuncLib;

public class RunMain {

	/*This is the Main Method, where the program starts*/
	
	public static void main(String[] args) throws Exception {
		/*Created Object of the class MyFuncLib to access the readJson method */
		MyFuncLib myFunc = new MyFuncLib();
		myFunc.readJson(MyConstants.URL, MyConstants.getMethod);
	}
}