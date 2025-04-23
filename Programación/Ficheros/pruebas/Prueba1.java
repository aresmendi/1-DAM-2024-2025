package pruebas;

import java.io.File;

public class Prueba1 {
	public static void main(String[] args) {
		File temp = new File("C:/Temp");
		File fotos = new File("C:/Temp/Fotos");
		File document = new File("C:/Temp/Document.txt");
		System.out.println(temp.getAbsolutePath()+" ¿existe? "+temp.exists());
		mostrarEstado(fotos);
		mostrarEstado(document);
	}
	public static void mostrarEstado(File f) {
		System.out.println(f.getAbsolutePath()+" ¿archivo? "+f.isFile());
		System.out.println(f.getAbsolutePath()+" ¿carpeta? "+f.isDirectory());
	}
}
