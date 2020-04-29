package com.example.demo.service;




import com.example.demo.entity.Movie;

public interface MovieService {
	
	public Iterable<Movie> getMovies(int id);
	
	public int findUser(int id);

	public Movie  saveOrUpdate(Movie movie);
	
	public void DeleteMovie(int id);
	
}
