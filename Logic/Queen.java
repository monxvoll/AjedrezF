package Logic;

public class Queen extends Piece{


    //True White, False Black
    public Queen(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
    public Queen(){}

    @Override
    public int movePiece(int ubicationX, int ubicationY, Boolean color) {
        return 0;
    }
}
