package ejerciciosAGestionFicheros;

import java.io.File;

public class Ejercicio5 {
	public static boolean borrarTodo(File f) {
		if(!f.exists()) {
			System.out.println("El archivo " + f.toString() + " no existe");
			return false;
		}
		if(f.isFile()) {
			return f.delete();
		}
		//Si es un directorio, borra su contenido recursivamente
		File[] contenido = f.listFiles();
		if (contenido != null) {
			for (File file : contenido) {
				boolean borrado = borrarTodo(file);
				if(!borrado) {
					System.out.println("No se pudo borrar: " + file);
					return false;
				}
			}
		}
		return f.delete();
	}
	public static void main(String[] args) {
		File ruta = new File("ejerciciosAGestionFicheros\\DOCS");
		if(borrarTodo(ruta)) {
			System.out.println("Eliminado con éxito");
		} else {
			System.out.println("No se pudo eliminar correctamente");
		}

	}

}
