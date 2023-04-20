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
        int actualMenosNuevaPosX = cordX - this.ubicationX;
        int actualMenosNuevaPosY = cordY - this.ubicationY;
        System.out.println(actualMenosNuevaPosX);
        System.out.println(actualMenosNuevaPosY);

        // Verifica que la nueva posicion  no tenga una pieza del mismo color
        if (board.getBoard()[cordX][cordY] != null && board.getBoard()[cordX][cordY].getColor() == this.color) {
            return false;
            // Verifica que el usuario digito un movimiento correcto en L del  caballo calculando cuantos cuadros se movio en X o Yif ((actualMenosNuevaPosX != 1 && actualMenosNuevaPosY != 2) ||
        } else if (verifyRange(cordX, cordY) == false) {
            return false;
        } else if ((actualMenosNuevaPosX == 1 && actualMenosNuevaPosY == 2) ||
                (actualMenosNuevaPosX == 2 && actualMenosNuevaPosY == 1) ||
                (actualMenosNuevaPosX == -1 && actualMenosNuevaPosY == -2) ||
                (actualMenosNuevaPosX == -2 && actualMenosNuevaPosY == -1) ||
                (actualMenosNuevaPosX == -1 && actualMenosNuevaPosY == 2) ||
                (actualMenosNuevaPosX == 1 && actualMenosNuevaPosY == -2) ||
                (actualMenosNuevaPosX == 2 && actualMenosNuevaPosY == -1) ||
                (actualMenosNuevaPosX == -2 && actualMenosNuevaPosY == 1)) {
            return true;
        } else {
            return false;
        }
    }
}