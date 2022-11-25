package interfaz;

public class Surf implements Actividad{
	int costoHora = 800;
	
	int horas;
	int personas;
	
	public Surf(int horas, int personas) {
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
