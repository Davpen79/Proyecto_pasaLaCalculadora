import java.lang.classfile.attribute.SourceDebugExtensionAttribute;
import java.util.Scanner;

public class JuegoCalculadora {

    public static void main(String[] args) {

        int lastnumber = 0;
        int number = 0;
        boolean validNumber = false;

        System.out.println("Bienvenidos al Juego de la Calculadora\n" +
                "Como se llama el primer jugador?");
        Scanner sa = new Scanner(System.in);
        String player1 = sa.next();
        System.out.println("Como se llama el segundo jugador?");
        String player2 = sa.next();

        System.out.println(player1 + " escoge un valor objetivo entre 10 y 99.\n" +
                "Si prefieres que se genere aleatoriamente introduce -1");
        int objetivo = sa.nextInt();

        if (objetivo == -1){
            double valorObjetivoDouble = (11 + 89 * Math.random());
            int valorObjetivo = (int)Math.floor(valorObjetivoDouble);
            System.out.println("El valor objetivo es " + valorObjetivo);
        }






        System.out.println("elige el primer numero");
        Scanner sc = new Scanner(System.in);
        lastnumber = sc.nextInt();

        while (!validNumber) {
            System.out.println("elige un numero");
            Scanner sd = new Scanner(System.in);
            number = sc.nextInt();
            validNumber = JuegoCalculadora.checkIfValid(lastnumber, number);
        }
        lastnumber = number;
        System.out.println(lastnumber);
    }

    //Funciones
    //Función para comprobar si el valor es válido (Funcionando)

    public static boolean checkIfValid(int lastNumber, int number) {

        boolean validNumber;

        if (lastNumber == 1 && (number == 2 || number == 3 || number == 4 || number == 7)) {
            validNumber = true;

        } else if (lastNumber == 2 && (number == 1 || number == 3 || number == 5 || number == 8)) {
            validNumber = true;

        } else if (lastNumber == 3 && (number == 1 || number == 2 || number == 6 || number == 9)) {
            validNumber = true;

        } else if (lastNumber == 4 && (number == 1 || number == 5 || number == 6 || number == 7)) {
            validNumber = true;

        } else if (lastNumber == 5 && (number == 2 || number == 4 || number == 6 || number == 8)) {
            validNumber = true;

        } else if (lastNumber == 6 && (number == 3 || number == 4 || number == 5 || number == 9)) {
            validNumber = true;

        } else if (lastNumber == 7 && (number == 1 || number == 4 || number == 8 || number == 9)) {
            validNumber = true;

        } else if (lastNumber == 8 && (number == 2 || number == 5 || number == 7 || number == 9)) {
            validNumber = true;

        } else if (lastNumber == 9 && (number == 3 || number == 6 || number == 7 || number == 8)) {
            validNumber = true;

        } else {
            System.out.println("no es valido");
            validNumber = false;
        }
        return validNumber;
    }
}
