package ejerciciosAGestionFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class Ejercicio2 {
	public static void muestraInfoRuta(File ruta, boolean info) throws FileNotFoundException {
		if(!ruta.exists()) {
			throw new FileNotFoundException("La ruta no existe: " + ruta.getAbsolutePath());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		if (ruta.isFile()) {
			if(info) {
				System.out.println("[A] " + ruta.getName() + " - " +
						ruta.length() + " bytes - " +
						sdf.format(new Date(ruta.lastModified())));
			} else {
				System.out.println("[A] " + ruta.getName());
			}
			return;
		}
		if(ruta.isDirectory()) {
			File[] lista = ruta.listFiles();
			if(lista == null) {
				throw new FileNotFoundException("No se puede acceder al contenido de la ruta");
			}
			//Ordenamos alfabéticamente
			Arrays.sort(lista, (a,b) -> a.getName().compareToIgnoreCase(b.getName()));

			System.out.println("Contenido de " + ruta.getAbsolutePath() + ":");
			//Primero mostramos los directorios
			for (File file : lista) {
				if(file.isDirectory()) {
					if(info) {
						System.out.println("[*] " + file.getName() + " - " +
								file.length() + " bytes - " +
								sdf.format(new Date(file.lastModified())));
					} else {
						System.out.println("[*] " + file.getName());
					}
				}
			}
			//Luego mostramos archivos
			for (File file : lista) {
				if(file.isFile()) {
					if (info) {
						System.out.println("[A] " + file.getName() + " - " +
								file.length() + " bytes - " +
								sdf.format(new Date(file.lastModified())));
					} else {
						System.out.println("[A] " + file.getName());
					}
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
			} 
			
			File route = new File(ruta);
			
			System.out.println("¿Quiere ver la información del archivo?[y,n]");
			while(true) {
				String info = sc.nextLine();
				if(info.equalsIgnoreCase("y")) {
					try {
						muestraInfoRuta(route,true);
						break;
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println("Error: " + e.getMessage());
						break;
					}
				}else if(info.equalsIgnoreCase("n")){
					try {
						muestraInfoRuta(route,false);
						break;
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println("Error: " + e.getMessage());
						break;
					}
				}else {
					System.out.println("Valor introducido incorrecto, vuelva intentarlo");
				}
			}
		}
	}
}
