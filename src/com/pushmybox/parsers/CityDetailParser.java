/**
 * 
 */
package com.pushmybox.parsers;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pushmybox.constants.Constants;
import com.pushmybox.models.CityDetail;

/**
 * This class is used for manual parsing of json
 * 
 * @author pushpendra
 *
 */
public class CityDetailParser {

	/**
	 * This function parse json array to list of city details
	 * 
	 * @param cityArr
	 *            json array of city details
	 * @return list of CityDetail
	 */
	public List<CityDetail> parseCityDetailArr(JsonArray cityArr) {
		List<CityDetail> cityDetailList;
		if (cityArr != null) {
			cityDetailList = new ArrayList<CityDetail>();
			for (int i = 0; i < cityArr.size(); i++) {
				CityDetail cityDetail = new CityDetail();
				JsonObject cityObj = cityArr.get(i).getAsJsonObject();
				if (cityObj.has(Constants.ID)) {
					int id = cityObj.get(Constants.ID).getAsInt();
					cityDetail.setId(id);
				}
				if (cityObj.has(Constants.NAME)) {
					String name = cityObj.get(Constants.NAME).getAsString();
					cityDetail.setName(name);
				}
				if (cityObj.has(Constants.TYPE)) {
					String type = cityObj.get(Constants.TYPE).getAsString();
					cityDetail.setType(type);
				}
				if (cityObj.has(Constants.GEO_POSITION)) {
					JsonObject geoJsonObj = cityObj.get(Constants.GEO_POSITION).getAsJsonObject();
					if (geoJsonObj.has(Constants.LATITUDE)) {
						double latitude = geoJsonObj.get(Constants.LATITUDE).getAsDouble();
						cityDetail.setLatitude(latitude);
					}
					if (geoJsonObj.has(Constants.LONGITUDE)) {
						double longitude = geoJsonObj.get(Constants.LONGITUDE).getAsDouble();
						cityDetail.setLongitude(longitude);
					}
				}

				cityDetailList.add(cityDetail);
			}

			return cityDetailList;
		} else {
			return null;
		}

	}
}
