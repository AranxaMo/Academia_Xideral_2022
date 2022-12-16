package springboot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.crud.dao.MovieDAO;
import springboot.crud.entity.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	
	private MovieDAO movieDAO;
	
	@Autowired
	public MovieServiceImpl(@Qualifier("movieDAOHibernateImpl") MovieDAO theMovieDAO) {
		movieDAO = theMovieDAO;
	}
	
	@Override
	@Transactional
	public List<Movie> findAll() {
		return movieDAO.findAll();
	}

	@Override
	@Transactional
	public Movie findById(int theId) {
		return movieDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Movie theMovie) {
		movieDAO.save(theMovie);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		movieDAO.deleteById(theId);
	}

}






