package ejerciciosC;
class Gato {
	//Atributos
	private String nombre;
	private int edad;
	public Gato(String nombre, int edad) throws Exception {
		super();
		if (nombre.length() < 3) {
			throw new Exception("El nombre debe tener al menos 3 letras");
		}
		this.nombre = nombre;
		if(edad < 0) {
			throw new Exception("La edad no puede ser negativa");
		}
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setNombre(String nombre) throws Exception {
		if (nombre.length() < 3) {
			throw new Exception("El nombre debe tener al menos 3 letras");
		}
		this.nombre = nombre;
	}
	public void setEdad(int edad) throws Exception {
		if(edad < 0) {
			throw new Exception("La edad no puede ser negativa");
		}
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "El gato es " + nombre + " y tiene " + edad + " años de edad";
	}
	
}
public class Ejercicio3 {

	public static void main(String[] args) {
		try {
            Gato gato1 = new Gato("Michi", 4); // ✅ Válido
            System.out.println(gato1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Gato gato2 = new Gato("Mo", 2); // ❌ Nombre demasiado corto
            System.out.println(gato2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Gato gato3 = new Gato("Garfield", -1); // ❌ Edad negativa
            System.out.println(gato3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Gato gato4 = new Gato("Tom", 5); // ✅ Válido
            System.out.println(gato4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Gato gato5 = new Gato("Al", 3); // ❌ Nombre demasiado corto
            System.out.println(gato5);
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
