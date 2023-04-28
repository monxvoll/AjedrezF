package View;

import Controller.ControllerA;
import Logic.Piece;
import Logic.Exeptions.CustomWinExeption;

import java.util.Scanner;

public class PrincipalT  {

    //Instancias
    static ControllerA control = new ControllerA();
    static PrincipalT tablero = new PrincipalT();
    public static void main(String[] args) {
             
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a Ajedrez");
        //Impresion de tablero
        try {
            do {
                tablero.options();
            }while (true);
        } catch (CustomWinExeption e) {
            System.err.println("WOW..... haz ganado"+ "\nGRACIAS POR JUGAR"+"\nLa nota de este proyecto es 50 SIUUUU"
            +"\n\n\nBy: David S and Jose S");
        }
    }

    public void printBoard(Piece[][] cloneBoard) {

        char c = 'A';
        for (int i = 0; i < cloneBoard.length; i++){
            System.out.print(i);
            for (int j = 0; j < cloneBoard[i].length ; j++){
                if(cloneBoard[j][i] != null) {
                    System.out.print(cloneBoard[j][i].getName()+"\t");
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
    public void options() throws CustomWinExeption{
        Scanner scanner = new Scanner(System.in);
        
        tablero.printBoard(control.getBoardPieces());
            //Se piden datos

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

    }
}