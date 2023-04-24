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

    private int turn = 0;

    private boolean colorTurn = true;

    public Piece getPiece(int cordX, int cordY) {
        Piece movement;
        movement = boardInstance.getBoard()[cordX][cordY];
        return movement;
    }
    
    public void turn() {

        colorTurn = !colorTurn;
        turn = (turn == 0) ? 1 : 0;

    }

    public String verifyData(String cordX , String cordY , String newCordX , String newCordY){

        int corddX = 0;
        int corddY = 0;
        int newCorddX = 0;
        int newCorddY = 0;

        try{

            corddX = Integer.parseInt(cordX);
            corddY = Integer.parseInt(cordY);
            newCorddX = Integer.parseInt(newCordX);
            newCorddY = Integer.parseInt(newCordY);
            return identifyPiece(corddX,corddY,colorTurn,newCorddX,newCorddY);
        }catch (NumberFormatException e){
            return "El tipo de dato ingresado no es valido";
        }catch (ArrayIndexOutOfBoundsException exep){
            return "Movimiento fuera de los limites";
        }

        
    }

    public String identifyPiece(int cordX, int cordY, Boolean color, int newCordX, int newCordY) {

        Piece piece = getPiece(cordX, cordY);
        if (piece == null) {
            // manejar el caso en que no hay pieza en la coordenada especificada
            return "Digite un espacio valido";
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
                // manejar el caso en que no se encuentra la pieza correspondiente en el arreglo
                break;
        }
        if (piece.getColor() != color) {
            
            return "No es el turno del jugador";

        }else if(piece.movePiece(newCordX, newCordY, color) == false){

            return "Movimiento invalido";
    
        }
        //Si por cumple el movmiento valido itera el turno
        else
        turn();
    
        boardInstance.movePiece(cordX, cordY, newCordX, newCordY, piece, color);
        String retorno = piece.toString();
        return retorno;
    }

    //return newBoardPieces
    public Piece[][] getBoardPieces(){
        Piece[][] boardPieces = boardInstance.getClonBoard();
        return boardPieces;
    }

    //setter and getter
    public void setColor(boolean color){
        this.colorTurn = color;
    }
    public boolean getColor(){
        return colorTurn;
    }
    public void setTurn(int turn){
        this.turn = turn;
    }
}
