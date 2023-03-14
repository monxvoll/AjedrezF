package Logic;

public class King extends Piece{
    @Override
    public int movePiece() {
        return 0;
    }

    public King(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
    public King(){}
}
