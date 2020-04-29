package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.MovieDAO;
import com.example.demo.entity.Movie;

@SpringBootApplication
public class EurekaMoviesServiceApplication implements CommandLineRunner {

	private MovieDAO movieDao;

	@Autowired
	public EurekaMoviesServiceApplication(MovieDAO movieDao) {
		super();
		this.movieDao = movieDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaMoviesServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		movieDao.save(new Movie("Test1", 8));
		movieDao.save(new Movie("Test2", 4));
		movieDao.save(new Movie("Test3", 6));

	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
