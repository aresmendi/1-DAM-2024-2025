package pruebas;

public class Entrenamiento {

	public static void main(String[] args) {
		try {
			Saltador pepe = new Saltador(50);
			int vecesCansado = 0;
			while(vecesCansado <3) {
				try {
					pepe.saltar();
				} catch (AgotadoException e) {
					vecesCansado++;
					e.printStackTrace();
					if(vecesCansado == 1) {
						pepe.recargarEnergia(30);
						System.out.println("Recargando 30 eng");
					}
					if(vecesCansado == 2) {
						pepe.recargarEnergia(10);
						System.out.println("Recargando 10 eng");
					}
					else System.out.println("Se acabó el entrene...");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
