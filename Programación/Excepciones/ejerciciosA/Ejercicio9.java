package ejerciciosA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Introduzca valor A");
			int a = sc.nextInt();
			sc.nextLine();
			System.out.println("Introduzca valor B");
			int b = sc.nextInt();
			sc.nextLine();
			int c = a/b;
			System.out.println("El resultado es " + c);
		} catch (InputMismatchException e) {
			System.out.println("Número introducido incorrecto");
		} catch (ArithmeticException e1) {
			System.out.println("Fallo en la división");
		}
		sc.close();
	}

}
