package springboot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.crud.entity.Movie;

@Repository
public class MovieDAOHibernateImpl implements MovieDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public MovieDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Movie> findAll() {
		System.out.println("MovieDAOHibernateImpl");
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Movie> theQuery =
				currentSession.createQuery("from Movie", Movie.class);
		
		// execute query and get result list
		List<Movie> movies = theQuery.getResultList();
		
		// return the results		
		return movies;
	}


	@Override
	public Movie findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Movie theMovie =
				currentSession.get(Movie.class, theId);
		
		// return the employee
		return theMovie;
	}


	@Override
	public void save(Movie theMovie) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theMovie);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Movie where id=:movieId");
		
		theQuery.setParameter("movieId", theId);
		
		theQuery.executeUpdate();
	}

}







