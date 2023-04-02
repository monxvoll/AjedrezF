package Logic;

public class Bishop extends Piece{


    public Bishop(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
    public Bishop(){}

    @Override
    public int movePiece(int ubicationX, int ubicationY) {
        return 0;
    }

}
