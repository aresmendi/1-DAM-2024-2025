
import java.util.Scanner;

public class UD03Jedi06 {

    public static void main(String[] args) {

        // Variables
        int n, suma = 0;

        // Creamos Scanner
        Scanner in = new Scanner(System.in);

        // Pedimos X
        System.out.print("Dime un número: ");
        n = in.nextInt();

        // Bucle que calcula la suma de las cifras de n
        while (n > 0) {
            // Sumamos la cifra más a la derecha
            suma += (n % 10);
            // Quitamos la cifra más a la derecha
            n = n / 10;
        }

        // Mostramos suma de cifras
        System.out.println("Suma de cifras: " + suma);
    }
}
