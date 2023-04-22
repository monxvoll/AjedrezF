package Logic;

public class Queen extends Piece {


    //True White, False Black
    public Queen(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }

    public Queen() {
    }

    @Override

    public boolean movePiece(int corX, int corY, Boolean color ) {
        return  true;
    }
}