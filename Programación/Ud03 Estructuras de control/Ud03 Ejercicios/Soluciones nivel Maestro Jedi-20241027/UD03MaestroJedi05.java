
import java.util.Scanner;

public class UD03MaestroJedi05 {

    public static void main(String[] args) {

        // variables
        int x, total = 0;
        
        // Creamos Scanner
        Scanner in = new Scanner(System.in);
        
        // Pedimos x
        System.out.print("Dime x: ");
        x = in.nextInt();
        
        // Para cada tabla de 1 a i
        for (int i = 1; i <= x; i++) {
            
            // Mostramos la tabla del i y acumulamos en total
            System.out.println("Tabla del " + i + ":");
            for (int j = 1; j <= 10; j++) {
                int mult = i * j;
                total += mult;
                System.out.println(i + " x " + j + " = " + mult);
            }
        }
        
        // Mostramos el total
        System.out.println("Total: " + total);
    }
}
