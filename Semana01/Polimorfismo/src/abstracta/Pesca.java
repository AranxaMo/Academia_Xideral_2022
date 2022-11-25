package abstracta;

public class Pesca extends Actividad{
	int costoHora = 100;
	
	public Pesca(int horas, int personas) {
		super(horas, personas);
	}

	@Override
	int calcularPrecio() {
		return (costoHora*horas)*personas;
	}

}
