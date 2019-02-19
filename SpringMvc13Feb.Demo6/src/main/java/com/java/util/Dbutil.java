package com.java.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Dbutil {
	@Value("${isValid}")
	boolean isValid;
	
	public String getVal() {
		return isValid+"";
	}
}
