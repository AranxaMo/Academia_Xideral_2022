package abstracta;

public class Parasailing extends Actividad{
	int costoHora = 1200;
	
	public Parasailing(int horas, int personas) {
		super(horas, personas);
	}

	@Override
	int calcularPrecio() {
		return (costoHora*horas)*personas;
	}

}
