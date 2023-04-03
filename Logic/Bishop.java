package Logic;

public class Bishop extends Piece{



    public Bishop(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
    public Bishop(){}

    @Override
    public void movePiece(int corX, int corY, Boolean color ) {
        int enterCordY = 0;
        int enterCordX = 0;
        if(color){
            this.ubicationX = enterCordY ;
            this.ubicationY = enterCordX;
        }
    }
    public  boolean  verifyMovement(int cordX, int cordY, boolean color){
        Board board = new Board();
        //verifica que si el peon esta en su posicion inicial no se mueva arriba o abajo segun el color
        if (color && cordY <=this.ubicationY || color == false && cordX >= this.ubicationX){
            return false;
        }
        return  true;

    }
}
