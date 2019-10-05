/**
 * Copyright (c) 2019.
 * This program and the accompanying materials are made available
 * under my granted permission provided that this note is kept intact, unmodified and unchanged.
 * @ Author: Baraa Ali -  API and implementation.
 * All rights reserved.
*/

package com.grandcircus.madviews.details;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetailResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private List<Review> reviews;

	public DetailResult() {
		super();
	}

	public DetailResult(String name, List<Review> reviews) {
		super();
		this.name = name;
		this.reviews = reviews;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "DetailResult [name=" + name + ", reviews=" + reviews + "]";
	}

}