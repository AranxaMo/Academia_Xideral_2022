package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.ActorDAO;
import spring.entity.Actor;

@Service
public class ActorServiceImpl implements ActorService {

	// need to inject customer dao
	@Autowired
	private ActorDAO actorDAO;
	
	@Override
	@Transactional
	public List<Actor> getActors() {
		return actorDAO.getActors();
	}

	@Override
	@Transactional
	public void saveActor(Actor theActor) {

		actorDAO.saveActor(theActor);
	}

	@Override
	@Transactional
	public Actor getActor(int theId) {
		
		return actorDAO.getActor(theId);
	}

	@Override
	@Transactional
	public void deleteActor(int theId) {
		
		actorDAO.deleteActor(theId);
	}
}





