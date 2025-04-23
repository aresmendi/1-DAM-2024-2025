package ejerciciosAGestionFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio1 {
	public static void muestraInfoRuta(File ruta) throws FileNotFoundException {
		if(!ruta.exists()) {
			throw new FileNotFoundException("La ruta no existe: " + ruta.getAbsolutePath());
		}
		if (ruta.isFile()) {
			System.out.println("[A]" + ruta.getName());
			return;
		}
		if(ruta.isDirectory()) {
			File[] lista = ruta.listFiles();
			if(lista == null) {
				throw new FileNotFoundException("No se puede acceder al contenido de la ruta");
			}
			System.out.println("Contenido de " + ruta.getAbsolutePath() + ":");
			//Primero mostramos los directorios
			for (File file : lista) {
				if(file.isDirectory()) {
					System.out.println("[*]" + file.getName());
				}
			}
			//Luego mostramos archivos
			for (File file : lista) {
				if(file.isFile()) {
					System.out.println("[A]" + file.getName());
				}
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		//Mostrar la infomación de los ficheros
		while(true) {
			System.out.println("Introduzca una ruta del sistema de archivos");
			String ruta = sc.nextLine();
			if(ruta.isEmpty()) {
				System.out.println("Terminando el programa...");
				sc.close();
				return;
			} else {
				File route = new File(ruta);
				try {
					muestraInfoRuta(route);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Error: " + e.getMessage());
				}

			}
		}
	}

}
