package Logic;

public class Knight extends Piece {


    public Knight(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }

    


    @Override
    public String movePiece(int corX, int corY, Boolean color, Piece [][] board) {


        //ejecuta el metodo verificar y si se cumple alguna condicion dara false y saldra del metodo mover pieza
        if (!verifyMovement(corX, corY, color, board).equals("true")) {
            return verifyMovement(corX, corY, color, board);
        }

        //actualiza las anteriores posiciones con las nuevas
        this.ubicationX = corX;
        this.ubicationY = corY;

        //No devuelve el tablero ya que eso se hace en el identificador
        return "true";
    }

    public String verifyMovement(int cordX, int cordY, boolean colo, Piece[][] board) {
        
        int actualMenosNuevaPosX = Math.abs(cordX - this.ubicationX);
        int actualMenosNuevaPosY = Math.abs(cordY - this.ubicationY);
 
        // Verifica que la nueva posicion  no tenga una pieza del mismo color
        if (board[cordX][cordY] != null && board[cordX][cordY].getColor() == this.color) {
            return "ERROR [No te puedes comer a ti mismo]";
            // Verifica que el caballo no se salga del tablero
        } else if (!verifyRange(cordX, cordY)) {
            return "ERROR [Has salido de los limites]";//Esto nunca se deberia de ejecutar
            //Verifica que el caballo se  mueva en L
        } else if ((actualMenosNuevaPosX + actualMenosNuevaPosY )!= 3) {
            return "ERROR [El movimiento no cumple las reglas del ajedrez]";
        } else if (actualMenosNuevaPosX == 0 && actualMenosNuevaPosY!=0) {
            return "ERROR [Jugada invalida]";
        } else {
            return "true";
        }
    }
}