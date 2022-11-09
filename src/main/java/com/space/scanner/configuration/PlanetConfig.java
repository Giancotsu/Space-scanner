package com.space.scanner.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.space.scanner.bean.Mars;
import com.space.scanner.bean.Planet;
import com.space.scanner.bean.Venus;

@Configuration
public class PlanetConfig {

	@Value("${app.planet}")
	private String planet;

    @Bean
    Planet planet() {
        System.out.println("Landing planet: " + planet);

        switch (planet) {
            case "mars": return new Mars();
            case "venus": return new Venus();
            default: return new Mars();
        }
    }
}
