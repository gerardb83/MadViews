package com.grandcircus.madviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grandcircus.madviews.details.Review;
import com.grandcirucs.madviews.model.Venue;

@Controller
public class MadViewsController {
	
	@Autowired
	private ApiService api;
	private Libber lib = new Libber();
	
	@RequestMapping("/")
	public ModelAndView index() {
		List<String> userNouns = new ArrayList<>(
				Arrays.asList("yin", "president", "pork"));
		Venue venue = new Venue();
		venue.setCity("Chicago");
		venue.setName("pizza");
		venue.setUserNouns(userNouns);
		List<Review> reviews = api.getReviews();
		Reader reader = new Reader("nouns.txt");
		List<String> nouns = reader.readWords();	
		String newReview = lib.makeLib(reviews.get(0).getText(), nouns, userNouns);
		System.out.println(newReview);
		ModelAndView mv = new  ModelAndView("index");
		mv.addObject("venue", venue);
		mv.addObject("oldReview", reviews.get(0).getText());
		mv.addObject("newReview", newReview);
		return mv;
	}

}
