package springboot.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.crud.entity.Movie;
import springboot.crud.service.MovieService;

@RestController
@RequestMapping("/rest")
public class MovieRestController {

	private MovieService movieService;
	
	@Autowired
	public MovieRestController(MovieService theMovieService) {
		movieService = theMovieService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/movies")
	public List<Movie> findAll() {
		return movieService.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/movies/{movieId}")
	public Movie getMovie(@PathVariable int movieId) throws Exception {
		
		Movie theMovie = movieService.findById(movieId);
		
		if (theMovie == null) {
			throw new Exception("Movie id not found - " + movieId);
		}
		
		return theMovie;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/movies")
	public Movie addMovie(@RequestBody Movie theMovie) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theMovie.setId(0);
		
		movieService.save(theMovie);
		
		return theMovie;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/movies")
	public Movie updateMovie(@RequestBody Movie theMovie) {
		
		movieService.save(theMovie);
		
		return theMovie;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/movies/{movieId}")
	public String deleteMovie(@PathVariable int movieId) {
		
		Movie tempMovie = movieService.findById(movieId);
		
		// throw exception if null
		
		if (tempMovie == null) {
			throw new RuntimeException("Movie id not found - " + movieId);
		}
		
		movieService.deleteById(movieId);
		
		return "Deleted employee id - " + movieId;
	}
	
}










