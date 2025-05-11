package ejerciciosBGestionFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un número entero");
		try {
			int busqueda = sc.nextInt();
			String buq = String.valueOf(busqueda);
			File pi = new File("ejerciciosBGestionFicheros\\Documentos\\pi-million.txt");
			Scanner scPi = new Scanner(pi);
			//Usamos StringBuilder para copiar el contenido de pi.txt
			StringBuilder piCompleto = new StringBuilder();
			while(scPi.hasNext()) {
				piCompleto.append(scPi.next());
			}
			scPi.close();
			//Casteamos a String
			String piripi = piCompleto.toString();
			//Yo lo siento pero pasando de rollos, buscando con indexOf
			int pos = piripi.indexOf(buq);
			if(pos != -1) {
				System.out.println("El numero aparece en PI en la posicion " + pos);
			}
			else {
				System.out.println("El numero no aparece en el primer millón de cifras de PI");
			}
			sc.close();
		} catch (InputMismatchException e) {
			System.out.println("Debe introducir un número entero");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Archivo no encotrado");
		}

	}

}
