
import java.util.Scanner;

public class JuegoCalculadora {

    public static void main(String[] args) {

        int numberPlayers = 0;
        String player1;
        String player2;
        String player3 = "player3";
        int valorObjetivo = 0;
        int lastNumber = 0;
        int currentNumber = 0;
        int accumulatedNumber = 0;
        boolean validNumber = false;

        System.out.println("Bienvenidos al Juego de la Calculadora");
        //Preguntamos cuantos jugadores van a jugar
        while (numberPlayers != 2 && numberPlayers != 3) {
            System.out.println("Cuantos jugadores van a jugar?. Elige 2 o 3");
            Scanner sa = new Scanner(System.in);
            numberPlayers = sa.nextInt();
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

        valorObjetivo = JuegoCalculadora.getValorObjetivo(player1, valorObjetivo);
        JuegoCalculadora.playTurn(numberPlayers, player1, player2, player3, valorObjetivo, lastNumber, currentNumber, validNumber, accumulatedNumber);
    }

    //Funciones

    //Función para obtener y comprobar si es valido el valor Objetivo
    public static int getValorObjetivo(String player1, int valorObjetivo) {
        boolean validObjective = false;
        while (validObjective == false) {

            System.out.println(player1 + " escoge un valor objetivo entre 10 y 99.\n" + "Si prefieres que se genere aleatoriamente introduce -1");
            Scanner sa = new Scanner(System.in);
            int objetivo = sa.nextInt();

            if (objetivo == -1) {
                double valorObjetivoDouble = (11 + 88 * Math.random());
                valorObjetivo = (int) Math.floor(valorObjetivoDouble);
                validObjective = true;
                System.out.println("El valor objetivo es " + valorObjetivo);
            } else if (objetivo > 10 && objetivo < 99) {
                valorObjetivo = objetivo;
                validObjective = true;
                System.out.println("El valor objetivo es " + valorObjetivo);
            }
        }
        return valorObjetivo;
    }

    //Función para comprobar si el número escogido es válido
    public static boolean checkIfValid(int lastNumber, int currentNumber) {

        boolean validNumber;

        if (lastNumber == 1 && (currentNumber == 2 || currentNumber == 3 || currentNumber == 4 || currentNumber == 7)) {
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

    //Función de desarrollo de Turno
    public static void playTurn(int numberPlayers, String player1, String player2, String player3, int valorObjetivo, int lastNumber, int currentNumber, boolean validNumber, int accumulatedNumber) {

        String nextPlayer = player1;
        int turnNumber = 1;
        String winnerPlayer;
        while (true) {
            if (turnNumber == 1) {
                System.out.println("Turno " + turnNumber);
                System.out.println(player1 + " escoge un numero entre 1 y 9");
                Scanner sc = new Scanner(System.in);
                lastNumber = sc.nextInt();
                accumulatedNumber = lastNumber;
                turnNumber++;
                nextPlayer = player2;
                System.out.println("Turno " + turnNumber);
            }
            if (nextPlayer.equals(player2) && numberPlayers == 2) {
                while (!validNumber) {
                    System.out.println("El valor objetivo es " + valorObjetivo);
                    System.out.println("El valor acumulado actual es " + accumulatedNumber);
                    System.out.println("El ultimo numero escogido es " + lastNumber);
                    System.out.println(player2 + " escoge un numero entre 1 y 9");
                    Scanner sc = new Scanner(System.in);
                    currentNumber = sc.nextInt();
                    validNumber = JuegoCalculadora.checkIfValid(lastNumber, currentNumber);
                }
                lastNumber = currentNumber;
                accumulatedNumber = accumulatedNumber + lastNumber;
                turnNumber++;
                nextPlayer = player1;
                validNumber = false;
                if (accumulatedNumber >= valorObjetivo) {
                    winnerPlayer = player1;
                    break;
                }
                System.out.println("Turno " + turnNumber);
            }
            if (nextPlayer.equals(player2) && numberPlayers == 3) {
                while (!validNumber) {
                    System.out.println("El valor objetivo es " + valorObjetivo);
                    System.out.println("El valor acumulado actual es " + accumulatedNumber);
                    System.out.println("El ultimo numero escogido es " + lastNumber);
                    System.out.println(player2 + " escoge un numero entre 1 y 9");
                    Scanner sc = new Scanner(System.in);
                    currentNumber = sc.nextInt();
                    validNumber = JuegoCalculadora.checkIfValid(lastNumber, currentNumber);
                }
                lastNumber = currentNumber;
                accumulatedNumber = accumulatedNumber + lastNumber;
                turnNumber++;
                nextPlayer = player3;
                validNumber = false;
                if (accumulatedNumber >= valorObjetivo) {
                    winnerPlayer = player1;
                    break;
                }
                System.out.println("Turno " + turnNumber);
            }
            if (nextPlayer.equals(player3)) {
                while (!validNumber) {
                    System.out.println("El valor objetivo es " + valorObjetivo);
                    System.out.println("El valor acumulado actual es " + accumulatedNumber);
                    System.out.println("El ultimo numero escogido es " + lastNumber);
                    System.out.println(player3 + " escoge un numero entre 1 y 9");
                    Scanner sc = new Scanner(System.in);
                    currentNumber = sc.nextInt();
                    validNumber = JuegoCalculadora.checkIfValid(lastNumber, currentNumber);
                }
                lastNumber = currentNumber;
                accumulatedNumber = accumulatedNumber + lastNumber;
                turnNumber++;
                nextPlayer = player1;

                validNumber = false;
                if (accumulatedNumber >= valorObjetivo) {
                    winnerPlayer = player2;
                    break;
                }
                System.out.println("Turno " + turnNumber);
            }
            if (nextPlayer.equals(player1) && numberPlayers == 3) {
                while (!validNumber) {
                    System.out.println("El valor objetivo es " + valorObjetivo);
                    System.out.println("El valor acumulado actual es " + accumulatedNumber);
                    System.out.println("El ultimo numero escogido es " + lastNumber);
                    System.out.println(player1 + " escoge un numero entre 1 y 9");
                    Scanner sc = new Scanner(System.in);
                    currentNumber = sc.nextInt();
                    validNumber = JuegoCalculadora.checkIfValid(lastNumber, currentNumber);
                }
                lastNumber = currentNumber;
                accumulatedNumber = accumulatedNumber + lastNumber;
                turnNumber++;
                nextPlayer = player2;
                validNumber = false;
                if (accumulatedNumber >= valorObjetivo) {
                    winnerPlayer = player3;
                    break;
                }
                System.out.println("Turno " + turnNumber);
            }
            if (nextPlayer.equals(player1) && numberPlayers == 2) {
                while (!validNumber) {
                    System.out.println("El valor objetivo es " + valorObjetivo);
                    System.out.println("El valor acumulado actual es " + accumulatedNumber);
                    System.out.println("El ultimo numero escogido es " + lastNumber);
                    System.out.println(player1 + " escoge un numero entre 1 y 9");
                    Scanner sc = new Scanner(System.in);
                    currentNumber = sc.nextInt();
                    validNumber = JuegoCalculadora.checkIfValid(lastNumber, currentNumber);
                }
                lastNumber = currentNumber;
                accumulatedNumber = accumulatedNumber + lastNumber;
                turnNumber++;
                nextPlayer = player2;
                validNumber = false;
                if (accumulatedNumber >= valorObjetivo) {
                    winnerPlayer = player2;
                    break;
                }
                System.out.println("Turno " + turnNumber);
            }
        }

        System.out.println("El ganador es " + winnerPlayer);
        System.out.println("Queréis volver a jugar?\n" + "1. Si\n" + "2. No");
        Scanner sc = new Scanner(System.in);
        int resetOption = sc.nextInt();
        if (resetOption == 1) {
            valorObjetivo = JuegoCalculadora.getValorObjetivo(player1, valorObjetivo);
            JuegoCalculadora.playTurn(numberPlayers, player1, player2, player3, valorObjetivo, lastNumber, currentNumber, validNumber, accumulatedNumber);
        } else {
            System.out.println("Gracias por jugar!");
        }
    }
}


