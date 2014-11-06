package com.test.json;
/**
 * @author 		Guruprasad H B <guruhb@gmail.com>
 * @version 	0.1
 * @since		2014-11-06
 *
 */
public class Constants {

	/**
	 * Key for JSON object _id 
	 */
	public static final String JSON_SUGGEST_FIELD_ID = "_id"; //$NON-NLS-1$

	/**
	 * Key for JSON object key 
	 */
	public static final String JSON_SUGGEST_FIELD_KEY = "key";

	/**
	 * Key for JSON object name 
	 */
	public static final String JSON_SUGGEST_FIELD_NAME = "name";

	/**
	 * Key for JSON object fullName 
	 */
	public static final String JSON_SUGGEST_FIELD_FULL_NAME = "fullName";

	/**
	 * Key for JSON object iata_airport_code 
	 */
	public static final String JSON_SUGGEST_FIELD_IATA_AIRPORT_CODE = "iata_airport_code";

	/**
	 * Key for JSON object type 
	 */
	public static final String JSON_SUGGEST_FIELD_TYPE = "type";

	/**
	 * Key for JSON object country 
	 */
	public static final String JSON_SUGGEST_FIELD_COUNTRY = "country";

	/**
	 * Key for JSON object geo_position 
	 */
	public static final String JSON_SUGGEST_FIELD_GEO_POSITION = "geo_position";

	/**
	 * Key for JSON object locationId 
	 */
	public static final String JSON_SUGGEST_FIELD_LOCATION_ID = "locationId";

	/**
	 * Key for JSON object inEurope 
	 */
	public static final String JSON_SUGGEST_FIELD_IN_EUROPE = "inEurope";

	/**
	 * Key for JSON object countryCode 
	 */
	public static final String JSON_SUGGEST_FIELD_COUNTRY_CODE = "countryCode";

	/**
	 * Key for JSON object coreCountry 
	 */
	public static final String JSON_SUGGEST_FIELD_CORE_COUNTRY = "coreCountry";

	/**
	 * Key for JSON object latitude 
	 */
	public static final String JSON_SUGGEST_FIELD_LATITUDE = "latitude";

	/**
	 * Key for JSON object longitude 
	 */
	public static final String JSON_SUGGEST_FIELD_LONGITUDE = "longitude";

	/**
	 * Key for JSON object distance 
	 */
	public static final String JSON_SUGGEST_FIELD_DISTANCE = "distance";

	/**
	 * Key for JSON object string count 
	 */
	public static final int JSON_EMPTY_ARRAY_COUNT = 2;


	/**
	 * JSON Suggest API signature   
	 */
	public static final String JSON_SUGGEST_API_SIGNATURE = "http://api.goeuro.com/api/v2/position/suggest/";

	/**
	 * Default Locale English: en 
	 */
	public static final String JSON_SUGGEST_DEFAULT_LOCALE = "en";
	

	/**
	 * Output file Title / Header  
	 */
	public static final String FILE_HEADING_ID_NAME_TYPE_LATITUDE_LONGITUDE = "Id, Name, Type, Latitude, Longitude \n";

	/**
	 * new line  
	 */
	public static final String NEW_LINE = "\n";

	/**
	 * Back slash for url  
	 */
	public static final String BACK_SLASH = "/";

	/**
	 * HTTP method name GET
	 */
	public static final String HTTP_GET = "GET";

	/**
	 * CSV separator 
	 */
	public static final String CSV_SEPERATOR = ",";

	/**
	 * Minimum argument length
	 */
	public static final int SUGGEST_INPUT_MINIMUN_ARGUMENT_LENGTH = 1;

	/**
	 * Write to file Success
	 */
	public static final int WRITE_TO_FILE_SUCCES = 1;

	/**
	 * Write to file Failure
	 */
	public static final int WRITE_TO_FILE_FAILURE = -1;

}
