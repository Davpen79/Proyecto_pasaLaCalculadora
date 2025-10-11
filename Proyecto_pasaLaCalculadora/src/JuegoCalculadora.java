import java.util.InputMismatchException;
import java.util.Scanner;

public class JuegoCalculadora {

    public static void main(String[] args) {

        int numberPlayers = 0;
        String player1;
        String player2;
        String player3 = "player3";
        int valorObjetivo;
        int lastNumber = 0;
        int currentNumber = 0;
        int accumulatedNumber = 0;
        boolean validNumber = false;
        boolean checkWin = false;
        int turnNumber;
        String currentPlayer = "";
        String lastPlayer = "";
        String nextPlayer = "";
        int resetOption = 0;

        System.out.println("Bienvenidos al Juego de la Calculadora");
        //Preguntamos cuantos jugadores van a jugar
        while (numberPlayers != 2 && numberPlayers != 3) {
            System.out.println("Cuantos jugadores van a jugar?. Elige 2 o 3");
            try {
                Scanner sa = new Scanner(System.in);
                numberPlayers = sa.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Solo puedes introducir los números 2 o 3");
            }
        }

        //Preguntamos los nombres de los jugadores
        System.out.println("Como se llamará el primer jugador?");
        Scanner sa = new Scanner(System.in);
        player1 = sa.nextLine();
        System.out.println("Como se llamará el segundo jugador?");
        player2 = sa.nextLine();
        if (numberPlayers == 3) {
            System.out.println("Como se llamará el tercer jugador?");
            player3 = sa.nextLine();
        }
        //Desarrollo de una partida y opción de reset
        valorObjetivo = JuegoCalculadora.getValorObjetivo(player1);
        turnNumber = 1;
        JuegoCalculadora.playGame(accumulatedNumber, lastNumber, currentNumber, validNumber, turnNumber, valorObjetivo, numberPlayers, player1, player2, player3, nextPlayer, checkWin, currentPlayer, lastPlayer);
        while (resetOption != 2) {
            System.out.println("Queréis volver a jugar? Escoge 1 o 2\n" + "1. Si\n" + "2. No");
            Scanner sc = new Scanner(System.in);
            resetOption = sc.nextInt();
            if (resetOption == 1) {
                lastNumber = 0;
                currentNumber = 0;
                accumulatedNumber = 0;
                turnNumber = 1;
                valorObjetivo = JuegoCalculadora.getValorObjetivo(player1);
                JuegoCalculadora.playGame(accumulatedNumber, lastNumber, currentNumber, validNumber, turnNumber, valorObjetivo, numberPlayers, player1, player2, player3, nextPlayer, checkWin, currentPlayer, lastPlayer);
            } else {
                System.out.println("Gracias por jugar!");
            }
        }
    }

    //Funciones

    //Función para obtener y comprobar si es válido el valor Objetivo
    public static int getValorObjetivo(String player1) {
        boolean validObjective = false;
        int valorObjetivo = 0;
        while (validObjective == false) {

            System.out.println(player1 + " escoge un valor objetivo entre 10 y 99.\n" + "Si prefieres que se genere aleatoriamente introduce -1");
            int objetivoIntroducido = 0;
            try {
                Scanner sa = new Scanner(System.in);
                objetivoIntroducido = sa.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Solo puedes introducir valores numéricos");
            }
            int objetivo = objetivoIntroducido;

            if (objetivo == -1) {
                double valorObjetivoDouble = (11 + 88 * Math.random());
                valorObjetivo = (int) Math.floor(valorObjetivoDouble);
                validObjective = true;

            } else if (objetivo > 10 && objetivo < 99) {
                valorObjetivo = objetivo;
                validObjective = true;
            }
        }
        return valorObjetivo;
    }

