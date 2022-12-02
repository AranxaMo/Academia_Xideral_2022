package com.curso.setter;

public class Principal {

	public static void main(String[] args) {
		
		Becario becario = new Becario("Ezequiel");
		Inyector.inyectarPc(becario);
		
		becario.encenderPc();
	}

}
