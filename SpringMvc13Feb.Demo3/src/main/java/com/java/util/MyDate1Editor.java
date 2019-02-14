package com.java.util;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
//When coming in as date field
public class MyDate1Editor extends PropertyEditorSupport{
	
	//When u display this in a form, it will convert it back from localdate to string
	  @Override
	public String getAsText() {
		LocalDate date=(LocalDate) getValue();
		return date.toString();
	}
	  
	  
	  //when u submit a form, setAsText would be called. So it will parse string to LocalDate
	  @Override
	public void setAsText(String text) throws IllegalArgumentException {
		LocalDate date=LocalDate.parse(text); //yyyy-MM-dd
				setValue(date);
	  }
}
