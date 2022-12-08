package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Actor;

public interface ActorDAO {

	public List<Actor> getActors();

	public void saveActor(Actor theActor);

	public Actor getActor(int theId);

	public void deleteActor(int theId);
	
}
