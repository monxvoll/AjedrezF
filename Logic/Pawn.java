package Logic;

public class Pawn extends Piece {


    public Pawn(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }

    public Pawn() {

    }




    @Override
    public boolean movePiece(int corX, int corY, Boolean color ) {
        Board board = new Board();

        //ejecuta el metodo verificar y si se cumple alguna condicion dara false y saldra del metodo mover pieza
        if (verifyMovement(corX ,corY ,color) == false) {
            System.out.println("Movimiento invalido");
            return false;
        }

        //actualiza las anteriores posiciones con las nuevas
            this.ubicationX = corX ;
            this.ubicationY = corY ;

        //No devuelve el tablero ya que eso se hace en el identificador
        return true;
    }

    public  boolean  verifyMovement(int cordX, int cordY, boolean color) {
        Board board = new Board();
        int actualMenosNuevaPosX = cordX - this.ubicationX;
        int actualMenosNuevaPosY = cordY - this.ubicationY;
        // Verifica que la nueva posicion  no tenga una pieza del mismo color
        if (board.getBoard()[cordX][cordY] != null && board.getBoard()[cordX][cordY].getColor() == this.color) {
            return false;
            // Verifica que el peon no se salga del tablero
        } else if (verifyRange(cordX, cordY) == false) {
            return false;
            //Verifica que si el  peon esta en su posicion inicial no se mueva mas de 2 posiciones en Y
        } else if (this.ubicationY == 2 && cordY > 4) {
            return false;
        } else if (this.ubicationY == 7 && cordY < 5) {
            return false;
            //Verifica que si el peon no esta en su posicion inicial no se mueva mas de 2 posiciones en Y
        }else if  (this.ubicationY != 7 && this.ubicationY !=2 && actualMenosNuevaPosY >1) {
            return false;
            //Verifica que el peon solo se mueva a los lados si es diagonal y si hay una pieza de otro color
        } /*else if (board.getBoard()[cordX][cordY] != null && board.getBoard()[cordX][cordY].getColor() != this.color &
                actualMenosNuevaPosX ==1 && actualMenosNuevaPosY ==1 ||
                actualMenosNuevaPosX ==-1 && actualMenosNuevaPosY ==1 ||
                actualMenosNuevaPosX ==1 && actualMenosNuevaPosY ==-1||
                actualMenosNuevaPosX ==-1 && actualMenosNuevaPosY ==-1 ) {
            return true;
        }else{
            return  false;
        }*/
        return  true;
    }
}