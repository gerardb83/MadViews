package com.grandcircus.madviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Libber {
	
	private Random random = new Random();

	public String makeLib(String review, List<String> nouns, List<String> userNouns) {
		List<String> reviewWords = new ArrayList<>();
		String newReview = review;
		String[] split = review.split(" ");
		for (String e : split) {
			reviewWords.add(e);
		}
		
		for (String word : reviewWords) {
			for (String noun : nouns ) {
				if(word.equalsIgnoreCase(noun)) {
					int randomNum = ThreadLocalRandom.current().nextInt(0, userNouns.size());
					newReview = newReview.replaceFirst(word, userNouns.get(randomNum));
				}
				
			}
		}
		return newReview;
	}
	
	public String makeTotalMadLib(String review, List<String> nouns, List<String> userNouns) {
		List<String> reviewWords = new ArrayList<>();
		String newReview = review;
		String[] split = review.split(" ");
		for (String e : split) {
			reviewWords.add(e);
		}
		
		for (String word : reviewWords) {
			for (String noun : nouns ) {
				if(word.equalsIgnoreCase(noun)) {
					newReview = newReview.replaceFirst(word, nouns.get(getRandom(userNouns)));
				}
				
			}
		}
		return newReview;
	}
	
	public Integer getRandom(List<String> userNouns) {
		return random.nextInt(userNouns.size());
	}
}
