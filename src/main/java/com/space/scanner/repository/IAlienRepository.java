package com.space.scanner.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.space.scanner.entity.Alien;

public interface IAlienRepository extends JpaRepository<Alien, Integer>{

	public List<Alien> findByPlanet(String planet);
	public List<Alien> findByPlanetAndRace(String planet, String race);
	
	public Long countByPlanet(String planet);
	public Long countByPlanetAndRace(String planet, String race);
	
	@Query("SELECT a FROM Alien a WHERE a.planet LIKE :planet AND a.id LIKE :id")
	public Alien findByPlanetAndIdQuery(String planet, int id);
	public Optional<Alien> findByPlanetAndId(String planet, int id);
	
	//SELECT c FROM Categoria c WHERE c.nome LIKE :nomeCategoria ORDER BY c.data
}
