package biblioteca;

public class Libro {
	//Atributos
	private String titulo;
	private String autor;
	private int numPag;
	private boolean disponible;

	//Metodo constructor
	public Libro(String titulo, String autor, int numPag) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.numPag = numPag;
		this.disponible = true;
	}

	

	//Métodos
	//toString
	@Override
	public String toString() {
		if(disponible)return "-" + titulo + " escrito por: " + autor + " tiene " + numPag + " pags. | DISP";
		else return "-" + titulo + " escrito por: " + autor + " tiene " + numPag + " pags. | PREST";
	}
	public String getTitulo() {
		return titulo;
	}



	public boolean isDisponible() {
		return disponible;
	}



	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}



	public String getAutor() {
		return autor;
	}



	public int getNumPag() {
		return numPag;
	}

}
