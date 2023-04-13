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
        return  true;
    }

    public boolean verifyMovement(int cordX, int cordY, boolean color) {
        Board board = new Board();
        int actualMenosNuevaPosX = cordX - this.ubicationX;
        int actualMenosNuevaPosY = cordY - this.ubicationY;
        // Verifica que la nueva posicion tenga una pieza del otro color o este vacia
        if (board.getBoard()[cordX][cordY] == null || board.getBoard()[cordX][cordY].getColor() != this.color) {
            // Verifica que el usuario digito un movimiento correcto en L del  caballo calculando cuantos cuadros se movio en X o Y
            if ((actualMenosNuevaPosX == 1 && actualMenosNuevaPosY == 2) ||
                    (actualMenosNuevaPosX == 2 && actualMenosNuevaPosY == 1) ||
                    (actualMenosNuevaPosX == -1 && actualMenosNuevaPosY == -2) ||
                    (actualMenosNuevaPosX == -2 && actualMenosNuevaPosY == -1) ||
                    (actualMenosNuevaPosX == -1 && actualMenosNuevaPosY == 2) ||
                    (actualMenosNuevaPosX == 1 && actualMenosNuevaPosY == -2) ||
                    (actualMenosNuevaPosX == 2 && actualMenosNuevaPosY == -1) ||
                    (actualMenosNuevaPosX == -2 && actualMenosNuevaPosY == 1)) {
                return true;
            }else if (verifyRange(cordX,cordY) != true) {

                return false;
            }else {
                return  false;
            }
        }
        // Verifica que el caballo no se salga del tablero
        if (cordX < 0 || cordX > 9 || cordY < 0 || cordY > 9) {
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
        int actualMenosNuevaPosX = cordX - this.ubicationX;
        int actualMenosNuevaPosY = cordY - this.ubicationY;
        //verifica que las coodenadas a matar no sean diferente a una forma en L
        if ((actualMenosNuevaPosX == 1 && actualMenosNuevaPosY == 2) ||
                (actualMenosNuevaPosX == 2 && actualMenosNuevaPosY == 1) ||
                (actualMenosNuevaPosX == -1 && actualMenosNuevaPosY == -2) ||
                (actualMenosNuevaPosX == -2 && actualMenosNuevaPosY == -1) ||
                (actualMenosNuevaPosX == -1 && actualMenosNuevaPosY == 2) ||
                (actualMenosNuevaPosX == 1 && actualMenosNuevaPosY == -2) ||
                (actualMenosNuevaPosX == 2 && actualMenosNuevaPosY == -1) ||
                (actualMenosNuevaPosX == -2 && actualMenosNuevaPosY == 1)) {
            // Actualiza las posiciones para mover al caballo
            this.ubicationY = cordY;
            this.ubicationX = cordX;
            //No devuelve el tablero ya que eso se hace en el identificador
        }
    }
}