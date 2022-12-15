package spring.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import spring.model.Movie;

@Service
public class MovieServiceRestClientImpl implements MovieService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public MovieServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Movie> getMovies() {
		
		logger.info("***OBTENER LISTA DE PELICULAS DESDE EL SERVICE REST CLIENTE");
		logger.info("in getMovies(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Movie>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
													 new ParameterizedTypeReference<List<Movie>>() {});

		// get the list of movies from response
		List<Movie> movies = responseEntity.getBody();

		logger.info("in getMovies(): movies" + movies);
		
		return movies;
	}

	@Override
	public Movie getMovie(int theId) {
		logger.info("***OBTENER UNA PELICULA DESDE EL SERVICE REST CLIENTE");

		logger.info("in getMovie(): Calling REST API " + crmRestUrl);

		// make REST call
		Movie theMovie = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Movie.class);

		logger.info("in saveMovie(): theMovie=" + theMovie);
		
		return theMovie;
	}

	@Override
	public void saveMovie(Movie theMovie) {

		logger.info("in saveMovie(): Calling REST API " + crmRestUrl);
		
		int movieId = theMovie.getId();

		// make REST call
		if (movieId == 0) {
			// add employee
			logger.info("***SALVAR UNA PELICULA DESDE EL SERVICE REST CLIENTE");

			restTemplate.postForEntity(crmRestUrl, theMovie, String.class);			
		
		} else {
			// update employee
			logger.info("***ACTUALIZAR UNA PELICULA DESDE EL SERVICE REST CLIENTE");

			restTemplate.put(crmRestUrl, theMovie);
		}

		logger.info("in saveMovie(): success");	
	}

	@Override
	public void deleteMovie(int theId) {
		logger.info("***BORRAR UNA PELICULA DESDE EL SERVICE REST CLIENTE");

		logger.info("in deleteMovie(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteMovie(): deleted movie theId=" + theId);
	}

}
