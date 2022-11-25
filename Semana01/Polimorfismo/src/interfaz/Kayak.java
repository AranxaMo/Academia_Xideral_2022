package interfaz;

public class Kayak implements Actividad{
	int costoHora = 200; 
	
	int horas;
	int personas;
	
	public Kayak(int horas, int personas) {
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
