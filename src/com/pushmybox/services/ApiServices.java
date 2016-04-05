/**
 * 
 */
package com.pushmybox.services;

import java.util.List;

import com.pushmybox.models.CityDetail;

/**
 * @author pushpendra
 *
 */
public interface ApiServices {
	/**
	 * This function retrieves the details of city from api's
	 * 
	 * @param cityName
	 *            - name of the city
	 * @param url
	 *            - url of api
	 * @return - list of CityDetail
	 */
	List<CityDetail> getCityDetails(String cityName, String url);
}
