package interfaz;

public class Pesca implements Actividad{
	int costoHora = 100;
	
	int horas;
	int personas;
	
	public Pesca(int horas, int personas) {
		this.horas = horas;
		this.personas = personas;
	}

	@Override
	public int calcularPrecio() {
		return (costoHora*horas)*personas;
	}

	@Override
	public String toString() {
		return "Costo de "+this.getClass().getSimpleName()+" por "
				+personas+" personas "+"durante "+horas+" horas:";
	}
}
