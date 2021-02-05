package com.neueda.java.assignment.urlshortner.helper;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;

public class Helper {
	
	public static LocalDateTime getExpirationDate(String expiryDate, LocalDateTime creationDate) {
		if(StringUtils.isBlank(expiryDate))
        {
            return creationDate.plusSeconds(240);
        }
        LocalDateTime expirationDate = LocalDateTime.parse(expiryDate);
        return expirationDate;
	}

}
