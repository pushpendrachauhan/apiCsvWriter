/**
 * 
 */
package com.pushmybox.models;

/**
 * Model class for city detail
 * 
 * @author pushpendra
 *
 */
public class CityDetail {
	private int _id;
	private String name;
	private String type;
	private double latitude;
	private double longitude;

	/**
	 * @return the id
	 */
	public int get_Id() {
		return _id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this._id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
