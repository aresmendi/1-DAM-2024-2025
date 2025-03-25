package pruebas;

public class Saltador {
	//Atributos
	private int energia;
	//Constructor
	public Saltador(int energia) throws Exception {
		super();
		if(energia <0) throw new Exception("No puede haber energía negativa");
		this.energia = energia;
	}
	//Métodos
	public void recargarEnergia(int eng) {
		energia += eng;
	}
	public void saltar() throws AgotadoException {
		if(energia <10) {
			throw new AgotadoException("No queda suficiente energía");
		}
		else {
			System.out.println("El atleta se prepara para saltar...");
			energia-=10;
		}
	}
	
}
