
import java.util.Scanner;

public class UD03MaestroJedi09 {

    public static void main(String[] args) {

        // variables
        int x;
        
        // Creamos Scanner
        Scanner in = new Scanner(System.in);
        
        // Pedimos x
        System.out.print("Dime x: ");
        x = in.nextInt();
        
        // Para cada fila f de 1 a x
        for (int f = 1; f <= x; f++) {
            
            // Calculamos cuantos espacios y asteriscos tendrá la fila
            int espacios = x - f;
            int asteriscos = f;
            
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
            
        }
        
    }
}
