package com.grandcircus.madviews;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MadlibGoogleApplication.class)
public class MadviewsApplicationTests {

	@Autowired
	private ApiService api;
	private Libber lib;

	
	
	@Before
	public void setup() {
	lib = new Libber();
	}
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void whenGetReviewsIsPassedItReturnsAListOfReviews() {
		String actual = api.getReviews().get(0).getText();
		String expected = "It's a lot better than it ever was before, had not been here in maybe 10 years. Food is good quality now, I love the fries and pancake hush puppies, the  prices are more in line with what you are getting now, it doesn't feel so overpriced. "
				+ "Service is generally pretty good, everybody has bad days. Only complaint is they need more people on staff on busy days. Give them a shot, reasonably priced dining places are disappearing fast from this area. Support your favorites.";
		assertEquals(expected, actual);
	}

	@Test
	public void whenGetLatitudeIsIsPassedItReturnsALatitude() {
		Double actual = api.getLatitude();
		Double expected = 42.331427;
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenGetLatIsIsPassedItReturnsALatitude() {
		Double actual = api.getLat();
		Double expected = 42.331427;
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenRandomNumberIsPassedAThreeWordListItReturnsANumberFrom0To2() {
		String[] userNouns = {"butt", "president", "pork"};
		List<Integer> randoms = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			int randomInteger = lib.getRandom(userNouns);
			randoms.add(randomInteger);
		}
		Collections.sort(randoms);
		int actual = randoms.get(0);
		int actual2 = randoms.get(99);
		int expected = 0;
		int expected2 = 2;
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}

}
