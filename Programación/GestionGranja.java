package granja;
import java.util.ArrayList;
import java.util.Scanner;
public class GestionGranja {
	//Variables globales
	static ArrayList<Establo> listaEstablos = new ArrayList<Establo>();
	static Scanner sc = new Scanner(System.in);
	public static void mostrarMenu() {
		System.out.println("Menú de Gestión de la Granja\n"
				+ "1. Crear un nuevo establo\n"
				+ "2. Agregar una vaca\n"
				+ "3. Marcar todas las vacas de un establo como enfermas\n"
				+ "4. Curar todas las vacas de un establo\n"
				+ "5. Buscar vaca\n"
				+ "6. Mostrar número de vacas y edad media de un establo\n"
				+ "7. Salir\n"
				+ "Seleccione una opción:");
	}
	public static void crearEstablo() {
		System.out.println("Nombre del establo");
		String nombre = sc.nextLine();
		listaEstablos.add(new Establo(nombre));
		System.out.println("Estado agregado con éxito");
	}
	public static void crearVaca() {
		System.out.println("Nombre de la Vaca");
		String nombreVaca = sc.nextLine();
		System.out.println("Meses de vida de la vaca");
		int meses = sc.nextInt();
		sc.nextLine();
		System.out.println("Nombre del Establo");
		String nombreEstablo = sc.nextLine();
		boolean encontrado = false;
		for (Establo establo : listaEstablos) {
			if(establo.getNombre().equalsIgnoreCase(nombreEstablo)) {
				establo.agregarVaca(new Vaca(nombreVaca, meses));
				System.out.println("Vaca añadida con éxito");
				encontrado = true;
			}
		}
		if(!encontrado) {
			System.out.println("El establo no existe");
		}
	}
	public static void marcarVacasEnfermas() {
		System.out.println("Nombre del Establo");
		String nombreEstablo = sc.nextLine();
		boolean encontrado = false;
		for (Establo establo : listaEstablos) {
			if(establo.getNombre().equalsIgnoreCase(nombreEstablo)) {
				establo.marcarEnfermasEstablo();
				encontrado = true;
				System.out.println("Las vacas del establo " + establo.getNombre() + " están enfermas");
			}
		}
		if(!encontrado) {
			System.out.println("El establo no existe");
		}
	}
	public static void curarVacasEnfermas() {
		System.out.println("Nombre del Establo");
		String nombreEstablo = sc.nextLine();
		boolean encontrado = false;
		for (Establo establo : listaEstablos) {
			if(establo.getNombre().equalsIgnoreCase(nombreEstablo)) {
				establo.curarEnfermasEstablo();
				encontrado = true;
				System.out.println("Las vacas del establo " + establo.getNombre() + " están curadas");
			}
		}
		if(!encontrado) {
			System.out.println("El establo no existe");
		}
	}
	public static void buscarVaca() {
		String nombre;
		System.out.println("Nombre de la vaca a buscar: ");
		nombre = sc.nextLine();
		for (Establo establo : listaEstablos) {
			Vaca v = establo.buscarVaca(nombre);
			if (v == null) {
				System.out.println("No se encontró una vaca con ese nombre");
			}else {
				System.out.println("Encontrada en: " + establo.getNombre() +" " + v.toString());
			}break;
		}
	}
	public static void cuentaVacasYMediaEdad() {
		String nombre;
		System.out.println("Introduzca el nombre del establo:");
		nombre = sc.nextLine();
		boolean encontrado = false;
		for (Establo establo : listaEstablos) {
			if(establo.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println(establo.getNumVaca() + " vacas, edad promerdio: "+ establo.calcularPromedioEdad() + " meses");
				encontrado =true;
			}
		}
		if(!encontrado) {
			System.out.println("El establo no existe");
		}
	}
	public static void main(String[] args) {
		boolean ejecucion = true;
		while(ejecucion) {
			mostrarMenu();
			int selector;
			selector = sc.nextInt();
			sc.nextLine(); //Limpia el buffer niño
			switch(selector) {
			case 1:crearEstablo();break;
			case 2:crearVaca(); break;
			case 3:marcarVacasEnfermas();break;
			case 4:curarVacasEnfermas();break;
			case 5:buscarVaca();break;
			case 6:cuentaVacasYMediaEdad();break;
			case 7:ejecucion=false;
			System.out.println("Saliendo del programa");
			break;
			default: System.out.println("Opción no válida");
			}
		}
	}
}
class Vaca {
	//Atributos 
	private String nombre;
	private  int meses;
	private boolean enferma;
	//Metodo Constructor
	public Vaca(String nombre, int meses) {
		super();
		this.nombre = nombre;
		this.meses = meses;
		this.enferma = false;
	}
	//Metodos
	public boolean isEnferma() {
		return enferma;
	}
	public void marcarEnferma() {
		this.enferma = true;
	}
	public void curarEnferma() {
		this.enferma = false;
	}
	public String getNombre() {
		return nombre;
	}
	public int getMeses() {
		return meses;
	}
	@Override
	public String toString() {
		if(enferma) {
			return "Vaca "  + nombre + " + con "
					+ meses + " meses " + " y esta enferma";
		}else {
			return "Vaca "  + nombre + " con "
					+ meses + " meses " + " y no esta enferma";
		}
	}
}
class Establo {
	//Atributos
	private String nombre;
	private ArrayList<Vaca> listaVacas;
	//Constructor
	public Establo(String nombre) {
		super();
		this.nombre = nombre;
		listaVacas = new ArrayList<Vaca>();
	}
	//Métodos
	public void agregarVaca(Vaca v) {
		listaVacas.add(v);
	}
	public void marcarEnfermasEstablo() {
		for (Vaca vaca : listaVacas) {
			vaca.marcarEnferma();
		}
	}
	public void curarEnfermasEstablo() {
		for (Vaca vaca : listaVacas) {
			vaca.curarEnferma();
		}
	}
	public Vaca buscarVaca(String nombre) {
		for (Vaca vaca : listaVacas) {
			if (vaca.getNombre().equalsIgnoreCase(nombre)) {
				return vaca;
			}
		}
		return null; //Solamente devuelve null si no encuentra en listaVacas
	}
	public int getNumVaca() {
		return listaVacas.size();
	}
	public double calcularPromedioEdad() {
		if (listaVacas.isEmpty()) {
			return 0; // Esto evita dividir por 0 y que pete
		}
		double promedio = 0;
		for (Vaca vaca : listaVacas) {
			promedio=+vaca.getMeses();
		}
		return promedio/listaVacas.size();
	}
	public String getNombre() {
		return nombre;
	}
}

