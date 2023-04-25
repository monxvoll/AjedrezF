package Logic;

public class King extends Piece {
    public King(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }

    


    public String movePiece(int corX, int corY, Boolean color, Piece[][] board) {

        //ejecuta el metodo verificar y si se cumple alguna condicion dara false y saldra del metodo mover pieza
        if (!verifyMovement(corX, corY, color, board).equals("true")) {
            return verifyMovement(corX, corY, getColor(), board);
        }
        // Actualiza las anteriores posiciones con las nuevas
        this.ubicationX = corX;
        this.ubicationY = corY;

        //No devuelve el tablero ya que eso se hace en el identificador
        return  "true";
    }

    public String verifyMovement(int cordX, int cordY, boolean color, Piece[][] board) {

        int actualMenosNuevaPosX = Math.abs(cordX - this.ubicationX);
        int actualMenosNuevaPosY = Math.abs(cordY - this.ubicationY);
 
        // Verifica que la nueva posicion tenga una pieza del otro color
        if (board[cordX][cordY] != null && board[cordX][cordY].getColor() == this.color) {
            return "ERROR [No te puedes comer a ti mismo]";
            // Verifica que el rey no se salga del tablero
        } if (!verifyRange(cordX, cordY)) {
            return "ERROR [has intentado salir del tablero]";
            //Verifica que el rey solo se mueva un cuadro
        }else if (actualMenosNuevaPosX > 1 || actualMenosNuevaPosY > 1) {
            return "ERROR [Movimiento no valido segun las reglas del ajedrez]";
        }else {
            return "true";
        }
    }
}



