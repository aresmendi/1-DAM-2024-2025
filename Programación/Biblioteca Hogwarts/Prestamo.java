package biblioteca;

public class Prestamo {
	//Atributos
	private Alumno alumno;
	public Libro getLibro() {
		return libro;
	}

	private Libro libro;

	public Prestamo(Alumno alumno, Libro libro) {
		super();
		this.alumno = alumno;
		this.libro = libro;
	}
	
	@Override
	public String toString() {
		return "-" + libro.getTitulo() + " | " + 
				libro.getAutor() + " | " + libro.getNumPag() + 
				" pags. prestado a: " + alumno.getDni() + " | " + 
				alumno.getNombre() + " | " + alumno.getEdad() + " años.";
	}

}
