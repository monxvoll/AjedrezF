package Logic;

public class Rook extends Piece{



    public Rook(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
    public Rook(){}

    @Override
    public int movePiece(int ubicationX, int ubicationY) {
        return 0;
    }

}
