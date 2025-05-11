package ejerciciosBGestionFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca nombre del archivo a ordenar");
		String arch = sc.nextLine();
		
		File archivo = new File(arch);
		File sortAtcho = new File(archivo.getParent() + File.separator + "sorted_" + archivo.getName());
		
		try {
			Scanner scArch = new Scanner(archivo);
			ArrayList<String> listaPalabras = new ArrayList<>();
			while(scArch.hasNext()) {
				String palabra = scArch.next();
				listaPalabras.add(palabra);
			}
			
			listaPalabras.sort((a1,a2) -> a1.compareToIgnoreCase(a2));
			
			FileWriter sortedArch = new FileWriter(sortAtcho);
			for (String string : listaPalabras) {
				sortedArch.write(string + "\n");
			}
			sortedArch.close();
			scArch.close();
			sc.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
		} catch (IOException e) {
			System.out.println("Error de Input/Ouput");
		}
		
	}

}
