package com.grandcircus.madviews;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Libber {

	public String makeLib(String review, List<String> nouns, String[] userNouns) {
		List<String> reviewWords = new ArrayList<>();
		String newReview = review;
		String[] split = review.split(" ");
		for (String e : split) {
			reviewWords.add(e);
		}
		
		for (String word : reviewWords) {
			for (String noun : nouns ) {
				if(word.equalsIgnoreCase(noun)) {
					int randomNum = ThreadLocalRandom.current().nextInt(0, userNouns.length);
					newReview = newReview.replaceFirst(word, userNouns[randomNum]);
				}
				
			}
		}
		return newReview;
	}
	
	public String makeTotalMadLib(String review, List<String> nouns, String[] userNouns) {
		List<String> reviewWords = new ArrayList<>();
		String newReview = review;
		String[] split = review.split(" ");
		for (String e : split) {
			reviewWords.add(e);
		}
		
		for (String word : reviewWords) {
			for (String noun : nouns ) {
				if(word.equalsIgnoreCase(noun)) {
					int randomNum = ThreadLocalRandom.current().nextInt(0, nouns.size());
					newReview = newReview.replaceFirst(word, nouns.get(randomNum));
				}
				
			}
		}
		return newReview;
		
	}
}
