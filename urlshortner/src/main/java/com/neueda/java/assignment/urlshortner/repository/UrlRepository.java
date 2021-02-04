package com.neueda.java.assignment.urlshortner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.neueda.java.assignment.urlshortner.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long>{
	
	public Url findByShortUrl(String shortUrl);
}
