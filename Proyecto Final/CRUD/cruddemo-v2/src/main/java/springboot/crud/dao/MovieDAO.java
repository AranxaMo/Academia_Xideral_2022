package springboot.crud.dao;

import java.util.List;

import springboot.crud.entity.Movie;

public interface MovieDAO {

	List<Movie> findAll();
	
	Movie findById(int theId);
	
	void save(Movie theMovie);
	
	void deleteById(int theId);
	
}
