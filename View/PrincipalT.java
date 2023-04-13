package View;

import Controller.ControllerA;
import Logic.Piece;
import java.util.Scanner;

public class PrincipalT  {
    public static void main(String[] args) {
        //Instancias
        ControllerA control = new ControllerA();
        PrincipalT tablero = new PrincipalT();

        Scanner scanner = new Scanner(System.in);

        //Variables
        char cE = 'A';

        //Impresion de tablero
        do {
            tablero.printBoard(control.getBoardPieces());
            //Se piden datos
            System.out.println("Bienvenido a Ajedrez");
            System.out.println("Seleccione una pieza usando sus coordenadas");

            System.out.print("Por favor ingrese ... \nCoordenada en X : ");
            String cordX = scanner.nextLine();
            System.out.print("Por favor ingrese... \nCoordenada en Y : ");
            String cordY = scanner.nextLine();

            System.out.print("Ingrese la coordenada en X a la que desea mover la pieza: ");
            String newCordX = scanner.nextLine();
            System.out.print("Ingrese la coordenada en Y a la que desea mover la pieza: ");
            String newCordY = scanner.nextLine();

            //se llama al metodo verificar datos
            System.out.println(control.verifyData(cordX, cordY, newCordX, newCordY));
        }while (true);
    }

    public void printBoard(Piece[][] board) {

        char c = 'A';
        for (int i = 0; i < board.length; i++){
            System.out.print(i);
            for (int j = 0; j < board[i].length ; j++){
                if(board[j][i] != null) {
                    System.out.print(board[j][i].getName()+"\t");
                } else if (j==0) {
                    System.out.print("\t");
                } else if (i==0) {
                    System.out.print(c+"\t");
                    c=++c;
                } else {
                    System.out.print("-\t");
                }
            }
            System.out.println("");
        }
    }
}