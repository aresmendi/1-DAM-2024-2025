package ejerciciosC;
class AgotadoException extends Exception{
	private static final long serialVersionUID = 1L; //Para eliminar el error de que le falta serializacion
	public AgotadoException (String msj) {
		super (msj);
	}
}

public class Corredor {
	//Atributos
	private int energia;

	public Corredor(int energia) throws Exception {
		super();
		if(energia<0) throw new Exception("Energía no puede ser negativa");
		this.energia = energia;
	}
	public void recargarEnergia(int eng) {
		energia += eng;
	}
	public void correr() throws AgotadoException {
			if(energia >= 10) {
				System.out.println("El corredor se lanza, con " + energia + " de energía");
				energia-=10;
			}
			else throw new AgotadoException("El corredor no tiene suficiente energía");
	}
}
