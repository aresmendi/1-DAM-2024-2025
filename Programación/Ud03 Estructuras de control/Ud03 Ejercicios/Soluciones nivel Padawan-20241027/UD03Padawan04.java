import java.util.Scanner;

public class UD03Padawan04
{
    public static void main(String[] args) {
        
        // Variables
        int a, b;
        
        // Creo el Scanner
        Scanner in = new Scanner(System.in);
        
        // Pedimos a y b
        System.out.print("Dime a y b: ");
        a = in.nextInt();
        b = in.nextInt();
        
        // Mostramos valores desde b hasta a
        for(int i = b; i >= a; i--){
            System.out.println(i);
        }
    }
}
