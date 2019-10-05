package com.grandcircus.madviews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grandcircus.madviews.details.Review;

@Controller
public class madlibgoogleController {
	
	@Autowired
	private ApiService api;
	private Libber lib = new Libber();
	
	@RequestMapping("/")
	public ModelAndView index() {
		List<Review> reviews = api.getReviews();
		Reader reader = new Reader("nouns.txt");
		List<String> nouns = reader.readWords();
		String[] userNouns = {"yin", "president", "pork"};
		String newReview = lib.makeLib(reviews.get(0).getText(), nouns, userNouns);
		System.out.println(newReview);
		ModelAndView mv = new  ModelAndView("index");
		mv.addObject("oldReview", reviews.get(0).getText());
		mv.addObject("newReview", newReview);
		return mv;
	}

}
