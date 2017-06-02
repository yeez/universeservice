package com.universeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.universeservice.domain.repository.UniverseEventRepository;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses=UniverseEventRepository.class, entityManagerFactoryRef="entityManagerFactory")
public class UniverseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniverseServiceApplication.class, args);
	}
}
