package ejerciciosC;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {
	public static void imprimePositivo(int p) {
		try {
			if(p < 0) {
				throw new Exception ("Valor introducido negativo, solo aceptamos positivos");
				}
			System.out.println("El valor es " + p);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static void imprimeNegativo(int n) {
		try {
			if(n >= 0) {
				throw new Exception ("Valor introducido positivo, solo aceptamos negativos");
				}
			System.out.println("El valor es " + n);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean acabar = false;
		int pos = 3, neg = -3;
		imprimeNegativo(neg);
		imprimeNegativo(pos);
		imprimePositivo(pos);
		imprimePositivo(neg);
		while(!acabar) {
			try {
				System.out.println("Introduzca un número entero. Introduzca 0 para salir");
				int num = sc.nextInt();
				sc.nextLine();
				if(num <0) {
					imprimeNegativo(num);
				}
				if(num >0){
					imprimePositivo(num);
				}
				if(num == 0) {
					acabar = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduzca un número entero válido");
				sc.nextLine();
			} catch (Exception e1) {
				System.out.println("Error desconocido");
			}
		}
		sc.close();
		System.out.println("Adios coleguita");
	}
}
