package com.exam.resources;

import java.util.ArrayList;
import java.util.List;


public class Principal {
	public static void main(String[] args){
		List<Libro> listaLibros = new ArrayList<>();
		listaLibros.add(new Libro("La canción de aquiles",500));
		listaLibros.add(new Libro("Danza de Dragones",700));
		listaLibros.add(new Libro("Trono de Cristal",804));
		listaLibros.add(new Libro("El Resplandor",652));
		
		
		Libro p1 = listaLibros.get((int)(Math.random()*listaLibros.size()));
		String randomTitle = p1.getTitulo();
		
		try (LectorArchivo book = new LectorArchivo(randomTitle)) {
			System.out.println("Bloque Try");
		}finally{
			System.out.println("Bloque Finally");
		}
	}
	
	
}
