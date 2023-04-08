package Controller;

import Logic.Bishop;
import Logic.Board;
import Logic.King;
import Logic.Knight;
import Logic.Pawn;
import Logic.Piece;
import Logic.Queen;
import Logic.Rook;

public class ControllerA {
    private Board boardInstance = new Board();

    private Piece piece;

    private  static boolean color ;

    private int turn = 0;

    public Piece getPiece(int cordX, int cordY) {
        Piece movement;
        movement = boardInstance.getBoard()[cordX][cordY];
        return movement;
    }



    public String  verifyData(String cordX , String cordY , String newCordX , String newCordY){

        int corddX = 0;
        int corddY = 0;
        int newCorddX= 0;
        int newCorddY = 0;
        try{
            corddX = Integer.parseInt(cordX);
            corddY = Integer.parseInt(cordY);
            newCorddX = Integer.parseInt(newCordX);
            newCorddY = Integer.parseInt(newCordY);

        }catch (NumberFormatException e){
            return "El tipo de dato ingresado no es valido";
        }
        turn();

        identifyPiece(corddX,corddY,color,newCorddX,newCorddY);
        return "Impriendo";
    }

    public void turn (){
         turn = (turn + 1)%2;
       if (turn == 1){
           this.color =false;
       } else {
           this.color =true;
       }
    }
    public int getTurn(){
        return turn;
    }

    public void identifyPiece(int cordX, int cordY, Boolean color, int newCordX, int newCordY) {
        Piece piece = getPiece(cordX, cordY);
        if (piece == null) {
            System.out.println("Digite un espacio valido"); // manejar el caso en que no hay pieza en la coordenada especificada
            return;
        }

        Piece type = null;
        switch (piece.getName()) {
            case "T":
                type = new Rook();
                break;
            case "A":
                type = new Bishop();
                break;
            case "C":
                type = new Knight();
                break;
            case "Q":
                type = new Queen();
                break;
            case "K":
                type = new King();
                break;
            case "P":
                type = new Pawn();
                break;
            default:
                System.out.println("Pieza inexistente"); // manejar el caso en que no se encuentra la pieza correspondiente en el arreglo
                break;
        }

        if (type != null) {
            //if (type.getColor() == color) {
            if (type.movePiece(newCordX, newCordY, color)) {
                System.out.println(type.getColor());
                boardInstance.getBoard()[newCordX][newCordY] = type;
                boardInstance.getBoard()[cordX][cordY] = null;
            }

        }
    }
}
