package com.softplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
		"com.softplan.model"
})
@EnableJpaRepositories(basePackages = {
		"com.softplan.repository.impl"
})
public class SoftplanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftplanApplication.class, args);
	}

}
