package ejerciciosBGestionFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {

		try {
			File dic = new File("ejerciciosBGestionFicheros\\Documentos\\Diccionario");
			File dicTxt = new File("ejerciciosBGestionFicheros\\Documentos\\diccionario.txt");

			if (!dic.exists()) {
				dic.mkdir();
			}
			//Usemos el ASCII para recorrer de la A a la Z
			for (int i = 65; i <= 90; i++) {
				Scanner scDicTxt = new Scanner(dicTxt);
				char letra = (char) i;
				//Creamos cada fichero
				File letraTxt = new File(dic, letra + ".txt");
				//Le metemos las palabras correspondientes del archivo diccionario.txt
				FileWriter letraDic = new FileWriter(letraTxt);
				ArrayList<String> lista = new ArrayList<>();
				while(scDicTxt.hasNext()) {
					String palabra = scDicTxt.next();
					if(palabra.toUpperCase().startsWith(String.valueOf(letra))) {
						lista.add(palabra + " \n");
					}
				}
				letraDic.write(letra + ": \n");
				for (String string : lista) {
					letraDic.write(string);
				}
				scDicTxt.close();
				letraDic.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error de Input/Output");
		}

	}

}
