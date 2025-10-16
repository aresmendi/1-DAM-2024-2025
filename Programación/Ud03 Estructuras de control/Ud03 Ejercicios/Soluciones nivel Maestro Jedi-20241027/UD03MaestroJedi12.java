
import java.util.Scanner;

public class UD03MaestroJedi12 {

    public static void main(String[] args) {

        // variables
        int x;
        
        // Creamos Scanner
        Scanner in = new Scanner(System.in);
        
        // Pedimos x
        System.out.print("Dime x: ");
        x = in.nextInt();
        
        System.out.println("Primos de 1 a " + x + ": ");
        
        // Para cada número desde 2 hasta X, comprobamos si es primo (NOTA: el 1 NO es primo)
        for (int i = 2; i <= x; i++) {
            
            // i será primo si SOLO es divisible entre 1 y sí mismo.
            // Es decir, si se puede dividir entre algún valor entre
            // 2 y (i-1) entonces NO será primo.
            boolean esPrimo = true;
            for (int j = 2; j < i; j++) {
                if ((i % j) == 0) {
                    esPrimo = false;
                    break;
                }
            }
            
            // Si i es primo, lo mostramos
            if (esPrimo)
                System.out.println(i);
        }
    }
}
