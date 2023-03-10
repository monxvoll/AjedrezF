package Logic;

public class Bishop extends Piece{
    @Override
    public int movePiece() {
        return 0;
    }

    public Bishop(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
}
