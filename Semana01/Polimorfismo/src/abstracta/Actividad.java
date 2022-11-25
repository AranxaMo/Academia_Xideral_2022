package abstracta;

public abstract class Actividad {
	int horas;
	int personas;
	
	public Actividad(int horas, int personas) {
		super();
		this.horas = horas;
		this.personas = personas;
	}
	
	abstract int calcularPrecio();

	@Override
	public String toString() {
		return "Costo de "+this.getClass().getSimpleName()+" por "
				+personas+" personas "+"durante "+horas+" horas:";
	}
	
	
}
