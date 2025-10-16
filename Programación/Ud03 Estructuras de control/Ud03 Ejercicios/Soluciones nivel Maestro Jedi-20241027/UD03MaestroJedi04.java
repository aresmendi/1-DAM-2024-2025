
import java.util.Scanner;

public class UD03MaestroJedi04 {

    public static void main(String[] args) {

        // variables
        int x;
        
        // Creamos Scanner
        Scanner in = new Scanner(System.in);
        
        // Pedimos x
        System.out.print("Dime x: ");
        x = in.nextInt();
        
        // Para cada tabla de 1 a i
        for (int i = 1; i <= x; i++) {
            
            // Mostramos la tabla del i
            System.out.println("Tabla del " + i + ":");
            for (int j = 1; j <= 10; j++) {
                int mult = i * j;
                System.out.println(i + " x " + j + " = " + mult);
            }
        }
    }
}
