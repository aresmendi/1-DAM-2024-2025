import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class hundirFlota {

	public static void main(String[] args) {
		//Creamos los barcos
		int barcos [] = {2,3,3,4,5};
		//Creamos el tablero
		String tablero [][] = new String [10][10];
		for (int i = 0; i < tablero.length; i++) {
			Arrays.fill(tablero[i],"*");
		}
		 // Colocamos los barcos en el tablero
        Random r = new Random();
        for (int longitud : barcos) { //Esto es un for each
            boolean colocado = false;

            while (!colocado) {
                int coord1 = r.nextInt(10);
                int coord2 = r.nextInt(10);
                int dir = r.nextInt(4); // Dirección: 0=derecha, 1=izquierda, 2=arriba, 3=abajo

                // Verificar si se puede colocar el barco
                boolean puedeColocar = true;
                for (int i = 0; i < longitud; i++) {
                    int x = coord1, y = coord2;

                    if (dir == 0) y += i; // Derecha
                    if (dir == 1) y -= i; // Izquierda
                    if (dir == 2) x -= i; // Arriba
                    if (dir == 3) x += i; // Abajo

                    if (x < 0 || x >= 10 || y < 0 || y >= 10 || !tablero[x][y].equals("*")) {
                        puedeColocar = false;
                        break;
                    }
                }
                //Si se puede colocar, marcar las posiciones en el tablero
                if (puedeColocar) {
                	String barco = String.valueOf(longitud);
                	for (int i = 0; i < longitud; i++) {
						int x = coord1, y = coord2;
						
						if(dir == 0) y += i; //Derecha
						if(dir == 1) y -= i; //Izquierda
						if(dir == 2) x -= i; //Arriba
						if(dir == 3) x += i; //Abajo
						
						tablero[x][y] = barco;
					}
                	colocado = true;
                }
            }
        }
        //Creamos el tablero que verá el jugador
        String [][] tableroVisible = new String [10][10];
        for (int i = 0; i < tableroVisible.length; i++) {
			Arrays.fill(tableroVisible[i], "*");
		}
        //Lógica del juego
        Scanner sc = new Scanner(System.in);
        boolean juego = true;
        int puntos = 0;
        while (juego) {
        	//Imprimimos el tablero visible
        	for (int i = 0; i < tableroVisible.length; i++) {
				for (int j = 0; j < tableroVisible.length; j++) {
					System.out.print(tableroVisible [i][j] +" "); // Imprime cada celda
				}
				System.out.println();
			}
        	int coord1 = -1, coord2 = -1;
        	while (coord1 < 0 || coord1 >9) {
        		System.out.println("Dame coordenada 1: ");
        		coord1 = sc.nextInt();
        	}
        	while (coord2 < 0 || coord2 > 9) {
        		System.out.println("Dame coordenada 2: ");
        		coord2 = sc.nextInt();
        	}
        	//Verificamos el tiro
        	if(tableroVisible[coord1][coord2].equals("*")) {
        		if(tablero[coord1][coord2].equals("*")) {
        			System.out.println("Agua");
        			tableroVisible[coord1][coord2] = "0";
        		}
        		else {
        			System.out.println("Tocado");
        			tableroVisible[coord1][coord2] = tablero[coord1][coord2];
        			puntos++;
        		}
        	}
        	else {
        		System.out.println("Casilla ya comprobada");
        	}
        	if (puntos == 17) {
        		juego = false;
        		System.out.println("Has ganado, máquina!");
        	}
        }
        sc.close();
    }
	
}
