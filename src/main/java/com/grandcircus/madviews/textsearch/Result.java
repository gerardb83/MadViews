/**
 * Copyright (c) 2019.
 * This program and the accompanying materials are made available
 * under my granted permission provided that this note is kept intact, unmodified and unchanged.
 * @ Author: Baraa Ali -  API and implementation.
 * All rights reserved.
*/

package com.grandcircus.madviews.textsearch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

	private String name;
	@JsonProperty("place_id")
	private String placeId;

	public Result() {
		super();
	}

	public Result(String name, String placeId) {
		super();
		this.name = name;
		this.placeId = placeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	@Override
	public String toString() {
		return "Result [name=" + name + ", placeId=" + placeId + "]";
	}

}