package View;

import Logic.Board;
import Logic.Piece;

import javax.swing.*;
import java.util.Scanner;

public class PrincipalT  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        board.showBoard();
        int cordX = 0;
        int cordY = 0;
        System.out.println("Digite las coordenadas numericas de la pieza que desea mover");
        System.out.println("Coordenada en X = ");
        cordX = scanner.nextInt();
        System.out.println("Coordenada en Y = ");
        cordY = scanner.nextInt();
        board.idetifyPiece(cordX,cordY);
    }


}
