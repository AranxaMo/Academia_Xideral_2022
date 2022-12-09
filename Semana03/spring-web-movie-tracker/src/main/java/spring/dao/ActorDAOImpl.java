package spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.entity.Actor;

@Repository
public class ActorDAOImpl implements ActorDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Actor> getActors() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Actor> theQuery = 
				currentSession.createQuery("from Actor order by lastName",
											Actor.class);
		
		// execute query and get result list
		List<Actor> actors = theQuery.getResultList();
				
		// return the results		
		return actors;
	}

	@Override
	public void saveActor(Actor theActor) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theActor);
		
	}

	@Override
	public Actor getActor(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Actor theActor = currentSession.get(Actor.class, theId);
		
		return theActor;
	}

	@Override
	public void deleteActor(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Actor where id=:actorId");
		theQuery.setParameter("actorId", theId);
		
		theQuery.executeUpdate();		
	}

}