    //Función para comprobar si el número escogido en cada turno es válido
    public static boolean checkIfValid(int lastNumber, int currentNumber) {

        boolean validNumber;

        if (lastNumber == 0 && (currentNumber >= 1 && currentNumber <= 9)) {
            validNumber = true;
        } else if (lastNumber == 1 && (currentNumber == 2 || currentNumber == 3 || currentNumber == 4 || currentNumber == 7)) {
            validNumber = true;
        } else if (lastNumber == 2 && (currentNumber == 1 || currentNumber == 3 || currentNumber == 5 || currentNumber == 8)) {
            validNumber = true;
        } else if (lastNumber == 3 && (currentNumber == 1 || currentNumber == 2 || currentNumber == 6 || currentNumber == 9)) {
            validNumber = true;
        } else if (lastNumber == 4 && (currentNumber == 1 || currentNumber == 5 || currentNumber == 6 || currentNumber == 7)) {
            validNumber = true;
        } else if (lastNumber == 5 && (currentNumber == 2 || currentNumber == 4 || currentNumber == 6 || currentNumber == 8)) {
            validNumber = true;
        } else if (lastNumber == 6 && (currentNumber == 3 || currentNumber == 4 || currentNumber == 5 || currentNumber == 9)) {
            validNumber = true;
        } else if (lastNumber == 7 && (currentNumber == 1 || currentNumber == 4 || currentNumber == 8 || currentNumber == 9)) {
            validNumber = true;
        } else if (lastNumber == 8 && (currentNumber == 2 || currentNumber == 5 || currentNumber == 7 || currentNumber == 9)) {
            validNumber = true;
        } else if (lastNumber == 9 && (currentNumber == 3 || currentNumber == 6 || currentNumber == 7 || currentNumber == 8)) {
            validNumber = true;
        } else {
            System.out.println("NO es valido");
            validNumber = false;
        }
        return validNumber;
    }

    //Función que comprueba si se cumple la condición de victoria
    public static boolean checkWin(int accumulatedNumber, int valorObjetivo) {

        if (accumulatedNumber >= valorObjetivo) {
            return true;
        } else {
            return false;
        }
    }
    //Función para obtener el jugador que juega el siguiente turno
    public static String getNextPlayer(int numberPlayers, String nextPlayer, String currentPlayer, String player1, String player2, String player3) {

        if (numberPlayers == 2) {
            if (currentPlayer.equals(player1)) {
                nextPlayer = player2;
            } else {
                nextPlayer = player1;
            }
        } else if (numberPlayers == 3) {
            if (currentPlayer.equals(player1)) {
                nextPlayer = player2;
            } else if (currentPlayer.equals(player2)) {
                nextPlayer = player3;
            } else {
                nextPlayer = player1;
            }
        }
        return nextPlayer;
    }
    //Función para obtener el jugador del turno anterior (usada para saber el jugador ganador)
    public static String getLastPlayer(int numberPlayers, String lastPlayer, String currentPlayer, String player1, String player2, String player3) {

        if (numberPlayers == 2) {
            if (currentPlayer.equals(player1)) {
                lastPlayer = player2;
            } else {
                lastPlayer = player1;
            }
        } else if (numberPlayers == 3) {
            if (currentPlayer.equals(player1)) {
                lastPlayer = player3;
            } else if (currentPlayer.equals(player2)) {
                lastPlayer = player1;
            } else {
                lastPlayer = player2;
            }
        }
        return lastPlayer;
    }
    //Función para proporcionar la información en cada turno y también para pedirle un valor al jugador
    public static int getCurrentNumber(boolean validNumber, int turnNumber, int valorObjetivo, int accumulatedNumber, int lastNumber, String currentPlayer, int currentNumber) {
        while (!validNumber) {
            System.out.println("========== " + "Turno " + turnNumber + " ==========");
            System.out.println("El valor objetivo es " + valorObjetivo);
            System.out.println("El valor acumulado actual es " + accumulatedNumber);
            System.out.println("El ultimo numero escogido es " + lastNumber);
            System.out.println(currentPlayer + " escoge un numero entre 1 y 9");
            try {
                Scanner sc = new Scanner(System.in);
                currentNumber = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Solo puedes introducir valores numéricos");
            }
            validNumber = JuegoCalculadora.checkIfValid(lastNumber, currentNumber);
        }
        return currentNumber;
    }
    //Función principal del juego
    public static void playGame(int accumulatedNumber, int lastNumber, int currentNumber, boolean validNumber, int turnNumber, int valorObjetivo, int numberPlayers, String player1, String player2, String player3, String nextPlayer, boolean checkWin, String currentPlayer, String lastPlayer) {
        nextPlayer = player1;
        while (!checkWin) {
            currentPlayer = nextPlayer;
            lastPlayer = JuegoCalculadora.getLastPlayer(numberPlayers, lastPlayer, currentPlayer, player1, player2, player3);
            currentNumber = JuegoCalculadora.getCurrentNumber(validNumber, turnNumber, valorObjetivo, accumulatedNumber, lastNumber, currentPlayer, currentNumber);
            lastNumber = currentNumber;
            accumulatedNumber = accumulatedNumber + lastNumber;
            checkWin = JuegoCalculadora.checkWin(accumulatedNumber, valorObjetivo);
            turnNumber++;
            nextPlayer = JuegoCalculadora.getNextPlayer(numberPlayers, nextPlayer, currentPlayer, player1, player2, player3);
        }
        System.out.println("Ha ganado " + lastPlayer);
    }
}