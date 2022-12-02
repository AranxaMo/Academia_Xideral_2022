package abstracta;

public class Buceo extends Actividad{
	int costoHora = 150; 
	
	public Buceo(int horas, int personas) {
		super(horas, personas);
	}
	

	@Override
	int calcularPrecio() {
		return (costoHora*horas)*personas;
	}
	
	
}
