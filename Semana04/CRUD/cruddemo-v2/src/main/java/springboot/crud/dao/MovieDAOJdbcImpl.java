package springboot.crud.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.crud.entity.Movie;

@Repository
public class MovieDAOJdbcImpl implements MovieDAO {

	@Autowired
	DataSource dataSource;

	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;

	//***************FIND ALL EMPLOYEES*********************
	@Override
	public List<Movie> findAll() {
		System.out.println("Implementación DAO con JDBC: "+ dataSource);
		
		List<Movie> listaPeliculas = new ArrayList<>();
		String sql = "select * from movie";

		try(Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql);) {
						

			while (myRs.next()) {
										
				int id = myRs.getInt("id");
				String movieTitle = myRs.getString("movie_title");
				String movieCategory = myRs.getString("movie_category");
				String movieDirector = myRs.getString("movie_director");
				String movieRating = myRs.getString("movie_director");
							
				Movie tempMovie = new Movie(id, movieTitle, movieCategory, movieDirector, movieRating);
							
				listaPeliculas.add(tempMovie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaPeliculas;
	}
	
	//***************FIND EMPLOYEE*********************
	@Override
	public Movie findById(int theId) {
		Movie theMovie = null;
		
		try(Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = createPreparedStatement(myConn, theId);
			ResultSet myRs = myStmt.executeQuery();) {			
	
			if (myRs.next()) {
				String movieTitle = myRs.getString("movie_title");
				String movieCategory = myRs.getString("movie_category");
				String movieDirector = myRs.getString("movie_director");
				String movieRating = myRs.getString("movie_director");
				
				theMovie = new Movie(theId, movieTitle, movieCategory, movieDirector, movieRating);
			}
			else {
				throw new SQLException("Could not find movie id: " + theId);
			}				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theMovie;
	}
	
	private PreparedStatement createPreparedStatement(Connection con, int movieId) throws SQLException {
	    String sql = "SELECT * from movie where id=?";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, movieId);
	    return ps;
	}
	
	//***************SAVE & UPDATE*********************
	
		@Override
		public void save(Movie theMovie) {
			String sql;
			if(theMovie.getId() == 0)
				sql = "insert into movie "+"(movie_title, movie_category, movie_director, movie_rating) "+"values (?, ?, ?, ?)";
			else
				sql = "update movie "+"set movie_title=?, movie_category=?, movie_director=?, movie_rating=? "+"where id=?";
				
				
			try(Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = myConn.prepareStatement(sql);) {
				
				myStmt.setString(1, theMovie.getMovieTitle());
				myStmt.setString(2, theMovie.getMovieCategory());
				myStmt.setString(3, theMovie.getMovieDirector());
				myStmt.setString(4, theMovie.getMovieRating());
				
				if(theMovie.getId() != 0)
					myStmt.setInt(4, theMovie.getId());
				
				myStmt.execute();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//***************DELETE*********************
		
		@Override
		public void deleteById(int theId) {
			String sql = "DELETE from movie where id=?";
			
			try(Connection myConn =dataSource.getConnection();
				PreparedStatement myStmt =  myConn.prepareStatement(sql);) {
				
				myStmt.setInt(1, theId);
				myStmt.execute();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}

		}
}
