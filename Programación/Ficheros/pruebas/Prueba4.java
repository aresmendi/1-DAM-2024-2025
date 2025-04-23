package pruebas;

import java.io.File;

public class Prueba4 {
	public static void main(String[] args) {
		File origenDir = new File("C:/Temp/Fotos");
		File destinoDir = new File("C:/Temp/Media/Fotografies");
		File origenDoc = new File("C:/Temp/Media/Fotografies/Documento.txt");
		File destinoDoc = new File("C:/Temp/Documento.txt");

		boolean res = origenDir.renameTo(destinoDir);
		System.out.println("Se ha movido y renombrado la carpeta? " + res);
		res = origenDoc.renameTo(destinoDoc);
		System.out.println("Se ha movido el documento? " + res);
	}
}
