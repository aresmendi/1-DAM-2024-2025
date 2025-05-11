package ejerciciosBGestionFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre de la ruta al archivo de texto");
		String ruta = sc.nextLine();
		if(!ruta.endsWith(".txt")) {
			System.out.println("Error, solo puede leer archivos .txt");
			return;
		}
		File doc = new File(ruta); 
		try {
			Scanner scDoc = new Scanner(doc);
			//Tablas para las estadísticas
			Hashtable<String, Integer> saltosDeLinea = new Hashtable<String, Integer>();
			Hashtable<String, Integer> numPalabras = new Hashtable<String, Integer>();
			Hashtable<String, Integer> numCaracteres = new Hashtable<String, Integer>();
			Hashtable<String, Integer> palabrasComunes = new Hashtable<String, Integer>();
			//Contadores
			int lineas = 0;
			int palabras  = 0;
			int caracteres = 0;
			while(scDoc.hasNext()) {
				String linea = scDoc.nextLine();
				lineas++;
				caracteres += linea.length();
				String[] palabrasLinea = linea.split(" ");
				palabras += palabrasLinea.length;
				//Usamos un For each para gestionar lo de leer cada palabra
				for (String palabra : palabrasLinea) {
					palabra = palabra.toLowerCase();
					if (palabrasComunes.containsKey(palabra)) {
						palabrasComunes.put(palabra, palabrasComunes.get(palabra) + 1);
					} else {
						palabrasComunes.put(palabra, 1);
					}
				}
			}

			//Guardamos los valores en las tablas
			saltosDeLinea.put("lineas", lineas);
			numPalabras.put("palabras", palabras);
			numCaracteres.put("caracteres", caracteres);

			//Imprimimos
			System.out.println("Líneas: " + saltosDeLinea.get("lineas"));
			System.out.println("Palabras: " + numPalabras.get("palabras"));
			System.out.println("Caracteres: " + numCaracteres.get("caracteres"));

			System.out.println("10 palabras más usadas:");
			for (int i = 0; i <10; i++) {
				String maxPalabra = null;
				int maxFrecuencia = -1;
				//Buscamos la palabra con mayor frecuencia
				for (String palabra : palabrasComunes.keySet()) {
					int frecuencia = palabrasComunes.get(palabra);
					if (frecuencia > maxFrecuencia) {
						maxFrecuencia = frecuencia;
						maxPalabra = palabra;
					}
				}
				//Imprimimos y eliminamos para buscar la siguiente en la próxima vuelta
				if (maxPalabra != null) {
					System.out.println(maxPalabra + ": " + maxFrecuencia);
					palabrasComunes.remove(maxPalabra);
				} else {
					break; //Esto pasaría si no quedasen más palabras
				}
			}
			sc.close();
			scDoc.close();

		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}
	}

}
