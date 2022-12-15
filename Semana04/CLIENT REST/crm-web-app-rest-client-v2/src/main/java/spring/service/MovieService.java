package spring.service;

import java.util.List;

import spring.model.Movie;

public interface MovieService {

	public List<Movie> getMovies();

	public void saveMovie(Movie theMovie);

	public Movie getMovie(int theId);

	public void deleteMovie(int theId);
	
}
