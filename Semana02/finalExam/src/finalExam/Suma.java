package finalExam;

//No puede heredar de Operacion
public class Suma extends Operacion{	

	public Suma(int x, int y) {
		super(x, y);
	}
	
	@Override 
	public int resultado() {
		return x+y;
	}
}
