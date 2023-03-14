package Logic;

public class Queen extends Piece{
    @Override
    public int movePiece() {
        return 0;
    }

    //True White, False Black
    public Queen(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
    public Queen(){}
}
