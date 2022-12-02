/*
 	*Programa que utiliza expresiones lambda para obtener la información 
 	*de peliculas del studio ghibli, desde el título, fecha de estreno, duración(min) y rating
 	*
 	*Entrega: 02/12/2022
 	*Aranxa Guadalupe Martínez Ojeda
*/

package com.functionalLambda;

import java.util.*;
import java.util.function.*;


public class Principal {

	public static void main(String[] args) {		
		//Lista de peliculas
		List<Pelicula> listaPeliculas = new ArrayList<>();
		listaPeliculas.add(new Pelicula("La tumba de las luciérnagas",1998,89,8));
		listaPeliculas.add(new Pelicula("El viaje de Chihiro",2001,124,8.6));
		listaPeliculas.add(new Pelicula("Mi vecino totoro",1998,100,7.9));
		listaPeliculas.add(new Pelicula("Ponyo",2008,103,7));
		listaPeliculas.add(new Pelicula("El increíble castillo vagabundo",2004,119,9.2));
		listaPeliculas.add(new Pelicula("La princesa Mononoke",1997,133,8.4));
		listaPeliculas.add(new Pelicula("El castillo en el cielo",1986,124,6.4));
		listaPeliculas.add(new Pelicula("El cuento de la princesa Kaguya",2013,99,7.2));
		listaPeliculas.add(new Pelicula("Earwig y la bruja",2020,94,4.8));
		
		System.out.println("**************PELICULAS GHIBLI***************");
		
		System.out.println("----------¿Pelicula random tiene rating > 8.5?----------");
		Pelicula p1 = listaPeliculas.get((int)(Math.random()*listaPeliculas.size()));
		BiPredicate<Pelicula, Double> movie = (m1,r) -> m1.getRating() > r;
		System.out.println("La pelicula: "+p1.getTitulo()+"\nTiene rating mayor a 8.5: "+movie.test(p1, 8.5));
		
		System.out.println("\n------Pelicula con mayor duración------");
		Pelicula p2 = listaPeliculas.get((int)(Math.random()*listaPeliculas.size()));
		Pelicula p3 = listaPeliculas.get((int)(Math.random()*listaPeliculas.size()));
		
		BinaryOperator<Pelicula> movFunc = (m1,m2) -> m1.getDuracion()>m2.getDuracion() ? m1:m2;
		System.out.println(p2.getTitulo()+"\n"+p3.getTitulo()+"\nLa pelicula con mayor duracion es: \n"+movFunc.apply(p2, p3));
		
		System.out.println("---------Modificar rating------");
		listaPeliculas.replaceAll(m -> {
			m.setRating(m.getRating()+0.5);
			System.out.println(m.getTitulo()+" -> nuevo Rating: "+m.getRating());
			return m;
		});
		
	}
	
}
