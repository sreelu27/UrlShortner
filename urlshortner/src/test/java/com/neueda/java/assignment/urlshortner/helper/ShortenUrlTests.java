package com.neueda.java.assignment.urlshortner.helper;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class ShortenUrlTests {
	
	@Test
	public void sameUrlShouldGiveUniqueShortner() {
		String orgUrl = "https://www.google.com/search?q=how+do+i+iron+a+shirt&oq=&aqs=chrome.1.69i59i450l8.1961669j0j1&sourceid=chrome&ie=UTF-8";
		
		String shortUrl1 = ShortenUrl.shortenUrl(orgUrl);
		String shortUrl2 = ShortenUrl.shortenUrl(orgUrl);
		Assert.assertNotEquals(shortUrl1,shortUrl2);
	}
	
	@Test
	public void diffUrlShouldGiveUniqueShortner() {
		String orgUrl1 = "https://www.google.com/search?q=how+do+i+iron+a+shirt&oq=&aqs=chrome.1.69i59i450l8.1961669j0j1&sourceid=chrome&ie=UTF-8";
		String orgUrl2 = "https://www.google.com/search?q=wash+a+cat&oq=wash+a+&aqs=chrome.2.69i57j0l8.5498j0j1&sourceid=chrome&ie=UTF-8";
		
		String shortUrl1 = ShortenUrl.shortenUrl(orgUrl1);
		String shortUrl2 = ShortenUrl.shortenUrl(orgUrl2);
		Assert.assertNotEquals(shortUrl1,shortUrl2);
	}
	
	

}
