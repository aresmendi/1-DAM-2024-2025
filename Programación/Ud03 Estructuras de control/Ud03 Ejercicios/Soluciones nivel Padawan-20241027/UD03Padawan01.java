
import java.util.Scanner;

public class UD03Padawan01 {

    public static void main(String[] args) {

        // Variables
        int numero;
        int dado;

        // Creamos el Scanner
        Scanner in = new Scanner(System.in);

        // Pedimos número
        System.out.print("¿Qué número saldrá en el dado?: ");
        numero = in.nextInt();
        
        // Tiramos un dado
        dado = (int)(1 + Math.random() * 6);
        System.out.println("Tiro el dado y sale un... " + dado);
        
        // Mostramos si acerta o no
        if (numero == dado)
            System.out.println("¡Acertaste!");
        else
            System.out.println("Fallaste :(");
        
    }
}
