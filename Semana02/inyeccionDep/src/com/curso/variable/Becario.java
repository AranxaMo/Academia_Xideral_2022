package com.curso.variable;

public class Becario {
	private String nombre;
	private Pc myPc;
	
	public Pc getMyPc() {
		return myPc;
	}

	public void setMyPc(Pc myPc) {
		this.myPc = myPc;
	}

	public Becario(String nombre) {
		this.nombre = nombre;
	}
	
	void encenderPc() {
		System.out.println(nombre);
		myPc.encender();
	}
}
