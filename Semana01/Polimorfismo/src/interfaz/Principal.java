package interfaz;

import java.util.*;

public class Principal {
	public static void main(String[] args) {
		
		List<Actividad> actividades = new ArrayList<>();
		actividades.add(new Buceo(8,4));
		actividades.add(new Kayak(2,2));
		actividades.add(new Parasailing(2,1));
		actividades.add(new Surf(1,3));
		actividades.add(new Pesca(4,6));
		
		
		for( Actividad act:actividades) {
			System.out.println(act);
			int resultado = act.calcularPrecio();
			System.out.println("$"+resultado);
		}
	}
}
