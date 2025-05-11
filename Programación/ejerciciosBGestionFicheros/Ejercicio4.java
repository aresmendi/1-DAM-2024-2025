package ejerciciosBGestionFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		File nom = new File("ejerciciosBGestionFicheros\\Documentos\\usa_nombres.txt");
		File ape = new File("ejerciciosBGestionFicheros\\Documentos\\usa_apellidos.txt");
		File nomGen = new File("ejerciciosBGestionFicheros\\Documentos\\usa_personas.txt");
		Random rnd = new Random();
		Scanner sc = new Scanner(System.in);
		try {
			Scanner scNom = new Scanner(nom);
			Scanner scApe = new Scanner(ape);
			FileWriter aleator = new FileWriter(nomGen);
			ArrayList<String> listaNombres = new ArrayList<>();
			ArrayList<String> listaApellidos = new ArrayList<>();

			while(scNom.hasNext()) {
				listaNombres.add(scNom.next());
			}
			while(scApe.hasNext()) {
				listaApellidos.add(scApe.next());
			}
			
			System.out.println("¿Cuantos nombres de persona desea?");
			
			int cantidad = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < cantidad; i++) {
				String nombre = listaNombres.get(rnd.nextInt(listaNombres.size()));
				String apellido = listaApellidos.get(rnd.nextInt(listaApellidos.size()));
				aleator.write(nombre + " " + apellido + "\n");
			}
			sc.close();
			scNom.close();
			scApe.close();
			aleator.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el archivo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error de Input/Ouput");;
		}


	}

}
