package ejerciciosBGestionFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
class Alumno {
	String nombreCompleto;
	double notaMedia;
	
	Alumno(String nombreCompleto, double notaMedia){
		this.nombreCompleto = nombreCompleto;
		this.notaMedia = notaMedia;
	}
}

public class Ejercicio2 {

	public static void main(String[] args) {
		File alumnos = new File("ejerciciosBGestionFicheros\\Documentos\\alumnos_notas.txt");
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		try {
			Scanner scAlumnos = new Scanner(alumnos);
			while(scAlumnos.hasNextLine()) {
				String alumno = scAlumnos.nextLine();
				String [] partes = alumno.split(" ");
				
				String nombreCompleto = partes[0] + " " + partes[1];
				ArrayList<Integer> notas = new ArrayList<>();
				
				for (int i = 2; i < partes.length; i++) {
					notas.add(Integer.parseInt(partes[i]));
				}
				int total = 0;
				int totalNotas = notas.size();
				for (Integer integer : notas) {
					total += integer;
				}
				double notaMedia = total/totalNotas;
				listaAlumnos.add(new Alumno(nombreCompleto, notaMedia));
			}
			scAlumnos.close();
			//Ordenamos de mayor a menor el ArrayList
			listaAlumnos.sort((a1, a2) -> Double.compare(a2.notaMedia, a1.notaMedia));
			
			for (Alumno alumno : listaAlumnos) {
				System.out.println(alumno.nombreCompleto + " : " + alumno.notaMedia);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
