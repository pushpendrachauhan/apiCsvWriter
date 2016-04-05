/**
 * 
 */
package com.pushmybox.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.pushmybox.constants.Constants;
import com.pushmybox.models.CityDetail;
import com.pushmybox.services.ApiServices;
import com.pushmybox.services.ApiServicesImpl;
import com.pushmybox.utilities.CsvUtility;

/**
 * Main class
 * 
 * @author pushpendra
 *
 */
public class CsvWriter {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		try {
			ApiServices apiServices;
			String cityName = args[0];
			if (cityName != null && !cityName.trim().isEmpty()) {
				apiServices = new ApiServicesImpl();
				List<CityDetail> cityDetails = apiServices.getCityDetails(cityName, Constants.GO_EURO_URL);
				if (cityDetails != null && cityDetails.size()>0) {
					CsvUtility.writeCsv(cityDetails);
					String userDir = System.getProperty(Constants.USER_DIR);
					System.out.println(Constants.SUCCESS_MESSAGE + userDir + "/" + Constants.CSV_FILE_NAME);
				} else {
					System.out.println(Constants.EMPTY_CITY_MESSAGE);
				}

			} else {
				System.out.println(Constants.CITY_ERROR);
			}

		} catch (Exception e) {
			System.out.println(Constants.UNEXPECTED_ERROR);
			e.printStackTrace();
		}

	}

}
