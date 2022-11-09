package com.space.scanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.space.scanner.bean.Planet;

@RestController
public class PlanetController {
	
	@Autowired
	Planet planet;
	
	@GetMapping(value = "/hello", produces = "application/json")
	public String getPlanet() {
		return planet.getGreetings() + " " + planet.getName();
	}
}
