package pruebas;

import java.io.File;
import java.util.Date;



public class Prueba2 {
	public static void main(String[] args) {
		File documento = new File("C:/Temp/Document.txt");
		System.out.println(documento.getAbsolutePath());

		long milisegundos = documento.lastModified();
		Date fecha = new Date(milisegundos);

		System.out.println("Última modificación (ms) : " + milisegundos);
		System.out.println("Última modificación (fecha): " + fecha);
		System.out.println("Tamaño del archivo: " + documento.length());
	}

}
