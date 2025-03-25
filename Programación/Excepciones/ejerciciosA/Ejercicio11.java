package ejerciciosA;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		Random r1 = new Random();
		int tamVector = r.nextInt(101);
		int [] vector = new int[tamVector];
		for (int i = 0; i < vector.length; i++) {
			int numVector = r1.nextInt(11);
			vector[i] = numVector;
		}
		boolean funciona = false;
		while(!funciona) {
			try {
				System.out.println("Introduzca la posición del vector que desea ver: ");
				int posVector = sc.nextInt();
				if (posVector <0) {
					System.out.println("Números negativos no aceptados, cerrando el programa");
					funciona = true;
					break;
				}
				sc.nextLine();
				System.out.println(vector[posVector]);
			} catch (InputMismatchException e) {
				System.out.println("Dato introducido incorrecto, pruebe con número entero");
				sc.nextLine();
			} catch (ArrayIndexOutOfBoundsException e1) {
				System.out.println("No existe esa posición en el array, pruebe de nuevo");
				//Aquí no me hace falta limpiar el buffer de nuevo, por que esa linea que limpia el buffer ya se ha ejecutado cuando sucede este error
			} catch (Exception e2) {
				System.out.println("Excepcion desconocida");
				sc.nextLine();
			}
		}
		sc.close();
		System.out.println("Programa finalizado");
	}

}
