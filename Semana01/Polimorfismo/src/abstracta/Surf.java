package abstracta;

public class Surf extends Actividad{
	int costoHora = 800;
	
	public Surf(int horas, int personas) {
		super(horas, personas);
	}

	@Override
	int calcularPrecio() {
		return (costoHora*horas)*personas;
	}
	
}
