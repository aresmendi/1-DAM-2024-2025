package biblioteca;

public class Alumno {
	//Atributos
	private String dni;
	private String nombre;
	private int edad;

	//Constructor
	public Alumno(String dni, String nombre, int edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	//Métodos
	//ToString
	@Override
	public String toString() {
		return "-Alumno de NIF: " + dni + " y nombre: " + nombre + " tiene " + edad + " años";
	}
	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}
}
