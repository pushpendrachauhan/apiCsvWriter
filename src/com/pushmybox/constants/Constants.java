package com.pushmybox.constants;

/**
 * Contains all the constants
 * 
 * @author pushpendra
 *
 */
public class Constants {
	
	// go euro url
	public static final String GO_EURO_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";
	
	// api constants
	public static final String ID = "_id";
	public static final String NAME = "name";
	public static final String TYPE = "type";
	public static final String GEO_POSITION = "geo_position";
	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";

	// system constants
	public static final String USER_DIR = "user.dir";
	
	// config file constant
	public static final String CONFIG_FILE_NAME = "conf/config.properties";

	// csv file name
	public static final String CSV_FILE_NAME = "cityDetails.csv";

	// error messages
	public static final String EMPTY_CITY_MESSAGE = "no city found, empty array received!!";
	public static final String CITY_ERROR = "city name is empty !!";
	public static final String UNEXPECTED_ERROR = "some error occured !!";

	// success message
	public static final String SUCCESS_MESSAGE = "successfully wrote to csv, please check at ";

}
