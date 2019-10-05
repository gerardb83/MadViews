package com.grandcircus.madviews.details;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Review implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("author_name")
	private String authorName;
	private Integer rating;
	private String text;

	public Review() {
		super();
	}

	public Review(String authorName, Integer rating, String text) {
		super();
		this.authorName = authorName;
		this.rating = rating;
		this.text = text;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Review [authorName=" + authorName + ", rating=" + rating + ", text=" + text + "]";
	}

}
