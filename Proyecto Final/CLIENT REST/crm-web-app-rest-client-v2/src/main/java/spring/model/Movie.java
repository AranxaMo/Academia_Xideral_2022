package spring.model;

public class Movie {

	private int id;
	private String movieTitle;
	private String movieCategory;	
	private String movieDirector;
	private String movieRating;
	
	public Movie() {
	}

	public Movie(String movieTitle, String movieCategory, String movieDirector, String movieRating) {
		this.movieTitle = movieTitle;
		this.movieCategory = movieCategory;
		this.movieDirector = movieDirector;
		this.movieRating = movieRating;
	}

	public Movie(int id,String movieTitle, String movieCategory, String movieDirector, String movieRating) {
		this.id = id;
		this.movieTitle = movieTitle;
		this.movieCategory = movieCategory;
		this.movieDirector = movieDirector;
		this.movieRating = movieRating;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieCategory() {
		return movieCategory;
	}

	public void setMovieCategory(String movieCategory) {
		this.movieCategory = movieCategory;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	
	public String getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieTitle=" + movieTitle + ", movieCategory=" + movieCategory + ", movieDirector=" + movieDirector +", movieRating=" + movieRating + "]";
	}
		
}











