package Logic;

public class Knight extends Piece{


    public Knight(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
    public Knight(){}

    @Override
    public int movePiece(int ubicationX, int ubicationY) {
        return 0;
    }


}
