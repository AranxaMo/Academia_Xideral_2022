package springboot.crud.entity;

import javax.persistence.*;
import lombok.*;

@Data 
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="movie_title")
	private String movieTitle;
	
	@Column(name="movie_category")
	private String movieCategory;
	
	@Column(name="movie_director")
	private String movieDirector;
	
	@Column(name="movie_rating")
	private String movieRating;
	
}











