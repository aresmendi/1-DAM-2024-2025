package ejerciciosA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un valor:");
		try {
			//Importante meter esto dentro del try, si no no funciona
			int valor = sc.nextInt();
			sc.nextLine();
			System.out.println("Valor introducido: " + valor);
		} catch (InputMismatchException e) {
			System.out.println("Valor introducido incorrecto");
		}
		sc.close();
	}

}
