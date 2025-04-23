package ejerciciosAGestionFicheros;

import java.io.File;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File misCosas = new File("ejerciciosAGestionFicheros\\DOCS\\MisCosas");
		String carpetaCreada = misCosas.mkdir()?"Carpeta creada":"Error al crear la carpeta";
		System.out.println(carpetaCreada);
		File alfabeto = new File("ejerciciosAGestionFicheros\\DOCS\\Alfabeto");
		String carpetaCreada2 = alfabeto.mkdir()?"Carpeta creada":"Error al crear la carpeta";
		System.out.println(carpetaCreada2);
		File origen1 = new File("ejerciciosAGestionFicheros\\DOCS\\FOTOS");
		File destino1 = new File("ejerciciosAGestionFicheros\\DOCS\\MisCosas\\FOTOS"); // Nuevo destino
		File origen2 = new File("ejerciciosAGestionFicheros\\DOCS\\LECTURAS");
		File destino2 = new File("ejerciciosAGestionFicheros\\DOCS\\MisCosas\\LECTURAS"); // Nuevo destino
		boolean res1 = origen1.renameTo(destino1);
		System.out.println("¿Se ha movido la carpeta?: " + res1);
		boolean res2 = origen2.renameTo(destino2);
		System.out.println("Se ha movido la carpeta?: " + res2);
		//Vamos con lo de las carpetas de la A a la Z
		for (int i = 65; i <= 90; i++) {
			char letra = (char) i;
			//Creamos la subcarpeta con esa letra dentro de Alfabeto (mirar los contructores de File, (padre, hijo))
			File subcarpeta = new File(alfabeto, "" + letra); //Podríamos usar String.valueOf(letra)
			
			if(subcarpeta.mkdir()) {
				System.out.println("Carpeta " + letra + " creada");
			} else {
				System.out.println("No se pudo crear la carpeta " + letra + " (¿ya existe?)");
			}
		}
		System.out.println(origen1.getAbsolutePath());
	}
}
