package Logic;



public class Bishop extends Piece{



    public Bishop(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
    public Bishop(){}

    @Override
    public boolean movePiece(int corX, int corY, Boolean color) {
    return  true;
    }
}