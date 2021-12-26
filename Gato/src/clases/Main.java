package clases;

/**
 *
 * El juego se muestra en cmd. Cualquier persona es libre de usar y modificar el codigo dejando
 * a el autor del mismo libre de responsabilidades acerca de este programa.
 * 
 * @author jared galicia
 */
import java.util.Random;
import java.util.Scanner;
import clases.Methods;

public class Main {

    public static void main(String[] args) throws Exception {
        // Declaracion de variables y objetos
        Scanner cold = new Scanner(System.in);
        String gato[][] = new String[3][3];
        Methods mts = new Methods();
        String nameOne;
        String nameTwo;
        String winner = "";
        String reba = "";
        boolean ronda = true;
        boolean finish = false;
        boolean turn;
        int player;
        int playerOnePts = 0;
        int playerTwoPts = 0;
       
        mts.defaultKat(gato);
        
        // Objeto aleatorio
        Random aleatorio = new Random(System.currentTimeMillis());
        player = aleatorio.nextInt(2) + 1;
        aleatorio.setSeed(System.currentTimeMillis());

        // Asignar el turno... true = jugador 1; false = jugador 2
        if (player == 1) {
            turn = true;
        } else {
            turn = false;
        }

        // Lectura de los nombres de los jugadores
        System.out.print("Nombre del primer jugador: ");
        nameOne = cold.nextLine().trim();

        System.out.print("\nNombre del segundo jugador: ");
        nameTwo = cold.nextLine().trim();
        
        nameOne = nameOne.substring(0, 1).toUpperCase() + nameOne.substring(1, nameOne.length());
        nameTwo = nameTwo.substring(0, 1).toUpperCase() + nameTwo.substring(1, nameTwo.length());
        
        // Inicia el juego
        do {
            reba = "";
            while (!finish) {
                // Tiran segun los turnos 
                if (turn) {
                    finish = mts.reading(gato, nameOne, "O");

                } else {
                    finish = mts.reading(gato, nameTwo, "X");
                }
                turn = !turn;
            }

            mts.impress(gato);

            // Nombrar al ganador
            if (!turn) {
                winner = nameOne;
                playerOnePts++;
            } else {
                winner = nameTwo;
                playerTwoPts++;
            }

            // Mostrar resultados
            System.out.println("El ganador fue " + winner + "\n"
                    + nameOne + ": " + playerOnePts + "\n"
                    + nameTwo + ": " + playerTwoPts);

            // Preguntar si decea volver a jugar
            while (!reba.equalsIgnoreCase("Si") && (!reba.equalsIgnoreCase("no"))) {

                System.out.print("¿Decea volver a jugar? (Si/No) ");
                reba = cold.nextLine().trim();

                // Preparamos el reinicio del juego o salimos
                if (reba.equalsIgnoreCase("Si")) {
                    ronda = true;
                    gato = mts.defaultKat(gato);
                    finish = false;
                    mts.tiros = 0;
                    mts.finish = false;
                    
                } else if (reba.equalsIgnoreCase("No")) {
                    ronda = false;
                } else {
                    System.out.println("Ingrese \"si\" para vilver a jugar o \"no\" para salir.");
                }

            }

        } while (ronda);

        // Mensaje final de resultados
        if (playerOnePts > playerTwoPts) {
            System.out.println("Fin del juego\n"
                + "El ganador es: " + nameOne +
                    " y " + nameTwo + " eres puto");
            
        } else if (playerTwoPts > playerOnePts){
            System.out.println("Fin del juego\n"
                + "El ganador es: " + nameTwo +
                    " y " + nameOne + " eres puto");
        } else {
            System.out.println("Fin del juego\n"
                + "Empate\nY los dos son putos :)");
        
        }
            
        
    }

}
