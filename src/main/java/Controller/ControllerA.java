package Controller;

import Logic.*;
import Logic.Exeptions.CustomWinExeption;

public class ControllerA {
    
    private Board boardInstance = new Board();

    private Piece[][] board = boardInstance.getClonBoard();

    private int turn = 0;

    private boolean colorTurn = true;
    
    public void turn() {

        colorTurn = !colorTurn;
        turn = (turn == 0) ? 1 : 0;

    }

    public String verifyData(String cordX , String cordY , String newCordX , String newCordY) throws CustomWinExeption{

        int corddX = 0;
        int corddY = 0;
        int newCorddX = 0;
        int newCorddY = 0;

        try{

            corddX = cordX.charAt(0)-64;
            corddY = Integer.parseInt(cordY);
            newCorddX = newCordX.charAt(0)-64;
            newCorddY = Integer.parseInt(newCordY);
            return identifyPiece(corddX,corddY,colorTurn,newCorddX,newCorddY);
        }catch (NumberFormatException e) {
            return "El tipo de dato ingresado no es valido";
        }catch(ArrayIndexOutOfBoundsException exp){
            return "Fuera de rango";
        }catch(StringIndexOutOfBoundsException exception){
            return "Tipo de dato ingresado en conflicto";
        }

        
    }

    public String identifyPiece(int cordX, int cordY, Boolean color, int newCordX, int newCordY) throws CustomWinExeption {

        Piece piece = board[cordX][cordY];
        if (piece == null) {
            // manejar el caso en que no hay pieza en la coordenada especificada
            return "Digite un espacio valido";
        } 

        
        if (piece.getColor() != color) {
            
            return "No es el turno del jugador";

        }else if(!piece.movePiece(newCordX, newCordY, color, boardInstance.getClonBoard()).equals("true") ){

            //return "Movimiento invalido";
            return piece.movePiece(newCordX, newCordY, color, boardInstance.getClonBoard());
    
        }
        //Si por cumple el movmiento valido itera el turno
        else
        turn();
    
        boardInstance.movePiece(cordX, cordY, newCordX, newCordY, piece, color);
        return piece.toString();
    }

    //return newBoardPieces
    public Piece[][] getBoardPieces(){
        Piece[][] boardPieces = boardInstance.getClonBoard();
        return boardPieces;
    }

}
