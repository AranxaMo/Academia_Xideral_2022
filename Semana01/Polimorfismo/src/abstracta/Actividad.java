package abstracta;

public abstract class Actividad {
	int horas;
	int personas;
	int precio;
	
	public Actividad(int horas, int personas) {
		this.horas = horas;
		this.personas = personas;
	}
	
	abstract int calcularPrecio();

	@Override
	public String toString() {
		return "Costo de "+this.getClass().getSimpleName()+" por "
				+personas+" personas "+"durante "+horas+" horas:";
	}
	
	public void promocion(int valor) {
		if(valor > 3) {
			System.out.println("Promoción exclusiva 25% de descuento al ser 3 personas o más, precio con descuento: "+precio);
		}
		else {
			System.out.println("No tienes descuentos adicionales");
		}
	}
}
