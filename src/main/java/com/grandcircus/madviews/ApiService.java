package com.grandcircus.madviews;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.grandcircus.madviews.details.DetailResult;
import com.grandcircus.madviews.details.PlaceDetailsResponse;
import com.grandcircus.madviews.details.Review;
import com.grandcircus.madviews.geocoding.GeocodingCoordinatesResponse;
import com.grandcircus.madviews.textsearch.GoogleTextSearchResponse;
import com.grandcircus.madviews.textsearch.Result;
import com.grandcirucs.madviews.model.Venue;

@Component
public class ApiService {

	@Value("${Geocoding.API_KEY}")
	private String geoKey;
	private RestTemplate restTemplate = new RestTemplate();
	private String city;
	private String name;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews(Venue venue) {
		setCity(venue.getCity());
		setName(venue.getName());
		DetailResult result = getPlaceDetails(getDetailsUrl(getPlaceId()));
		List<Review> reviews = result.getReviews();
		return reviews;
	}
	
	public DetailResult getPlaceDetails(String url) {
		PlaceDetailsResponse response = restTemplate.getForObject(url, PlaceDetailsResponse.class);
		DetailResult result = response.getResult();
		return result;
	}

	public GoogleTextSearchResponse getListOfPlacesWithAddressBiased(String url) {
		GoogleTextSearchResponse response = restTemplate.getForObject(url, GoogleTextSearchResponse.class);
		return response;
	}

	public Double getLatitudeCoordinate(String url) {
		GeocodingCoordinatesResponse response = restTemplate.getForObject(url, GeocodingCoordinatesResponse.class);
		return response.getResults()[0].getGeometry().getLocation().getLatitude();
	}

	public Double getLongitudeCoordinate(String url) {
		GeocodingCoordinatesResponse response = restTemplate.getForObject(url, GeocodingCoordinatesResponse.class);
		return response.getResults()[0].getGeometry().getLocation().getLongitude();
	}
	
	private String getPlaceId() {
		GoogleTextSearchResponse response = getListOfPlacesWithAddressBiased(getListOfPlacesUrl(getLatitude(), getLongitude()));
		Result[] results = response.getResults();
		String placeId = results[0].getPlaceId();
		return placeId;
	}
	
	public Double getLatitude() {
		Double latitude = getLatitudeCoordinate(getLatAndLngUrl());
		return latitude;
	}
	
	private Double getLongitude() {
		Double longitude = getLongitudeCoordinate(getLatAndLngUrl());
		return longitude;
	}
	
	private String getDetailsUrl(String placeId) {
		String fields = "name,reviews";
		String url = "https://maps.googleapis.com/maps/api/place/details/json?placeid=" + placeId + "&fields=" + fields
				+ "&key=" + geoKey;
		return url;
	}
	
	private String getListOfPlacesUrl(Double latitude, Double longitude) {
		String url = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=" + name + "&location="
				+ buildLocation(latitude, longitude) + "&radius=" + 5000 + "&key=" + geoKey;
		return url;
	}
	
	private String buildLocation(Double latitude, Double longitude) {
		String location = Double.toString(latitude) + "," + Double.toString(longitude);
		return location;
	}

	
	private String getLatAndLngUrl() {
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + city + "&key=" + geoKey;
		return url;
	}

}
