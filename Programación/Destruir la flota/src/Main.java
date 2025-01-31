import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        char[][] tablero = generarTablero();

        char[][] tableroVisible = new char[10][10];
        for(int i=0; i<tableroVisible.length; i++) {
            for(int j=0; j<tableroVisible.length; j++) {
                tableroVisible[i][j] = '*';
            }
        }

        Scanner sc = new Scanner(System.in);
        boolean juego = true;
        int coord1, coord2;
        int puntos = 0;

        while(juego) {
            System.out.println("Jugador 1: ");
            imprimirTablero(tableroVisible);
            coord1 = -1;
            coord2 = -1;
            while(coord1 < 0 || coord1 > 9) {
                System.out.println("Dame coordenada 1");
                coord1 = sc.nextInt();
            }
            while(coord2 < 0 || coord2 > 9) {
                System.out.println("Dame coordenada 2");
                coord2 = sc.nextInt();
            }

            if(tableroVisible[coord1][coord2] == '*') {
                if (tablero[coord1][coord2] == '*') {
                    System.out.println("Agua");
                    tableroVisible[coord1][coord2] = '0';
                } else {
                    System.out.println("Tocado");
                    tableroVisible[coord1][coord2] = tablero[coord1][coord2];
                    puntos++;
                }
            } else {
                System.out.println("Casilla ya comprobada");
            }
            if(puntos == 17) {
                juego = false;
                System.out.println("Has ganado");
            }
        }
    }

    public static  void imprimirTablero(char[][] tablero) {
        for(int i=0; i<tablero.length; i++) {
            for(int j=0; j<tablero.length; j++) {
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static char[][] addBarco(int longitud, char[][] tablero) {
        Random r = new Random();
        int coord1 = 0;
        int coord2 = 0;
        int dir = 0;
        boolean coordValida = false;

        while(!coordValida) {
            coord1 = r.nextInt(0, 9);
            coord2 = r.nextInt(0, 9);

            if(tablero[coord1][coord2] == '*') {
                if (!comprobarSiguientes(longitud, tablero, dir, coord1, coord2)) {
                    dir = 1;
                    if (!comprobarSiguientes(longitud, tablero, dir, coord1, coord2)) {
                        dir = 2;
                        if (!comprobarSiguientes(longitud, tablero, dir, coord1, coord2)) {
                            dir = 3;
                            if (comprobarSiguientes(longitud, tablero, dir, coord1, coord2)) {
                                coordValida = true;
                            }
                        } else {
                            coordValida = true;
                        }
                    } else {
                        coordValida = true;
                    }
                } else {
                    coordValida = true;
                }
            }
        }
        char barco = '*';
        switch(longitud){
            case 2:
                barco = '2';
                break;
            case 3:
                barco = '3';
                break;
            case 4:
                barco = '4';
                break;
            case 5:
                barco = '5';
        }

        if(dir == 0){
            for(int i=0; i<longitud; i++) {
                tablero[coord1][coord2 + i] = barco;
            }
        }
        if(dir == 1){
            for(int i=0; i<longitud; i++) {
                tablero[coord1][coord2 - i] = barco;
            }
        }
        if(dir == 2){
            for(int i=0; i<longitud; i++) {
                tablero[coord1 - i][coord2] = barco;
            }
        }
        if(dir == 3){
            for(int i=0; i<longitud; i++) {
                tablero[coord1 + i][coord2] = barco;
            }
        }
        return tablero;
    }

    public static boolean comprobarSiguientes(int longitud, char[][] tablero, int dir, int coord1, int coord2){
        for(int i=0; i<longitud; i++) {
            if(dir == 0){ //Derecha
                if(coord2+i > 9) {
                    return false;
                }
                if (tablero[coord1][coord2 + i] != '*') {
                    return false;
                }
            }
            if(dir == 1){ //Izq
                if(coord2-i < 0) {
                    return false;
                }
                if(tablero[coord1][coord2 - i] != '*') {
                    return false;
                }
            }
            if(dir == 2){ //arriba
                if(coord1-i < 0) {
                    return false;
                }
                if(tablero[coord1 - i][coord2] != '*') {
                    return false;
                }
            }
            if(dir == 3){ //abajo
                if(coord1+i > 9) {
                    return false;
                }
                if(tablero[coord1 + i][coord2] != '*') {
                    return false;
                }
            }
        }
        return true;
    }


    public static char[][] generarTablero() {
        char[][] tablero = new char[10][10];
        for(int i=0; i<tablero.length; i++) {
            for(int j=0; j<tablero.length; j++) {
                tablero[i][j] = '*';
            }
        }
        tablero = addBarco(2, tablero);
        tablero = addBarco(3, tablero);
        tablero = addBarco(3, tablero);
        tablero = addBarco(4, tablero);
        tablero = addBarco(5, tablero);
        return tablero;
    }
}