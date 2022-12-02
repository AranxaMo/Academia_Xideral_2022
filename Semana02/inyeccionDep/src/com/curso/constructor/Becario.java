package com.curso.constructor;

public class Becario {
	private String nombre;
	private Pc myPc;
	
	public Becario(String nombre, Pc mypc) {
		this.nombre = nombre;
		this.myPc = mypc;
	}
	
	
	void encenderPc() {
		System.out.println(nombre);
		myPc.encender();
	}
}
