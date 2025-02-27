package biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {
	//Variables Globales
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Alumno> listaAlumnos = new ArrayList <Alumno>();
	static ArrayList<Libro> listaLibros = new ArrayList<Libro>();
	static ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
	static int contadorLibros = 1;
	static int contadorAlumnos = 1;
	//Métodos del programa
	public static void menu() {
		System.out.println("Bienvenido a la biblioteca de Hogwarts\r\n"
				+ "1-Dar de alta un libro\r\n"
				+ "2-Dar de alta un alumno\r\n"
				+ "3-Prestar un libro\r\n"
				+ "4-Devolver un libro\r\n"
				+ "5-Resumen de la biblioteca\r\n"
				+ "9-Salir");
	}
	public static void altaLibro() {
		System.out.println("Introduzca título del libro numero " + contadorLibros);
		String titulo = sc.nextLine();
		boolean encontrado = false;
		for (Libro libro : listaLibros) {
			if (libro.getTitulo().equalsIgnoreCase(titulo)) {
				System.out.println("Ese libro ya está registrado");
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Introduzca su autor:");
			String autor =sc.nextLine();
			System.out.println("Introduzca número de páginas:");
			int numPag = sc.nextInt();
			sc.nextLine();
			listaLibros.add(new Libro(titulo, autor, numPag)); 
			System.out.println("Se ha dado de alta el siguiente ejemplar:");
			System.out.println( listaLibros.get(contadorLibros-1).toString());
			contadorLibros++;
		}
	}
	public static void altaAlumno() {
		System.out.println("Introduzca DNI de alumno numero " + contadorAlumnos);
		String dni = sc.nextLine();
		boolean encontrado = false;
		for (Alumno alumno : listaAlumnos) {
			if(alumno.getDni().equalsIgnoreCase(dni)) {
				System.out.println("Ese alumno ya está registrado");
				break;
			}
		}if(!encontrado) {
			System.out.println("Introduzca su nombre:");
			String nombre =sc.nextLine();
			System.out.println("Introduzca su edad:");
			int edad = sc.nextInt();
			listaAlumnos.add(new Alumno(dni, nombre, edad));
			System.out.println("Se ha dado de alta el siguiente alumno: ");
			System.out.println(listaAlumnos.get(contadorAlumnos-1).toString()); 
			contadorAlumnos++;
		}
	}
	public static void prestaLibro() {
		boolean alumEncontrado = false;
		boolean libroEncontrado = false;
		do {
			System.out.println("Introduzca DNI del alumno: ");
			String dni = sc.nextLine();
			for (Alumno alumno : listaAlumnos) {
				if(alumno.getDni().equalsIgnoreCase(dni)) {
					alumEncontrado = true;
					System.out.println("Introduzca título del libro a prestar: ");
					String titulo = sc.nextLine();
					for (Libro libro : listaLibros) {
						if(libro.getTitulo().equalsIgnoreCase(titulo) && libro.isDisponible() == true) {
							libroEncontrado = true;
							libro.setDisponible(false);
							listaPrestamos.add(new Prestamo(alumno, libro));
							System.out.println("Libro prestado con éxito");
						}
					}
				}
			}
		}while(!alumEncontrado && !libroEncontrado);
	}
	public static void devuelveLibro() {
		boolean alumEncontrado = false;
		boolean libroEncontrado = true;
		do {
			System.out.println("Introduzca DNI del alumno: ");
			String dni = sc.nextLine();
			
			for (Alumno alumno : listaAlumnos) {
				if(alumno.getDni().equalsIgnoreCase(dni)) {
					alumEncontrado = true;
					System.out.println("Introduzca título del libro a devolver: ");
					String titulo = sc.nextLine();
					for (Libro libro : listaLibros) {
						if(libro.getTitulo().equalsIgnoreCase(titulo) && libro.isDisponible() == false) {
							libroEncontrado =true;
							libro.setDisponible(true);
							Iterator<Prestamo> iter = listaPrestamos.iterator();
							while(iter.hasNext()) {
								Prestamo prestamo = iter.next();
								if (prestamo.getLibro().getTitulo().equalsIgnoreCase(titulo)) {
									iter.remove();//Eliminamos el préstamo de manera segura
									System.out.println("Libro devuelto con éxito.");
								}
							}
						}
					}
				}
			}
		} while(!alumEncontrado && libroEncontrado); 
	}

	public static void resumenBiblio() {
		System.out.println("Clientes dados de alta:");
		for (Alumno alumno : listaAlumnos) {
			System.out.println(alumno.toString());
		}
		System.out.println("Libros dados de alta: ");
		for (Libro libro : listaLibros) {
			System.out.println(libro.toString());
		}
		System.out.println("Prestamos efectuados: ");
		for (Prestamo prestamo : listaPrestamos) {
			System.out.println(prestamo.toString());
		}

	}
	public static void main(String[] args) {
		boolean funciona = true;
		while(funciona) {
			menu();
			int selector = sc.nextInt();
			sc.nextLine();
			switch(selector) {
			case 1:altaLibro();break;
			case 2:altaAlumno();break;
			case 3:prestaLibro();break;
			case 4:devuelveLibro();break;
			case 5:resumenBiblio();break;
			case 9:funciona=false;break;
			default:System.out.println("Introduzca un número válido");
			}
		}

	}

}
