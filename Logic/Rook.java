package Logic;

public class Rook extends Piece{
    @Override
    public int movePiece() {
        return 0;
    }

    public Rook(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
}
