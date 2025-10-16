
import java.util.Scanner;

public class UD03Padawan02 {

    public static void main(String[] args) {

        // Variables
        String usuario;
        String passwd;

        // Creamos el Scanner
        Scanner in = new Scanner(System.in);

        // Pedimos usuario y contraseña
        System.out.print("¿Usuario? ");
        usuario = in.nextLine();
        System.out.print("¿Contraseña? ");
        passwd = in.nextLine();

        // Comprobamos si es correcto o no
        if (!usuario.equals("alumno"))
            System.out.println("Error: Usuario incorrecto");
        else if (!passwd.equals("123456"))
            System.out.println("Error: Contraseña incorrecta");
        else
            System.out.println("¡Inicio de sesion OK!");
        
    }
}
