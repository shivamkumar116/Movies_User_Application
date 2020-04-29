package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Movie;

public interface MovieDAO extends CrudRepository<Movie, Integer> {

}
