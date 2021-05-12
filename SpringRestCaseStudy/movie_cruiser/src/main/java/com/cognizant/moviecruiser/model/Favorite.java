package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorite {
	private List<Movie> movieList;
	private double total;

	public Favorite(List<Movie> movieList, double total) {
		super();
		this.movieList = movieList;
		this.total = total;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Favorite [movieList=" + movieList + ", total=" + total + "]";
	}
}
