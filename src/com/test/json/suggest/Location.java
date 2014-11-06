package com.test.json.suggest;

/**
 * @author 		Guruprasad H B <guruhb@gmail.com>
 * @version 	0.1
 * @since		2014-11-06
 *
 */
public class Location {
		private long id;
	    private String name;
	    private String fullName;
	    private String type;
	    private GeoPosition geoPosition;
	    private String countryCode;
	    private long distance;

	    public Location() {
	        name = "";
	        fullName = "";
	        type = "";
	        geoPosition = new GeoPosition(0.0, 0.0); //FIXME : set default location
	        countryCode = "";
	        distance = 0;
	    }
	    public Location(long id, String name, String fullName, String type, double lat, double lng, String countryCode, long distance) {
	    	this.id = id;
	        this.name = name;
	        this.fullName = fullName;
	        this.type = type;
	        this.geoPosition = new GeoPosition(lat, lng); //FIXME : set default location
	        this.countryCode = countryCode;
	        this.distance = distance;
	    }

	    public class GeoPosition {
	        private double lat;
	        private double lng;
	        public GeoPosition(double latitude, double longitude) {
	            this.lat = latitude;
	            this.lng = longitude;
	        }
	        public double getLatitude() { return lat; }
	        public double getLongitude() { return lng; }
	    }

	    public String getName() { return name; }
	    public String getFullName() { return fullName; }
	    public long getId() { return id; }
	    public String getType() { return type; }
	    public GeoPosition getGeoPosition() { return geoPosition; }
	    public String getCountryCode() { return countryCode; }
	    public long getDistance() { return distance; }
	    
	    
}
