
public class UD03MaestroJedi07 {

    public static void main(String[] args) {

        // Para cada hora h de 0 a 23
        for (int h = 0; h <= 23; h++) {

            // Para cada minuto m de 0 a 59
            for (int m = 0; m <= 59; m++) {
                
                // Para cada segundo s de 0 a 59
                for (int s = 0; s <= 59; s++) {
                    
                    // Mostramos h:m:s
                    System.out.println(h + ":" + m + ":" + s);
                }
            }
        }
    }
}
