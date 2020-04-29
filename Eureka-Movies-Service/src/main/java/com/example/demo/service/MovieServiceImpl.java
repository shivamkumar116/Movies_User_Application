package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.MovieDAO;
import com.example.demo.entity.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieDAO movieDao;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	public MovieServiceImpl(MovieDAO movieDao) {
		super();
		this.movieDao = movieDao;
	}

	@Override
	public Iterable<Movie> getMovies(int id) {
		int response = restTemplate.getForObject("http://USER-SERVICE//users/{userID}", int.class, id);
		if (response == 1)
			return movieDao.findAll();
		else
			return null;
	}

	@Override
	public int findUser(int id) {

		return restTemplate.getForObject("http://USER-SERVICE//users/{userID}", int.class, id);
	}

	@Override
	public Movie saveOrUpdate(Movie movie) {

		return movieDao.save(movie);
	}

	@Override
	public void DeleteMovie(int id) {
		movieDao.deleteById(id);
	}

}
