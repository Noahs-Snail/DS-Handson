package com.cognizant.moviecruiser.service;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.exception.FavoriteEmptyException;

public interface FavoriteDao {
	public void addToFavorite(String userName, long movieId);

	public List<Movie> getAllFavoriteMovies(String userName) throws FavoriteEmptyException;

	public void removeFromFavorite(String userName, long movieId);
}
