package pruebas;
import java.util.*;
public class Prueba {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		String texto[ ] = {"Uno", "Dos", "Tres", "Cuatro", "Cinco"};
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("indice " + i + " = " + texto[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Fallo en el índice " + i);
			}
		}
		try {
			System.out.print("Valor: ");
			int valor = lector.nextInt();
			int auxiliar = 8 / valor;
			System.out.println(auxiliar);
		} catch (ArithmeticException e1) {
			System.out.println("Division por cero");
		} catch (InputMismatchException e2) {
			System.out.println("No se ha leído un entero....");
		} catch (Exception e9) {
			System.out.println("Error general");
		} finally {
			lector.nextLine();
		}
		
		int valor1 = 0;
		boolean leido = false;
		do {
			try {
				System.out.println("Entra un número entero: ");
				valor1 = lector.nextInt();
				leido = true;
			} catch (InputMismatchException e3) {
				System.out.println("Error en la introducción del número");
				lector.nextLine();
			}
		} while (!leido);
		System.out.println("Hemos leido : " + valor1);

		lector.close();

	}

}
