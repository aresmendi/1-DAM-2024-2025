package cifradoCesar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cesar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File userInfo = new File(System.getProperty("user.dir").concat("userInfo.txt"));
		System.out.println(userInfo.getAbsolutePath()); //Esto lo dejo para que sea fácil encontrarlo luego xD
		try {
			FileWriter us = new FileWriter(userInfo);
			boolean correcto1 = false;
			boolean correcto2 = false;
			boolean correcto3 = false;
			while(!correcto1) {
				System.out.println("Introduce un nombre de usuario (entre 5 y 15 caracteres):");
				String nombre = sc.nextLine();
				if(nombre.length()>5 && nombre.length()<15) {
					correcto1=true;
					//Cogemos cada char del nombre
					for (int i = 0; i < nombre.length(); i++) {
						char c = nombre.charAt(i);
						//Lo pasamos a la movida esta del ascii
						int ascii = (int) c;
						//Sumámosle 5, retornamos y lo guardamos 
						ascii += 5;
						us.write((char)ascii);
					}
					us.write("\n");
				}else {
					System.out.println("Introduzca entre 5 y 15 caracteres");
				}
			}
			while(!correcto2) {
				System.out.println("Introduce una contraseña (entre 5 y 15 caracteres):");
				String contra = sc.nextLine();
				if(contra.length()>5 && contra.length()<15) {
					correcto2=true;
					for (int i = 0; i < contra.length(); i++) {
						char c = contra.charAt(i);
						int ascii = (int) c;
						ascii += 5;
						us.write((char)ascii);
					}
					us.write("\n");
				}else {
					System.out.println("Introduzca entre 5 y 15 caracteres");
				}
			}
			while(!correcto3) {
				System.out.println("Introduce una frase de recordatorio de la contraseña (mínimo 15 caracteres):");
				String frase = sc.nextLine();
				if(frase.length()>15) {
					correcto3=true;
					for (int i = 0; i < frase.length(); i++) {
						char c = frase.charAt(i);
						int ascii = (int) c;
						ascii += 5;
						us.write((char)ascii);
					}
					us.write("\n");
				}else {
					System.out.println("Introduzca 15 caracteres mínimo");
				}
			}
			
			sc.close();
			us.close();
		} catch (IOException e) {
			System.out.println("Error de Input/Ouput");
		}
	
	}

}
