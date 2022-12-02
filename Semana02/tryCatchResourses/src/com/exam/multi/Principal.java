package com.exam.multi;

import java.util.*;


public class Principal {
	
	public static void main(String[] args) {
		int numero1;
		int numero2;
		
		int suma;
		int division;
		Scanner entrada = new Scanner(System.in);
		
		try {
			System.out.println("Ingresa el primer número: ");
			numero1=entrada.nextInt();
			
			System.out.println("Ingresa el segundo número: ");
			numero2=entrada.nextInt();
			
			suma = numero1+numero2;
			division = numero1/numero2;
			
		} catch (InputMismatchException e) {
			System.out.println("Tipo de dato no válido, debes de ingresar un entero");
		} catch(ArithmeticException e) {
			System.out.println("Operación no válida. No se puede dividir entre cero");
		}finally {
			System.out.println("Aplicando multicatch en un programa");
		}
	}
}
