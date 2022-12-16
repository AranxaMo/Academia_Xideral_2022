package springboot.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springboot.crud.entity.Movie;
import springboot.crud.service.MovieService;

@Controller
@RequestMapping("/mvc")
public class MovieMvcController {

	// need to inject our customer service
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/movies")
	public String listMovies(Model theModel) {
		
		// get customers from the service
		List<Movie> theMovies = movieService.findAll();
				
		// add the customers to the model
		theModel.addAttribute("movies", theMovies);
		
		return "list-movies";  //***
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Movie theMovie = new Movie();
		
		theModel.addAttribute("movie", theMovie);
		
		return "movie-form";   //************
	}
	
	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie theMovie) {
		
		// save the customer using our service
		movieService.save(theMovie);	
		
		return "redirect:/mvc/movies";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("movieId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Movie theMovie = movieService.findById(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("movie", theMovie);
		
		// send over to our form		
		return "movie-form";    //************
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("movieId") int theId) {
		
		// delete the customer
		movieService.deleteById(theId);
		
		return "redirect:/mvc/movies";
	}

}










