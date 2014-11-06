package com.test.json.suggest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.test.json.Constants;

/**
 * @author 		Guruprasad H B <guruhb@gmail.com>
 * @version 	0.1
 * @since		2014-11-06
 *
 */
public class DataToFile {
		
	private FileWriter fileWriter;

	public int storeDataToFile(List<Location> aLocation, String aFileName) {
		fileWriter = null;
		try {
			fileWriter = new FileWriter(aFileName);
			if(aLocation.size() > 0) {
				fileWriter.append(Constants.FILE_HEADING_ID_NAME_TYPE_LATITUDE_LONGITUDE);
			}
			//write _id, name, type, latitude, longitude
			for(Location l: aLocation) {
				fileWriter.append(Long.toString(l.getId()));
				fileWriter.append(Constants.CSV_SEPERATOR);
				
				fileWriter.append(l.getName());
				fileWriter.append(Constants.CSV_SEPERATOR);

				fileWriter.append(l.getType());
				fileWriter.append(Constants.CSV_SEPERATOR);
				
				fileWriter.append(Double.toString(l.getGeoPosition().getLatitude()));
				fileWriter.append(Constants.CSV_SEPERATOR);
				
				fileWriter.append(Double.toString(l.getGeoPosition().getLongitude()));
				fileWriter.append(Constants.NEW_LINE);
			}
			fileWriter.flush();
			fileWriter.close();
			return Constants.WRITE_TO_FILE_SUCCES;
		}catch(IOException e) {
			e.printStackTrace();
			return Constants.WRITE_TO_FILE_FAILURE;
		} finally {
			if(fileWriter != null)
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
	}

}
