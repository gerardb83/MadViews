package com.grandcircus.madviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		return new ModelAndView("index");
	}
	
	@RequestMapping("/newReview")
	public ModelAndView newReview(
			@RequestParam("city") String city, 
			@RequestParam("name") String name,
			@RequestParam("content") String content) {
		List<String> userNouns = lib.splitUserNouns(content);
		Venue venue = new Venue(name, city, userNouns); 
//				lib.getVenue(userNouns);
		List<Review> reviews = api.getReviews(venue);
		System.out.println(reviews);
		List<String> nouns = lib.getNouns();
		String newReview = lib.makeLib(reviews.get(0).getText(), nouns, venue);
		System.out.println(newReview);
		ModelAndView mv = new  ModelAndView("newReview");
		mv.addObject("oldReview", reviews.get(0).getText());
		mv.addObject("newReview", newReview);
		return mv;
	}

}
