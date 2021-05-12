package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/movie-cruiser")
public class MovieCruiserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserController.class);
	@Autowired
	private MovieService service;
	
	@GetMapping("/admin/listMovies")
	public List<Movie> getMovieListAdmin(){
		LOGGER.info("START");
		LOGGER.info("Fetching movies list by admin");
		LOGGER.info("END");
		return service.getMovieListAdmin();
	}
	
	@PostMapping("/admin/addMovies")
	public void addMoviesAdmin(@RequestBody List<Movie> movies){
		LOGGER.info("START");
		LOGGER.info("Adding movies list by admin");
		service.save(movies);
		LOGGER.info("END");
	}
	
	@PutMapping("/admin/modifyMovie/{id}")
	public void modifyMoviesAdmin(@PathVariable long id ,@RequestBody Movie movies){
		LOGGER.info("START");
		LOGGER.info("Modifying movies list by admin");
		service.modifyMovie(movies);
		LOGGER.info("END");
	}
	
	@GetMapping("/customer/listMovies")
	public List<Movie> getMovieListCustomer(){
		LOGGER.info("START");
		LOGGER.info("Fetching movies list by customer");
		LOGGER.info("END");
		return service.getMovieListCustomer();
	}
	
	@GetMapping("/customer/listMovies/{id}")
	public Movie getMovieById(@PathVariable long id){
		LOGGER.info("START");
		LOGGER.info("Fetching movie by id by customer");
		LOGGER.info("END");
		return service.getMovie(id);
	}
}
