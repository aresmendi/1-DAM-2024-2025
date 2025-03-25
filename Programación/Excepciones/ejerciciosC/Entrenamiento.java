package ejerciciosC;

public class Entrenamiento {

	public static void main(String[] args) {
		try {
			Corredor corredor = new Corredor(50);
			int vecesAgotado = 0;
			
			while(vecesAgotado < 3) {
				try {
					corredor.correr();
				} catch (AgotadoException e) {
					vecesAgotado++;
					System.out.println("El corredor se ha agotado " + vecesAgotado + " veces");
					e.printStackTrace();
					if(vecesAgotado == 1) {
						corredor.recargarEnergia(30);
						System.out.println("Recargando 30 de energía...");
					} else if (vecesAgotado == 2) {
						corredor.recargarEnergia(10);
						System.out.println("Recargando 10 de energía...");
					} else {
						System.out.println("Se acabó el entrene");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
