package com.grandcircus.madviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.grandcirucs.madviews.model.Venue;

public class Libber {

	private Random random = new Random();

	public String makeLib(String review, List<String> nouns, Venue venue) {
		List<String> reviewWords = new ArrayList<>();
		String newReview = review;
		String[] split = review.split(" ");
		for (String e : split) {
			reviewWords.add(e);
		}

		for (String word : reviewWords) {
			for (String noun : nouns) {
				if (word.equalsIgnoreCase(noun)) {
					newReview = newReview.replaceFirst(word, venue.getUserNouns().get(getRandom(venue.getUserNouns())));
				}

			}
		}
		return newReview;
	}

	public String makeTotalMadLib(String review, List<String> nouns, Venue venue) {
		List<String> reviewWords = new ArrayList<>();
		String newReview = review;
		String[] split = review.split(" ");
		for (String e : split) {
			reviewWords.add(e);
		}

		for (String word : reviewWords) {
			for (String noun : nouns) {
				if (word.equalsIgnoreCase(noun)) {
					newReview = newReview.replaceFirst(word, nouns.get(getRandom(venue.getUserNouns())));
				}

			}
		}
		return newReview;
	}

	public Integer getRandom(List<String> userNouns) {
		return random.nextInt(userNouns.size());
	}

	public Venue getVenue(List<String> userNouns) {
		Venue venue = new Venue();
		venue.setCity("Chicago");
		venue.setName("pizza");
		venue.setUserNouns(userNouns);
		return venue;
	}

	public List<String> getNouns() {
		Reader reader = new Reader("nouns.txt");
		return reader.readWords();
	}

	public List<String> splitUserNouns(String content) {
		List<String> userNouns = new ArrayList<>();
		String[] arr = content.split(",");
		for (String each : arr) {
			userNouns.add(each.trim().toLowerCase());
		}
		return userNouns;
	}
}
