package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.FavoriteDaoImpl;
import com.cognizant.moviecruiser.service.exception.FavoriteEmptyException;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteController.class);
	@Autowired
	private FavoriteDaoImpl dao;
	
	@PostMapping("/add-to-favorite/{userName}/{id}")
	public void addToFavorite(@PathVariable String userName,@PathVariable long id) {
		LOGGER.info("START");
		LOGGER.info("Adding to favorites of "+userName);
		dao.addToFavorite(userName, id);
		LOGGER.info("END");
	}
	
	@DeleteMapping("/remove-from-favorite/{userName}/{id}")
	public void deleteFromFavorite(@PathVariable String userName,@PathVariable long id) {
		LOGGER.info("START");
		LOGGER.info("Removing from favorites of "+userName);
		dao.removeFromFavorite(userName, id);
		LOGGER.info("END");
	}
	
	@GetMapping("/get-favorites/{userName}")
	public List<Movie> getFavoriteMovies(@PathVariable String userName){
		LOGGER.info("START");
		try {
			LOGGER.info("Getting favorites of "+userName);
			LOGGER.info("END");
			return dao.getAllFavoriteMovies(userName);
		} catch (FavoriteEmptyException e) {
			e.printStackTrace();
		}
		LOGGER.info("END");
		return null;
	}
}
