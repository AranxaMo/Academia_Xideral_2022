/*
 	*Programa que utiliza expresiones lambda para obtener la información 
 	*de peliculas del studio ghibli, desde el título, fecha de estreno, duración(min) y rating
 	*
 	*Entrega: 02/12/2022
 	*Aranxa Guadalupe Martínez Ojeda
*/

package com.predicateLambda;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String search;
		
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

		System.out.println("----------Rating mayor a 8----------");
		mostrarInfo(listaPeliculas,movie -> movie.getRating()>8);
		
		System.out.println("----------Duración menor a 100min----------");
		mostrarInfo(listaPeliculas,movie -> movie.getDuracion()<100);
		
		System.out.println("----------Fecha estreno mayor a 2000----------");
		mostrarInfo(listaPeliculas,movie -> movie.getFecha()>2000);
		
		System.out.println("Busca una pelicula:");
		search=entrada.nextLine();
		System.out.println("RESULTADO: ");
		mostrarInfo(listaPeliculas,movie -> movie.getTitulo().contains(search));
		
		
	}
	
	
	
	static void mostrarInfo(List<Pelicula> lista, PredicadoPeliculas mov) {
		for(Pelicula p:lista) {
			if (mov.mostrarPeli(p))			//La lambda se ejecuta
				System.out.println(p);
		}
	}
}
