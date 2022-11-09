package com.space.scanner.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.space.scanner.entity.Alien;
import com.space.scanner.service.AlienService;

@RestController
@RequestMapping("/aliens")
public class AlienController {
	
	@Autowired
	AlienService alienService;
	
	/* Only for demonstration purposes. 
	 * Not compliant with REST API style. Use POST instead!
	 */
	@GetMapping("/add") 
	public @ResponseBody String addAlien (
			@RequestParam String name,
			@RequestParam String race) {
		
		alienService.addAlien(name, race);
		return "Saved";
	}
	
	@GetMapping("") 
	public @ResponseBody List<Alien> getAliens (
			@RequestParam Optional<String> race) {
		
		if (race.isPresent())
			return alienService.getAliens(race.get());
		else
			return alienService.getAliens();
	}
	
	@GetMapping("/population") 
	public @ResponseBody Long getAliensQuantity (
			@RequestParam Optional<String> race) {
		
		if (race.isPresent())
			return alienService.getPopulation(race.get());
		else
			return alienService.getPopulation();
	}
	
	/* CRUD OPERATIONS */
	
	// CREATE
	@PostMapping("")
	Alien createAlien(@Valid @RequestBody Alien newAlien) {
		return alienService.createAlien(newAlien);
	}
	
	// READ
	@GetMapping("/{id}")
	public @ResponseBody Alien getAlien (
			@PathVariable int id) {
		return alienService.getAlien(id);
	}
	
	// UPDATE
	@PutMapping("/{id}")
	public @ResponseBody Alien updateAlien (
			@PathVariable int id,
			@Valid @RequestBody Alien newAlien) {

		return alienService.updateAlien(id, newAlien);
	}
	
	// DELETE
	@DeleteMapping("/{id}")
	void deleteAlien(@PathVariable int id) {
		alienService.deleteAlien(id);
	}
}
