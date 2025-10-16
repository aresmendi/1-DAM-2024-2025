
public class UD03MaestroJedi08 {

    public static void main(String[] args) {

        // variables
        int diasDelMes;
        
        // Para cada mes m de 1 a 12
        for (int mes = 1; mes <= 12; mes++) {

            // Días a mostrar según el mes
            switch (mes) {
                
                // Meses de 28 días
                case 2:
                    diasDelMes = 28;
                    break;
                
                // Meses de 30 días
                case 4: case 6: case 9: case 11:
                    diasDelMes = 30;
                    break;
                    
                // Meses de 31 días
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    diasDelMes = 31;
                    break;
                
                // Error (no debería ejecutarse nunca)
                default:
                    System.out.println("ERROR: mes " + mes);
                    diasDelMes = 0;
            }
            
            // Mostramos las fechas del mes
            for (int dia = 1; dia <= diasDelMes; dia++) {
                System.out.println(dia + "/" + mes);
            }
            
        }
    }
}
