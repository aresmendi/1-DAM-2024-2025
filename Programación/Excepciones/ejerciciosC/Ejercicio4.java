package ejerciciosC;

import java.util.ArrayList;
import java.util.Scanner;


public class Ejercicio4 {

	public static void main(String[] args) {
		ArrayList<Gato> listaGatos = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while(listaGatos.size() < 5) {
			boolean gatoCreado = false; //Controla que se añada un gato correctamente
			while(!gatoCreado){ //Se repite hasta que el usuario introduce datos correctos
				try {
					System.out.println("Introduzca nombre del gato");
					String nombre = sc.nextLine();
					System.out.println("Introduzca la edad del gato");
					int edad = sc.nextInt();
					sc.nextLine();
					listaGatos.add(new Gato(nombre, edad)); //Aquí se lanzarán la excepciones que se capturen luego en el catch
					gatoCreado = true;
				} catch (Exception e) {
					System.out.println("Error: Introduzca datos correctos");
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}
		System.out.println("Lista de gatos creada: " + listaGatos);
		sc.close();
	}

}
