package com.functionalLambda;

public class Pelicula {
	private String titulo;
	private int fecha;
	private int duracion;
	private double rating;
	
	public Pelicula(String titulo, int fecha, int duracion, double rating) {
		this.titulo = titulo;
		this.fecha = fecha;
		this.duracion = duracion;
		this.rating = rating;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return titulo + "\n\t" + fecha + " - Duracion: " + duracion +"min"+ " - Rating:" + rating
				+ "\n";
	}

	
}
