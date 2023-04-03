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
    private Board boardInstance;

    public Piece getPiece(int cordX, int cordY) {
        Piece movement;
        movement = boardInstance.getBoard()[cordX][cordY];
        return movement;
    }
    public void idetifyPiece(int cordX, int cordY, Boolean color) {
        Piece piece = getPiece(cordX, cordY);
        if (piece == null) {
            // manejar el caso en que no hay pieza en la coordenada especificada
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
                // manejar el caso en que no se encuentra la pieza correspondiente en el arreglo
                break;
        }

        if (type != null) {
            type.movePiece(cordX, cordY, color );
            boardInstance.getBoard()[cordX][cordY] = type;
        }
    }
}
