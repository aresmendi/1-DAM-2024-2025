package pruebas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Prueba7 {
	public static void main(String[] args) {
		try {
			File f = new File("C:/Temp/Escaner/Enteros.txt");
			FileWriter fw = new FileWriter(f);
			int valor = 1;
			for (int i = 1; i <= 20; i++) {
				fw.write("" + valor); // escribimos valor
				fw.write(" "); // escribimos espacio en blanco
				valor = valor * 2; // calculamos próximo valor
			}
			fw.write("\n"); // escribimos nueva línea
			fw.close(); // cerramos el FileWriter
			System.out.println("Fichero escrito correctamente");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}
}
