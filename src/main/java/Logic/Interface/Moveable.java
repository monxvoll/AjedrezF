package Logic.Interface;

import Logic.Piece;

public interface Moveable {
    String movePiece(int ubicationX, int ubicationY, Boolean color, Piece[][] board);

    String verifyMovement(int cordX, int cordY, boolean color, Piece[][] board);
}
