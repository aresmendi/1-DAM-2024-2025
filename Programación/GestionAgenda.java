import java.util.ArrayList;
import java.util.Scanner;

class Nota {
	//Atributos
	private String texto;
	//Constructor
	public Nota(String texto) {
		super();
		this.texto = texto;
	}
	//Metodos
	public String getTexto() {
		return texto;
	}

}
class Pagina{
	//Atributos
	private ArrayList<Nota> listaNotas = new ArrayList<Nota>();
	private int numPag;
	//Constructor 

	public Pagina(int numPag) {
		super();
		this.numPag = numPag;
	}
	//Metodos
	public ArrayList<Nota> getListaNotas() {
		return listaNotas;
	}
	public int getNumPag() {
		return numPag;
	}

}
class Agenda{
	//Atributos
	private Pagina[] listaPaginas = new Pagina [300];
	//Constructor
	public Agenda(Pagina[] listaPaginas) {
		super();
		this.listaPaginas = listaPaginas;
	}
}
public class GestionAgenda {

	//Variables Globales 
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Nota> listaNotas = new ArrayList<Nota>();
	static Pagina[] listaPaginas = new Pagina [300];
	//Métodos del programa
	public static void menu() {
		System.out.println("1. Agregar Nota\r\n"
				+ "2. Buscar Nota\r\n"
				+ "3. Mostrar Notas de una Página\r\n"
				+ "4. Salir\r\n"
				+ "");
	}
	public static void agregarNota() {
		boolean encontrada = false;
		while(!encontrada) {
			System.out.println("Ingrese el numero de página (1-300): ");
			int numPag = sc.nextInt();
			if(numPag<1 || numPag>300) {
				System.out.println("La página no es válida");
				break;
			}
			encontrada = true;
			if(listaPaginas[numPag]== null) {
				listaPaginas[numPag] = new Pagina(numPag);
				sc.nextLine();
				System.out.println("Ingrese el texto de la nota: ");
				String texto = sc.nextLine();
				listaPaginas[numPag].getListaNotas().add(new Nota(texto));
				System.out.println("Nota agregada en la pagina " + numPag);
			}else{
				sc.nextLine();
				System.out.println("Ingrese el texto de la nota: ");
				String texto = sc.nextLine();
				listaPaginas[numPag].getListaNotas().add(new Nota(texto));
				System.out.println("Nota agregada en la pagina " + numPag);
			} 
		}
	}
	public static void buscarNota() {
		System.out.println("Ingrese el texto a buscar: ");
		String textoBuscado = sc.nextLine();
		boolean encontrado = false;
		for (Pagina pag : listaPaginas) {
			if(pag != null) {
				for (Nota nota : pag.getListaNotas()) {
					if(nota.getTexto().contains(textoBuscado)) {
						System.out.println("La nota con " + textoBuscado + " se encuentra en la página " + pag.getNumPag());
						encontrado=true;
					}
				}
			}
		}
		if (!encontrado) {
			System.out.println("No se encontró nunguna nota con ese texto");
		}
	}
	public static void mostrarNotasPagina() {
		System.out.println("Ingrese el número de página a visualizar: ");
		int numPag = sc.nextInt();
		int contador = 1; //Para numerar las notas
		sc.nextLine();
		if(listaPaginas[numPag] == null) {
			System.out.println("Página " + numPag + " contiene las siguientes notas: ");
			System.out.println("(Sin notas)");
		}else {
			System.out.println("Página " + numPag + " contiene las siguientes notas: ");
			for (Nota nota : listaPaginas[numPag].getListaNotas()) {
				System.out.println(contador +"." + nota.getTexto());
				contador++;
			}
		}
	}
	public static void main(String[] args) {
		// Ejecucion de la Agenda
		boolean ejecucion = true;
		while(ejecucion) {
			menu();
			int selector = sc.nextInt();
			sc.nextLine();
			switch(selector) {
			case 1:agregarNota(); break;
			case 2:buscarNota(); break;
			case 3:mostrarNotasPagina();break;
			case 4:ejecucion=false;break;
			default:System.out.println("Introduzca un número válido");break;
			}

		}

	}
}
