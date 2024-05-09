package com.rai.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class })
public class MoviesSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesSpringbootApplication.class, args);
	}

}
