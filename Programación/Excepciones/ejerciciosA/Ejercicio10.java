package ejerciciosA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double [] vector = new double[5];
		for (int i = 0; i < vector.length; i++) {
			boolean datoValido = false; //Necesario para el manejo de la excepción y la continuidad de la ejecución
			while(!datoValido) {
				try {
					System.out.println("Introduzca valor de " + i + " posición del vector");
					vector[i] = sc.nextDouble();
					sc.nextLine();//Esto tampoco se ejecuta si falla la linea anterior, por eso lo repetimos en los catch
					datoValido = true; //Sale del bucle si el dato es correcto, si no es correcto no llega a esta parte por que va al catch antes
				} catch (InputMismatchException e) {
					System.out.println("El dato introducido no es válido");
					sc.nextLine();
				} catch (Exception e1) {
					System.out.println("Excepción desconocida");
					sc.nextLine();
				}
			}
		}
		sc.close();
	}

}
