
import java.util.Scanner;

public class UD03Padawan03 {

    public static void main(String[] args) {

        // Variables
        int d, m, a;
        boolean valida = false;

        // Creamos el Scanner
        Scanner in = new Scanner(System.in);

        // Pedimos fecha
        System.out.print("Dia: ");
        d = in.nextInt();
        System.out.print("Mes: ");
        m = in.nextInt();
        System.out.print("A�o: ");
        a = in.nextInt();
        
        // Comprobamos si es una fecha válida
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (d >= 1 && d <= 31)
                    valida = true;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (d >= 1 && d <= 30)
                    valida = true;
                break;
            case 2:
                if (d >= 1 && d <= 28)
                    valida = true;
                break;
        }

        // Mostramos si es válido
        if (valida)
            System.out.println("Es una fecha válida");
        else
            System.out.println("No es una fecha válida");

    }
}
