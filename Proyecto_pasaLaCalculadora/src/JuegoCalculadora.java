import java.util.Scanner;

public class JuegoCalculadora {

    public static void main(String[] args) {

        int lastnumber = 0;
        int number = 0;
        System.out.println("elige un numero");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();

        lastnumber = number;

        System.out.println("elige otro numero");
        number = sc.nextInt();

        lastnumber = JuegoCalculadora.checkIfValid(lastnumber, number);
        System.out.println(lastnumber);

    }

    //Funciones
    //Funcion para comprobar si el valor es válido

    public static int checkIfValid(int lastNumber, int number) {

        if (lastNumber == 1 && (number == 2 || number == 3 || number == 4 || number == 7)) {
            lastNumber = number;
        } else if (lastNumber == 2 && (number == 1 || number == 3 || number == 5 || number == 8)) {
            lastNumber = number;
        } else if (lastNumber == 3 && (number == 1 || number == 2 || number == 6 || number == 9)) {
            lastNumber = number;
        } else if (lastNumber == 4 && (number == 1 || number == 5 || number == 6 || number == 7)) {
            lastNumber = number;
        } else if (lastNumber == 5 && (number == 2 || number == 4 || number == 6 || number == 8)) {
            lastNumber = number;
        } else if (lastNumber == 6 && (number == 3 || number == 4 || number == 5 || number == 9)) {
            lastNumber = number;
        } else if (lastNumber == 7 && (number == 1 || number == 4 || number == 8 || number == 9)) {
            lastNumber = number;
        } else if (lastNumber == 8 && (number == 2 || number == 5 || number == 7 || number == 9)) {
            lastNumber = number;
        } else if (lastNumber == 9 && (number == 3 || number == 6 || number == 7 || number == 8)) {
            lastNumber = number;
        } else {
            System.out.println("no es valido");
        }
        return lastNumber;
    }
}
