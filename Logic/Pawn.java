package Logic;

public class Pawn extends Piece{
    @Override
    public int movePiece() {
        return 0;
    }

    public Pawn(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }

}
