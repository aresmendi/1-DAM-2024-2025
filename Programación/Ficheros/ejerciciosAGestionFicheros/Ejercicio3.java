package ejerciciosAGestionFicheros;

import java.io.File;

public class Ejercicio3 {

	public static void main(String[] args) {
		File origenDir = new File("C:\\Users\\aresc\\eclipse-workspace\\Ficheros\\ejerciciosAGestionFicheros\\Documentos");
		File destinoDir = new File("C:\\Users\\aresc\\eclipse-workspace\\Ficheros\\ejerciciosAGestionFicheros\\DOCS");
		boolean res = origenDir.renameTo(destinoDir);
		System.out.println("Se ha renombrado la carpeta? " + res);
		File origenDir1 = new File("C:\\Users\\aresc\\eclipse-workspace\\Ficheros\\ejerciciosAGestionFicheros\\DOCS\\Fotografias");
		File destinoDir1 = new File("C:\\Users\\aresc\\eclipse-workspace\\Ficheros\\ejerciciosAGestionFicheros\\DOCS\\FOTOS");
		boolean res1 = origenDir1.renameTo(destinoDir1);
		System.out.println("Se ha renombrado la carpeta? " + res1);
		File origenDir2 = new File("C:\\Users\\aresc\\eclipse-workspace\\Ficheros\\ejerciciosAGestionFicheros\\DOCS\\Libros");
		File destinoDir2 = new File("C:\\Users\\aresc\\eclipse-workspace\\Ficheros\\ejerciciosAGestionFicheros\\DOCS\\LECTURAS");
		boolean res2 = origenDir2.renameTo(destinoDir2);
		System.out.println("Se ha renombrado la carpeta? " + res2);
		
		File [] lista = destinoDir1.listFiles();
		for (File file : lista) {
			if(file.isFile()) {
				String nombre = file.getName();
				int punto = nombre.lastIndexOf('.');
				
				//Solo renombramos si tiene extensión
				if (punto > 0) {
					String nuevoNombre = nombre.substring(0,punto);//Nos cargamos la extensión
					File nuevoArchivo = new File(file.getParent(),nuevoNombre);
					
					boolean renombrado = file.renameTo(nuevoArchivo);
					if (renombrado) {
						System.out.println("Renombrado: " + file.getName() + " ->" + nuevoNombre);
					} else {
						System.out.println("Error al renombrar: " + file.getName());
					}
				}
			}
		}
	}

}
