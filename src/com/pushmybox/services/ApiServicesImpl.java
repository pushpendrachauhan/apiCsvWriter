/**
 * 
 */
package com.pushmybox.services;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.pushmybox.models.CityDetail;
import com.pushmybox.parsers.CityDetailParser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * This class implements ApiServices interface Okhttp is used for the http req
 * http://square.github.io/okhttp/
 * 
 * @author pushpendra
 * 
 */
public class ApiServicesImpl implements ApiServices {
	OkHttpClient client = new OkHttpClient();

	@Override
	public List<CityDetail> getCityDetails(String cityName, String url) {
		JsonArray cityArr = getJson(cityName, url);
		if (cityArr != null) {
			CityDetailParser cityDetailParser = new CityDetailParser();
			List<CityDetail> cityDetailList = cityDetailParser.parseCityDetailArr(cityArr);
			return cityDetailList;
		} else {
			return null;
		}

	}

	/**
	 * This function make req to api's by using okHttp lib
	 * 
	 * @param cityName
	 * @param url
	 * @return Json array cityArr
	 */
	private JsonArray getJson(String cityName, String url) {
		try {
			Request request = new Request.Builder().url(url + cityName).build();

			Response response = client.newCall(request).execute();
			String responseString = response.body().string();
			if (responseString != null && !responseString.isEmpty()) {
				JsonParser parser = new JsonParser();
				JsonElement elem = parser.parse(responseString);
				JsonArray cityArr = elem.getAsJsonArray();
				return cityArr;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
