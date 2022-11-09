package com.space.scanner.bean;

public class Mars implements Planet{

	@Override
	public String getGreetings() {
		
		return "Red Planet";
	}

	@Override
	public String getName() {
		
		return "Mars";
	}

}
