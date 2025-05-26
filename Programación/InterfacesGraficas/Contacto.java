package interfacesGráficas;

import java.io.Serializable;

public class Contacto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String telefono;

	public Contacto(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return  nombre + ", " + telefono;
	}
}
