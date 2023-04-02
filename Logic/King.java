package Logic;

public class King extends Piece  {
    public King(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }

    public King(){}


    @Override
    public int movePiece(int ubicationX, int ubicationY) {
        return 0;
    }
}
