package ejerciciosC;

public class Ejercicio2 {

	public static void enviarMensaje(String correo) {
		try {
			boolean correcto = correo.matches(".+@.+\\..+");
			if(!correcto) {
				throw new Exception("Ese correo no es válido");
			}
			else System.out.println(correo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String texto1 = "usuario@dominio.com";
        String texto2 = "@dominio.com";
        String texto3 = "usuario@";
        String texto4 = "usuario@dominio";
        
        enviarMensaje(texto1);
        enviarMensaje(texto2);
        enviarMensaje(texto3);
        enviarMensaje(texto4);
	}

}
