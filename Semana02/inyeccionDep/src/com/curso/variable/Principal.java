package com.curso.variable;

public class Principal {

	public static void main(String[] args) {
		
		Becario becario = new Becario("Aranxa");
		Inyector.inyectarPc(becario);
		
		becario.encenderPc();
	}

}
