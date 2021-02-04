package com.neueda.java.assignment.urlshortner.helper;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;

@Component
public class ShortenUrl {
	
	public String shortenUrl(String url) {
		String encodedUrl = "";
		LocalDateTime time = LocalDateTime.now();
		encodedUrl = Hashing.murmur3_32()
				.hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
				.toString();
		return encodedUrl;
	}

}
