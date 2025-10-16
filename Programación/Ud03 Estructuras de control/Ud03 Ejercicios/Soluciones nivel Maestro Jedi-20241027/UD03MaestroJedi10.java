
import java.util.Scanner;

public class UD03MaestroJedi10 {

    public static void main(String[] args) {

        // variables
        int a, espacios, asteriscos;
        
        // Creamos Scanner
        Scanner in = new Scanner(System.in);
        
        // Pedimos x
        System.out.print("Dime a: ");
        a = in.nextInt();
        
        // Calculamos espacios y asteriscos de la primera fila
        // Estas variables son contadores, se actualizan en el for
        espacios = a - 1;
        asteriscos = 1;
        
        // Para cada fila f de 1 hasta a
        for (int f = 1; f <= a; f++) {
            
            // Imprimimos los espacios
            for (int i = 1; i <= espacios; i++) {
                System.out.print(" ");
            }
            
            // Imprimimos los asteriscos
            for (int i = 1; i <= asteriscos; i++) {
                System.out.print("*");
            }
            
            // Nueva línea
            System.out.println("");
            
            // Actualizamos contadores
            espacios--; // la siguiente fila tendrá 1 espacio menos
            asteriscos += 2; // la siguiente fila tendrá 2 asteriscos más
            
        }
        
    }
}
