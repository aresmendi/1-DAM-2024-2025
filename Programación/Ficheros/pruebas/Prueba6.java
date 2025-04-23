package pruebas;

import java.io.File;
import java.util.Scanner;

public class Prueba6 {
	public static final int NUM_VALORES = 10;
	public static void main(String[] args) {

		try {
			// Intentamos abrir el fichero
			File f = new File("C:/Temp/Escaner/Enteros.txt");
			Scanner lector = new Scanner(f);

			// Si llega aquí es que ha abierto el fichero :)
			for (int i = 0; i < NUM_VALORES; i++) {
				int valor = lector.nextInt();
				System.out.println("El valor leído es: " + valor);
			}

			// ¡Hay que cerrar el fichero!
			lector.close();

		} catch (Exception e) {
			// En caso de excepción mostramos el error
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
}
