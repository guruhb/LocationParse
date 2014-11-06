package com.test.json.suggest;

import java.io.File;
import java.util.EmptyStackException;
import java.util.List;

import com.test.json.Constants;

/**
 * @author 		Guruprasad H B <guruhb@gmail.com>
 * @version 	0.1
 * @since		2014-11-06
 *
 */
public class ParseJsonToCsv {

	
	/**
	 * Given a "input string", queries the Location JSON API and results are stored in "input string.csv" 
	 * @param Location name which needs to be searched from the server
	 */
	public static void main(String[] args) {
		
		if(args.length < Constants.SUGGEST_INPUT_MINIMUN_ARGUMENT_LENGTH) {
			System.out.println("Incorrect usage ! \n Interested location you want to search for");
			return;
		}
		
		String suggestInput = "";
		for (String s: args) {
			System.out.println(s);
			suggestInput += s + " "; //FIXME : look for optimized way to copy arguments
		}
		suggestInput = suggestInput.trim();
		
		String userLanguage = null; 
		try {
			userLanguage = System.getProperty("user.language");
		}catch (Exception e) {
			System.out.println("System.getProperty(\"user.language\")  failed , searching language as " + Constants.JSON_SUGGEST_DEFAULT_LOCALE );
			e.printStackTrace();
		}
		if(userLanguage == null) {
			userLanguage = Constants.JSON_SUGGEST_DEFAULT_LOCALE;
		}
		
		GetJson getJson = new GetJson();
		String jsonData = getJson.getJsonData(Constants.JSON_SUGGEST_API_SIGNATURE + userLanguage + Constants.BACK_SLASH + suggestInput);
		
		if(jsonData.length() > 0) {
			JSONParse jsonParse = new JSONParse();
			List<Location> locations = jsonParse.parseSuggestJSONData(jsonData);
			if(locations != null) {
				System.out.println("Number of locations returned : " + locations.size());
				//String fileName = "suggestresult.csv";
				String fileName = suggestInput + ".csv";
				
				try {
					File file = new File(fileName);
					if(file.exists()) {
						if(!file.delete()) {
							System.out.println(fileName + " Exists and in Use not able to create a new one");
							throw new EmptyStackException(); 
						}
					} 
				}catch (Exception e) {
					e.printStackTrace();
				}

				DataToFile dataToFile = new DataToFile();
				if(dataToFile.storeDataToFile(locations, fileName) == Constants.WRITE_TO_FILE_SUCCES) {
					System.out.println("Suggested results are stored in : " + fileName);
					return;
				}
				
			}
		} 
		System.out.println("No location data for the given input : " + suggestInput );
	}
}
