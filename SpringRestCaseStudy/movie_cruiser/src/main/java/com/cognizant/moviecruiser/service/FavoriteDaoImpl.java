package com.cognizant.moviecruiser.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.exception.FavoriteEmptyException;

@Component
public class FavoriteDaoImpl implements FavoriteDao {
	private static HashMap<String,Favorite> userFavorites;
	@Autowired
	private MovieService service;
	public FavoriteDaoImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<String, Favorite>();
		}
	}

	@Override
	public void addToFavorite(String userName, long movieId) {
		Movie movie = service.getMovie(movieId);
		
		
		if (userFavorites.containsKey(userName)) {
			List<Movie> moviesList = userFavorites.get(userName).getMovieList();
			moviesList.add(movie);
		} else {
			Favorite favorite = new Favorite(new ArrayList<Movie>(), 0.0);
			favorite.getMovieList().add(movie);
			userFavorites.put(userName, favorite);
		}
	}

	@Override
	public List<Movie> getAllFavoriteMovies(String userName) throws FavoriteEmptyException {
		if (userFavorites.containsKey(userName)) {
			List<Movie> moviesList = userFavorites.get(userName).getMovieList();
			if (moviesList.isEmpty()) {
				throw new FavoriteEmptyException();
			} else {
				userFavorites.get(userName).setTotal(moviesList.size());
			}
			return moviesList;
		} else {
			throw new FavoriteEmptyException();
		}
	}

	@Override
	public void removeFromFavorite(String userName, long movieId) {
		List<Movie> movieList = userFavorites.get(userName).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieId) {
				movieList.remove(i);
				break;
			}
		}
	}

}
