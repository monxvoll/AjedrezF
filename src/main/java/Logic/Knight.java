package Logic;

public class Knight extends Piece {


    public Knight(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }

    public Knight() {
    }


    @Override
    public boolean movePiece(int corX, int corY, Boolean color) {


        //ejecuta el metodo verificar y si se cumple alguna condicion dara false y saldra del metodo mover pieza
        if (verifyMovement(corX, corY, color) == false) {
            System.out.println("Movimiento invalido");
            return false;
        }

        //actualiza las anteriores posiciones con las nuevas
        this.ubicationX = corX;
        this.ubicationY = corY;

        //No devuelve el tablero ya que eso se hace en el identificador
        return true;
    }

    public boolean verifyMovement(int cordX, int cordY, boolean color) {
        Board board = new Board();
        
        int actualMenosNuevaPosX = Math.abs(cordX - this.ubicationX);
        int actualMenosNuevaPosY = Math.abs(cordY - this.ubicationY);
 
        // Verifica que la nueva posicion  no tenga una pieza del mismo color
        if (board.getBoard()[cordX][cordY] != null && board.getBoard()[cordX][cordY].getColor() == this.color) {
            return false;
            // Verifica que el caballo no se salga del tablero
        } else if (verifyRange(cordX, cordY) == false) {
            return false;
            //Verifica que el caballo se  mueva en L
        } else if ((actualMenosNuevaPosX + actualMenosNuevaPosY )!= 3) {
            return false;
        } else {
            return true;
        }
    }
}