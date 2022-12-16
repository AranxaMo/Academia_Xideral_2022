package springboot.crud.service;

import java.util.List;

import springboot.crud.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();
	
	public Movie findById(int theId);
	
	public void save(Movie theMovie);
	
	public void deleteById(int theId);
	
}
