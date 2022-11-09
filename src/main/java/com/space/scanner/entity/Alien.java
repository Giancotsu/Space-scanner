package com.space.scanner.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
public class Alien implements Serializable {

	private static final long serialVersionUID = -6602154089823175537L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@NotNull
	@Size(min = 3, message = "Name should have at least 2 characters")
	private String name;
	
	@NotNull
	@Size(max=10, message="Race should have no more than 10 characters")
	private String race;
	
	//@Null(message = "Planet should be empty")
	private String planet;
	
	public Alien() {
		
	}

	@Override
	public String toString() {
		return String.format(
				"Alien[id=%d, name='%s', race='%s', planet='s']",
				id, name, race, planet);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getPlanet() {
		return planet;
	}

	public void setPlanet(String planet) {
		this.planet = planet;
	}
}
