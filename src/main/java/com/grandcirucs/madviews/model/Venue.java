package com.grandcirucs.madviews.model;

import java.util.List;

public class Venue {

	private String name;
	private String city;
	private List<String> userNouns;

	public Venue() {
		super();
	}

	public Venue(String name, String city, List<String> userNouns) {
		super();
		this.name = name;
		this.city = city;
		this.userNouns = userNouns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getUserNouns() {
		return userNouns;
	}

	public void setUserNouns(List<String> userNouns) {
		this.userNouns = userNouns;
	}

	@Override
	public String toString() {
		return "Venue [name=" + name + ", city=" + city + ", userNouns=" + userNouns + "]";
	}

}
