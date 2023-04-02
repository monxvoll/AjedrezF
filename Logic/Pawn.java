package Logic;

public class Pawn extends Piece{



    public Pawn(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
    public Pawn(){

    }
    @Override
    public int movePiece(int corX , int CorY ) {
        Board board = new Board();
        Piece[][] boardDos = new Piece[9][9];
        boardDos = board.getBoard();


        return  1;
    }
    public int verifyMovement(int cordX , int cordY){

        return  1;
    }

}
