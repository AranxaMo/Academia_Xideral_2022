package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/ActorControllerServlet")
public class ActorControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ActorDbUtil actorDbUtil;
	
	@Resource(name="jdbc/web_movie_tracker") //SE COMENTO PARA HACER USO DE JNDI
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		// create our student db util ... and pass in the conn pool / datasource
		try {
			//https://www.digitalocean.com/community/tutorials/tomcat-datasource-jndi-example-java
			//Context ctx = new InitialContext(); //USO DE JNDI
			//dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/javatechie"); //USO DE JNDI
			//System.out.println("Demo con JNDI, Datasource: "+dataSource);
			actorDbUtil = new ActorDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
						
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listActors(request, response);
				break;
				
			case "ADD":
				addActor(request, response);
				break;
				
			case "LOAD":
				loadActor(request, response);
				break;
				
			case "UPDATE":
				updateActor(request, response);
				break;
			
			case "DELETE":
				deleteActor(request, response);
				break;
				
			default:
				listActors(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteActor(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student id from form data
		String theActortId = request.getParameter("actorId");
		
		// delete student from database
		actorDbUtil.deleteActor(theActortId);
		
		// send them back to "list students" page
		listActors(request, response);
	}

	private void updateActor(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("actorId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		// create a new student object
		Actor theActor = new Actor(id, firstName, lastName, email);
		
		// perform update on database
		actorDbUtil.updateActor(theActor);
		
		// send them back to the "list students" page
		listActors(request, response);
		
	}

	private void loadActor(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read student id from form data
		String theActorId = request.getParameter("actorId");

		// get student from database (db util)
		Actor theActor = actorDbUtil.getActor(theActorId);
		
		// place student in the request attribute
		request.setAttribute("THE_ACTOR", theActor);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-actor-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addActor(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");		
		
		// create a new student object
		Actor theActor = new Actor(firstName, lastName, email);
		
		// add the student to the database
		actorDbUtil.addActor(theActor);
				
		// send back to main page (the student list)
		listActors(request, response);
	}

	private void listActors(
			HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get students from db util
		List<Actor> actors = actorDbUtil.getActors();
		
		for (Actor s:actors) {
			System.out.println(s);
		}
		
		//students.add(new Student(999, "FirstName","lastName", "email@gmail"));
		// add students to the request
		request.setAttribute("LISTA_ACTORES", actors);
		
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-actors.jsp");
		dispatcher.forward(request, response);
	}

}













