package View;

import Controller.ControllerA;
import Logic.Board;
import Logic.Piece;
import java.util.Scanner;
public class PrincipalT  {
    public static void main(String[] args) {
        ControllerA control = new ControllerA();
        Board board  = new Board();
        Piece[][] boardA = new Piece[9][9];
        Scanner scanner = new Scanner(System.in);
        boardA = board.getBoard();
        char cE = 'A';

        do {

            for (int i = 0; i < 9; i++) {
                System.out.print(i);
                for (int j = 0; j < 9; j++) {
                    if (boardA[j][i] != null) {
                        System.out.print(boardA[j][i].getName() + "\t");
                    } else if (j == 0) {
                        System.out.print("\t");
                    } else if (i == 0) {
                        System.out.print(cE + "\t");
                        cE = ++cE;
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            //Se piden datos
            System.out.println("Bienvenido a Ajedrez");
            System.out.println("Seleccione una pieza usando sus coordenadas");
            System.out.print("Por favor ingrese ... \nCoordenada en X : ");
            String cordX = scanner.nextLine();
            System.out.println("Por favor ingrese... \nCoordenada en Y : ");
            String cordY = scanner.nextLine();
            System.out.println("Ingrese la coordenada en X a la que desea mover la pieza");
            String newCordX = scanner.nextLine();
            System.out.println("Ingrese la coordenada en Y a la que desea mover la pieza");
            String newCordY = scanner.nextLine();
            //se llama al metodo verificar datos
            control.verifyData(cordX, cordY, newCordX, newCordY);
        }while (1<2);

    }
}
