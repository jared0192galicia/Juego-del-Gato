package clases;

/**
 *
 * El juego se muestra en cmd. Cualquier persona es libre de usar y modificar el codigo dejando
 * a el autor del mismo libre de responsabilidades acerca de este programa.
 * 
 * @author jared
 */
import java.util.Scanner;

public class Methods {

    // Declaracion de variables 
    int tiros = 0;
    int position;
    int prueba;
    int notWin;
    String cmd;
    String simb;
    String select;
    String primSimb;
    boolean pos = true;
    boolean finish = false;
    boolean optionCor = false;
    Scanner cold = new Scanner(System.in);

    // Imprimir el tablero del gato
    public void impress(String gato[][]) {
        for (int i = 0; i < gato.length; i++) {
            for (int j = 0; j < gato.length; j++) {
                System.out.print(gato[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    // Metodo para la lectura de posicion
    public boolean reading(String gato[][], String name, String simbolo) {
        // Llevar la cuenta de los tiros
        position = 0;
        if (tiros == 0) {
            primSimb = simbolo;
        }

        if (simbolo.equalsIgnoreCase(primSimb)) {
            tiros++;
        }
        
        impress(gato);
        // Validar la opcion
        do {
            System.out.print(name + "(" + simbolo + ") ingresa el numero de la posicion: ");
            select = cold.nextLine().trim();
            optionCor = true;
            
            // Validacion para numeros enteros
            try {
                prueba = Integer.parseInt(select);
            } catch (NumberFormatException e) {
                optionCor = false;
                System.out.println("La posición ingresada debe ser el numero que corresponda.\n");
            }

            if (select.length() != 1) {
                System.out.println("La opcion ingresada debe ser de un solo caracter.\n");
            }

        } while ((select.length() != 1) || (!optionCor));

        // Sustituir el numero elejido por el simbolo correspondiente
        for (int i = 0; i < gato.length; i++) {
            for (int j = 0; j < gato.length; j++) {
                if (gato[i][j].equalsIgnoreCase(select)) {
                    gato[i][j] = simbolo;

                    // verificar si no se encontro la posiscion seleccionada
                } else {
                    position++;
                }
            }
        }

        // Verificar que se encontro la posiscion solicitada, en caso contrario usar recursivivdad
        if (position == 9) {
            System.out.println("La posiscion ya esta ocupada");
            reading(gato, name, simbolo);
        } else {
        }

        if (tiros >= 3) {
            finish = check(gato, simbolo);
        }

        return finish;
    }

    public boolean Position(String gato[][], String input) {
        for (int i = 0; i < gato.length; i++) {
            for (int j = 0; j < gato.length; j++) {

            }
        }

        return pos;
    }

    public String[][] defaultKat(String gato[][]) {
        
        gato[0][0] = "1";
        gato[0][1] = "2";
        gato[0][2] = "3";
        gato[1][0] = "4";
        gato[1][1] = "5";
        gato[1][2] = "6";
        gato[2][0] = "7";
        gato[2][1] = "8";
        gato[2][2] = "9";
        
        return gato;

    }

    // Metodo que revisa si el jugador gano
    public boolean check(String gato[][], String simbolo) {
        notWin = 0;

        // Comprobar las posiciones ganadoras.
        // ganar en linea horizantal
        if (gato[0][0].equals(simbolo) && (gato[0][1].equals(simbolo) && (gato[0][2].equals(simbolo)))) {
            System.out.println("Gano ");
            finish = true;
            notWin++;
            System.out.println("00, 01, 02");

        } else if (gato[1][0].equals(simbolo) && (gato[1][1].equals(simbolo) && (gato[1][2].equals(simbolo)))) {
            System.out.println("");
            finish = true;
            notWin++;
            System.out.println("10, 11, 12,");

        } else if (gato[2][0].equals(simbolo) && (gato[2][1].equals(simbolo) && (gato[2][2].equals(simbolo)))) {
            System.out.println("");
            finish = true;
            notWin++;
            System.out.println("20, 21, 22");

            // Ganar en linea vertical    
        } else if (gato[0][0].equals(simbolo) && (gato[1][0].equals(simbolo) && (gato[2][0].equals(simbolo)))) {
            System.out.println("");
            finish = true;
            notWin++;
            System.out.println("00, 10, 20");

        } else if (gato[0][1].equals(simbolo) && (gato[1][1].equals(simbolo) && (gato[2][1].equals(simbolo)))) {
            System.out.println("");
            finish = true;
            notWin++;
            System.out.println("10, 11, 21");

        } else if (gato[0][2].equals(simbolo) && (gato[1][2].equals(simbolo) && (gato[2][2].equals(simbolo)))) {
            System.out.println("");
            finish = true;
            notWin++;
            System.out.println("02, 12, 22");

            // Ganar en linea cruzada    
        } else if (gato[0][0].equals(simbolo) && (gato[1][1].equals(simbolo) && (gato[2][2].equals(simbolo)))) {
            System.out.println("");
            finish = true;
            notWin++;
            System.out.println("00, 11, 22");

        } else if (gato[0][2].equals(simbolo) && (gato[1][1].equals(simbolo) && (gato[2][0].equals(simbolo)))) {
            System.out.println("");
            finish = true;
            notWin++;
            System.out.println("02, 11, 20");

        } else if (gato[0][0].equals(simbolo) && (gato[0][1].equals(simbolo) && (gato[0][2].equals(simbolo)))) {
            System.out.println("");
            finish = true;
            notWin++;
            System.out.println("00, 01, 02");

        } else if (notWin == 8) {
            System.out.println("Empate");
            finish = true;
        } else {
            finish = false;
        }
        return finish;
    }
}
