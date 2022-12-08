package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Actor;

public interface ActorService {

	public List<Actor> getActors();

	public void saveActor(Actor theActor);

	public Actor getActor(int theId);

	public void deleteActor(int theId);
	
}
