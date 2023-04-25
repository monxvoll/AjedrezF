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
        } if (verifyRange(cordX, cordY) == false) {
            return "ERROR [Te has intentado salir del tablero]";
            //Verifica que el rey solo se mueva un cuadro
        }else if (actualMenosNuevaPosX > 1 || actualMenosNuevaPosY > 1) {
            return "ERROR [Movimiento no valido segun las reglas del ajedrez]";
        }else {
            return "true";
        }
    }

    /*public boolean verifyMovement(int cordX, int cordY, boolean color) {
        Board board = new Board();
        // Verifica que la nueva posicion tenga una pieza del otro color o este vacia
        if (board.getBoard()[cordX][cordY] == null || board.getBoard()[cordX][cordY].getColor() != this.color) {
            return true;
        }

        // Verifica que el rey no se salga del tablero
         if (verifyRange(cordX,cordY) != true) {

            return false;
        }

        // Verifica que el rey no se mueva mas de una casilla
        //se restan las posiciones actuales y nuevas en X y en Y para que esa resta solo sea 1
        int actualMenosNuevaPosX = cordX - this.ubicationX;
        int actualMenosNuevaPosY = cordY - this.ubicationY;

        if (actualMenosNuevaPosX < -1 || actualMenosNuevaPosX > 1 || actualMenosNuevaPosY < -1 || actualMenosNuevaPosY > 1) {
            return false;
        }
        return true;
    }

    public void killerMove(int cordX, int cordY, boolean color) {
        Board board = new Board();

        // Verifica si la casilla a donde se movera tiene una pieza del mismo color si es asi no se movera y si no si se movera
        if (board.getBoard()[cordX][cordY] != null && board.getBoard()[cordX][cordY].getColor() == this.color) {
            System.out.println("No se puede matar una pieza del mismo color");
            return;
        }
        // Verifica si las coordenadas para matar son correctas
        if ((cordX == this.ubicationX + 1 && cordY == this.ubicationY) ||
                (cordX == this.ubicationX + 1 && cordY == this.ubicationY + 1) ||
                (cordX == this.ubicationX && cordY == this.ubicationY + 1) ||
                (cordX == this.ubicationX - 1 && cordY == this.ubicationY + 1) ||
                (cordX == this.ubicationX - 1 && cordY == this.ubicationY) ||
                (cordX == this.ubicationX - 1 && cordY == this.ubicationY - 1) ||
                (cordX == this.ubicationX && cordY == this.ubicationY - 1) ||
                (cordX == this.ubicationX + 1 && cordY == this.ubicationY - 1)) {
            // Actualiza la ubicación del rey
            this.ubicationX = cordX;
            this.ubicationY = cordY;
        }
    }*/
}



