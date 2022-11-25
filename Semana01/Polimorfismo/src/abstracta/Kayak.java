package abstracta;

public class Kayak extends Actividad{
	int costoHora = 200; 
	
	public Kayak(int horas, int personas) {
		super(horas, personas);
	}

	@Override
	int calcularPrecio() {
		return (costoHora*horas)*personas;
	}

}
