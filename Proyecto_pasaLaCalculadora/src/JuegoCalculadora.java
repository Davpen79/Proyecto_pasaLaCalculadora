import java.lang.classfile.attribute.SourceDebugExtensionAttribute;
import java.util.Scanner;

public class JuegoCalculadora {

    public static void main(String[] args) {

        int numberPlayers = 0;
        String player1 = "player1";
        String player2 = "player2";
        String player3 = "player3";
        int lastNumber = 0;
        int currentNumber = 0;
        boolean validNumber = false;

        System.out.println("Bienvenidos al Juego de la Calculadora");
        //Preguntamos cuantos jugadores van a jugar
        while (numberPlayers != 2 && numberPlayers != 3) {
            System.out.println("Cuantos jugadores van a jugar?. Elige 2 o 3");
            Scanner sa = new Scanner(System.in);
            numberPlayers = sa.nextInt();
        }

        //Preguntamos los nombres de los jugadores

        if (numberPlayers == 2) {
            System.out.println("Como se llamará el primer jugador?");
            Scanner sa = new Scanner(System.in);
            player1 = sa.nextLine();
            System.out.println("Como se llamará el segundo jugador?");
            player2 = sa.nextLine();
        } else {
            System.out.println("Como se llamará el primer jugador?");
            Scanner sa = new Scanner(System.in);
            player1 = sa.nextLine();
            System.out.println("Como se llamará el segundo jugador?");
            player2 = sa.nextLine();
            System.out.println("Como se llamará el tercer jugador?");
            player3 = sa.nextLine();

        }

        JuegoCalculadora.getValorObjetivo(player1);

        /*
        int numJugad = 3;
    for (int i = 1; i <= numJugad; i++) {
       System.out.println("el numero de jugadores is " + i);
    }
    System.out.println("Fin ");
        */


        System.out.println("elige el primer numero");
        Scanner sc = new Scanner(System.in);
        lastNumber = sc.nextInt();

        while (!validNumber) {
            System.out.println("elige un numero");
            currentNumber = sc.nextInt();
            validNumber = JuegoCalculadora.checkIfValid(lastNumber, currentNumber);
        }
        lastNumber = currentNumber;
        System.out.println(lastNumber);
    }

    //Funciones

    //Función para obtener y comprobar si es valido el valor Objetivo

    public static int getValorObjetivo(String player1) {
        boolean validObjective = false;
        int valorObjetivo = 0;
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
            } else {
                validObjective = false;
            }
        }
        return valorObjetivo;
    }
    //Función para comprobar si el valor es válido ( == 0 NO Funcionando)

    public static boolean checkIfValid(int lastNumber, int currentNumber) {

        boolean validNumber;

        if (lastNumber == 0) {
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
            System.out.println("no es valido");
            validNumber = false;
        }
        return validNumber;
    }
}
