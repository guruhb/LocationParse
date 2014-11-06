package com.test.json.suggest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.test.json.Constants;

/**
 * @author 		Guruprasad H B <guruhb@gmail.com>
 * @version 	0.1
 * @since		2014-11-06
 *
 */
public class GetJson {

	public String getJsonData(String aUrl) {
		
		try {
			URL url = new URL(aUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			
			httpURLConnection.setRequestMethod(Constants.HTTP_GET);
			int responseCode = httpURLConnection.getResponseCode();
			
			if(responseCode != HttpURLConnection.HTTP_OK) {
				System.out.println("Failed to get data for " + aUrl + "\nHttp status : " + responseCode); 
				return "";
			}
			
			BufferedReader httpOutBuffer = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			String readLine; 
			StringBuffer responseBuffer = new StringBuffer();
			
			//read all the line from the http response data
			while ( (readLine = httpOutBuffer.readLine()) != null ) {
				responseBuffer.append(readLine);
			}
			httpOutBuffer.close();
			
			if(responseBuffer.length() == Constants.JSON_EMPTY_ARRAY_COUNT)
				return "";
			
			return responseBuffer.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
