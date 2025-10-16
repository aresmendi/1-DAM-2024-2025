import java.util.Scanner;

public class UD03Jedi05 {

    public static void main(String[] args) {
        
        // Variables
        int x;
        boolean esPrimo = true;
        
        // Creamos Scanner
        Scanner in = new Scanner(System.in);
        
        // Pedimos X
        System.out.print("Dime X: ");
        x = in.nextInt();
        
        // Un número es primo si SOLO es divisible entre 1 y sí mismo.
        // Por lo tanto, un número NO será primo si es divisible entre algún
        // número entre 2 y X-1 (realmente basta con comprobar hasta X/2).
        for (int i = 2; i <= x/2; i++) {
            if ((x % i)==0)
                esPrimo = false;
        }
        
        // Mostramos si es primo o no
        if (esPrimo)
            System.out.println(x + " SÍ es primo");
        else
            System.out.println(x + " NO es primo");
    }
}
