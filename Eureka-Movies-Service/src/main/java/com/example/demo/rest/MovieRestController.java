package com.example.demo.rest;

import java.lang.module.FindException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Movie;
import com.example.demo.exception.MovieResponseEntity;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.MovieService;

@RestController
public class MovieRestController {

	private MovieService movieService;
	int response;

	@Autowired
	public MovieRestController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}

	@GetMapping("/movies/{userID}")
	public Iterable<Movie> getMovies(@PathVariable int userID) {
		Iterable<Movie> movies = movieService.getMovies(userID);
		if (movies == null)
			throw new UserNotFoundException("**NOT AUTHORIZED**");
		else
			return movies;
	}

	@PostMapping("/movies/{userID}")
	public Movie createMovie(@PathVariable int userID, @RequestBody Movie movie) {
		response = movieService.findUser(userID);
		if (response == 1) {
			return movieService.saveOrUpdate(movie);
		} else
			throw new UserNotFoundException("**NOT AUTHORIZED**");
	}

	@DeleteMapping("/movies/{movieID}/{userID}")
	public ResponseEntity<MovieResponseEntity> deleteMovie(@PathVariable int movieID, @PathVariable int userID) {
		response = movieService.findUser(userID);
		if (response == 1) {
			movieService.DeleteMovie(movieID);
			return new ResponseEntity<MovieResponseEntity>(new MovieResponseEntity(HttpStatus.OK.value(),
					"Deleted" ,System.currentTimeMillis()), HttpStatus.OK);
		} else
			throw new UserNotFoundException("**NOT AUTHORIZED**");
	}

	@PutMapping("/movies/{userID}")
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable int userID) {
		response = movieService.findUser(userID);
		if (response == 1)
			return movieService.saveOrUpdate(movie);
		else
			throw new UserNotFoundException("**NOT AUTHORIZED**");

	}

}
