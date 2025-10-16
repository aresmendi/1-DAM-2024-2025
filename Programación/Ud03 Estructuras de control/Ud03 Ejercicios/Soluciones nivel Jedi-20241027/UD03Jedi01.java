import java.util.Scanner;

public class UD03Jedi01 {

    public static void main(String[] args) {
        
        // Variables
        int a, b, mult = 1;
        
        // Creamos Scanner
        Scanner in = new Scanner(System.in);
        
        // Pedimos A y B
        System.out.print("Dime A: ");
        a = in.nextInt();
        System.out.print("Dime B: ");
        b = in.nextInt();
        
        // Calculamos A * A * A... (B veces)
        for (int i = 1; i <= b; i++) {
            mult *= a;
        }
        
        // Mostramos A^B
        System.out.println("A^B es " + a + "^" + b + " = " + mult);
    }
}
