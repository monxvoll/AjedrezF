package Logic;

public class King extends Piece  {
    public King(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }

    public King(){}


    public void movePiece(int corX, int corY, Boolean color) {
        int enterCordX = 0; //coordenada en X a donde se movera el rey
        int enterCordY = 0; //coordenada en Y a donde se movera el rey

        //ejecuta el metodo verificar y si se cumple alguna condicion dara false y saldra del metodo mover pieza
        if (!verifyMovement(enterCordX, enterCordY, color)) {
            System.out.println("Movimiento inválido");
            return;
        }
        // Actualiza las anteriores posiciones con las nuevas
        this.ubicationY = enterCordY;
        this.ubicationX = enterCordX;
        //No devuelve el tablero ya que eso se hace en el identificador
    }

    public boolean verifyMovement(int cordX, int cordY, boolean color) {
        Board board = new Board();

        // Verifica que el rey no se salga del tablero
        if (cordX < 0 || cordX > 7 || cordY < 0 || cordY > 7) {
            return false;
        }

        // Verifica que el rey no se mueva mas de una casilla
        //se restan las posiciones actuales y nuevas en X y en Y para que esa resta solo sea 1
        int actualMenosNuevaPosX = cordX - this.ubicationX;
        int actualMenosNuevaPosY = cordY - this.ubicationY;

        if (actualMenosNuevaPosX < -1 || actualMenosNuevaPosX > 1 || actualMenosNuevaPosY < -1 || actualMenosNuevaPosY > 1) {
            return false;
            //verifica que la posicion a donde se quiere mover el rey este vacia , si no es asi no se movera
        } else if (board.getBoard()[cordX][+cordY] != null) {
            return false;
        }
        return true;
    }

    public void killerMove(int cordX, int cordY, boolean color) {
        Board board = new Board();

        // Verifica si la casilla a donde se movera tiene una pieza de mismo color
        if (board.getBoard()[cordX][cordY] != null && board.getBoard()[cordX][cordY].getColor() == color) {
            return;
        }
        // Actualiza las posiciones para mover al rey
        this.ubicationY = cordY;
        this.ubicationX = cordX;
        //No devuelve el tablero ya que eso se hace en el identificador
    }
}
