package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Actor;
import com.luv2code.springdemo.service.ActorService;

@Controller
@RequestMapping("/actor")
public class ActorController {

	// need to inject our customer service
	@Autowired
	private ActorService actorService;
	
	@GetMapping("/list")
	public String listActors(Model theModel) {
		
		// get customers from the service
		List<Actor> theActors = actorService.getActors();
				
		// add the customers to the model
		theModel.addAttribute("actors", theActors);
		
		return "list-actors";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Actor theActor = new Actor();
		
		theModel.addAttribute("actor", theActor);
		
		return "actor-form";
	}
	
	@PostMapping("/saveActor")
	public String saveActor(@ModelAttribute("actor") Actor theActor) {
		
		// save the customer using our service
		actorService.saveActor(theActor);	
		
		return "redirect:/actor/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("actorId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Actor theActor = actorService.getActor(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("actor", theActor);
		
		// send over to our form		
		return "actor-form";
	}
	
	@GetMapping("/delete")
	public String deleteActor(@RequestParam("actorId") int theId) {
		
		// delete the customer
		actorService.deleteActor(theId);
		
		return "redirect:/actor/list";
	}
}










