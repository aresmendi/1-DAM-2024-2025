package ejerciciosBGestionFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		File nums = new File("ejerciciosBGestionFicheros\\Documentos\\numeros.txt");
		try {
			Scanner scNum = new Scanner(nums);
			int min = scNum.nextInt();
			int max = scNum.nextInt();
			while(scNum.hasNextInt()) {
				int num = scNum.nextInt();
				if(num < min) min = num;
				if(num > max) max = num;
			}
			System.out.println("Mínimo: "+ min);
			System.out.println("Máximo: " + max);
			scNum.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
