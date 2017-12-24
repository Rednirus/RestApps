package com.learn.cxf.in.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelloUniverseServiceImpl implements HelloUniverseService{

	@Override
	public String ping(String input) {
		return "Hello from Universe: "+input;
	}

	@Override
	public String getToday(LocalDate today) {
		return today.format(DateTimeFormatter.ofPattern("dd/mm/yyyy"));
	}

}
