import java.util.Scanner;

public class UD03Jedi03 {

    public static void main(String[] args) {
        
        // Variables
        int n, anterior2 = 1, anterior1 = 1, actual;
        
        // Creamos Scanner
        Scanner in = new Scanner(System.in);
        
        // Pedimos N
        System.out.print("Dime N: ");
        n = in.nextInt();
        
        // Mostramos los dos primeros números (si procede)
        if (n >= 1)
            System.out.print("1");
        if (n >= 2)
            System.out.print(",1");
        
        // Bucle desde 3 hasta N. Mostramos secuencia de Fibonacci
        for (int i = 3; i <= n; i++) {
            // Número actual de Fibonacci (suma de los 2 anteriores)
            actual = anterior1 + anterior2;
            System.out.print("," + actual);
            // El anterior1 pasa a ser el anterior2
            anterior2 = anterior1;
            // El actual pasa a ser el anterior1
            anterior1 = actual;   
        }
        
        // Mostramos línea en blanco
        System.out.println("");
    }
}
