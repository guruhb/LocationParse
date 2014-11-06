package com.test.json.suggest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.test.json.Constants;
/**
 * @author 		Guruprasad H B <guruhb@gmail.com>
 * @version 	0.1
 * @since		2014-11-06
 *
 */
public class JSONParse {
	
	public List<Location> parseSuggestJSONData(String aData) {
		 try {
	           JSONArray respArray = new JSONArray(aData);
	           if(respArray.length() > 0) {
	               List<Location> slist = new ArrayList<>();

	               for (int i = 0; i < respArray.length(); i++) {
	            	   long id = ((JSONObject) respArray.get(i)).getLong(Constants.JSON_SUGGEST_FIELD_ID);
	                   String name = ((JSONObject) respArray.get(i)).getString(Constants.JSON_SUGGEST_FIELD_NAME);
	                   String fullName = ((JSONObject) respArray.get(i)).getString(Constants.JSON_SUGGEST_FIELD_FULL_NAME);
	                   String type = ((JSONObject) respArray.get(i)).getString(Constants.JSON_SUGGEST_FIELD_TYPE);
	                   String countryCode = ((JSONObject) respArray.get(i)).getString(Constants.JSON_SUGGEST_FIELD_COUNTRY_CODE);
	                   long distance = 0;
	                   try {
	                       distance = ((JSONObject) respArray.get(i)).getLong(Constants.JSON_SUGGEST_FIELD_DISTANCE);
	                   }catch (JSONException e) {
	                       //e.printStackTrace(); //FIXME : distance allways null check this out !!
	                       //System.out.println("Get Distance failed" + name);
	                   }
	                   JSONObject geoObj = ((JSONObject) respArray.get(i)).getJSONObject(Constants.JSON_SUGGEST_FIELD_GEO_POSITION);
	                   double lat = 0.0;//FIXME : define default value
	                   double lng = 0.0;//FIXME : define default value
	                   if(geoObj != null) {
	                       lat = geoObj.getDouble(Constants.JSON_SUGGEST_FIELD_LATITUDE);
	                       lng = geoObj.getDouble(Constants.JSON_SUGGEST_FIELD_LONGITUDE);
	                   }
	                   
	                   Location sl = new Location(id, name, fullName, type, lat, lng, countryCode, distance);
	                   if(!slist.add(sl)) {
	                       System.out.println("list append failed" + name);
	                   }
	               }
	               return slist;
	           }else {
	               System.out.println("JSONArray failed : " + respArray.toString());
	           }
	       }catch(JSONException e) {
	           e.printStackTrace();
	       }
		return null;
	}
}
