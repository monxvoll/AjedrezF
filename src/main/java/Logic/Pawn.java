package Logic;

public class Pawn extends Piece {


    public Pawn(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }

    @Override
    public String movePiece(int corX, int corY, Boolean color, Piece[][] board ) {

        //ejecuta el metodo verificar y si se cumple alguna condicion dara false y saldra del metodo mover pieza
        if (!verifyMovement(corX ,corY ,color, board).equals("true")) {
            //return "false";
            return verifyMovement(corX ,corY ,color, board);
        }

        //actualiza las anteriores posiciones con las nuevas
            this.ubicationX = corX ;
            this.ubicationY = corY ;

        //No devuelve el tablero ya que eso se hace en el identificador
        return "true";
    }
    
    public String verifyMovement(int cordX, int cordY, boolean color, Piece[][] board) {

        int actualMenosNuevaPosX = Math.abs(cordX - this.ubicationX);
        int actualMenosNuevaPosY = Math.abs(cordY - this.ubicationY);
        int actualMenosNuevaPosYY = cordY - this.ubicationY;

        // Verifica que la nueva posicion  no tenga una pieza del mismo color
        if (board[cordX][cordY] != null && board[cordX][cordY].getColor() == this.color) {
            return("ERROR [No puedes matar a tu propio equipo]");
            // Verifica que el peon no se salga del tablero
        } else if (verifyRange(cordX, cordY) == false) {
            return("ERROR [Las nuevas coordenadas no estan dentro del tablero]");
            //Verifica que si el  peon esta en su posicion inicial no se mueva mas de 2 posiciones en Y
        } else if (this.ubicationY == 2 && cordY > 4) {
            return("ERROR [Movimiento invalido para esta posicion]");
        } else if (this.ubicationY == 7 && cordY < 5) {
            return("ERROR [Movimiento invalido para esta posicion]");
            //Verifica que si el peon no esta en su posicion inicial no se mueva mas de 2 posiciones en Y
        } else if (this.ubicationY != 7 && this.ubicationY != 2 && actualMenosNuevaPosY > 1) {
            return("ERROR [Movimiento invalido]");
            //Verifica que el peon no se mueva a un espacio vacio a la derecha o izquierda
        } else if (board[cordX][cordY] == null && actualMenosNuevaPosX != 0) {
            return("ERROR [Movimiento imposible]");
        } else if (board[cordX][cordY] != null && actualMenosNuevaPosX == 0 && actualMenosNuevaPosY == 1) {
            return("ERROR [No puedes matar de frente]");
            //Verifica que el peon no se mueva diagonalmente mas de un cuadro
        } else if (actualMenosNuevaPosX >1 ) {
            return "ERROR [Jugada invalida]";
            // Verifica que el peon no intente retroceder segun su color
        } else if ((color && cordY < this.ubicationY) || (!color && cordY > this.ubicationY)) {
            return("ERROR [No puedes retroceder]");
        }else {
            return "true";
        }
    }
}