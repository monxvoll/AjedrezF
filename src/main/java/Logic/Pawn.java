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
        int actualMenosNuevaPosX = Math.abs(cordX - this.ubicationX);
        int actualMenosNuevaPosY = Math.abs(cordY - this.ubicationY);
        int actualMenosNuevaPosYY = cordY - this.ubicationY;
        //Verifica que la pieza no retroceda
        if (board.getPiece(cordX,cordY) != null) {
            if (board.getPiece(cordX,cordY).getColor() == false && actualMenosNuevaPosYY < 0) {
                return false;
            }
            if (board.getPiece(cordX,cordY).getColor() == true && actualMenosNuevaPosYY < 0) {
                return false;
            }
        }
        // Verifica que la nueva posicion  no tenga una pieza del mismo color
        if (board.getBoard()[cordX][cordY] != null && board.getBoard()[cordX][cordY].getColor() == this.color) {
            System.out.println("ERROR [No puedes matar a tu propio equipo]");
            return false;
            // Verifica que el peon no se salga del tablero
        } else if (verifyRange(cordX, cordY) == false) {
            System.out.println("ERROR [Las nuevas coordenadas no estan dentro del tablero]");
            return false;
            //Verifica que si el  peon esta en su posicion inicial no se mueva mas de 2 posiciones en Y
        } else if (this.ubicationY == 2 && cordY > 4) {
            System.out.println("ERROR [Movimiento invalido para esta posicion]");
            return false;
        } else if (this.ubicationY == 7 && cordY < 5) {
            System.out.println("ERROR [Movimiento invalido para esta posicion]");
            return false;
            //Verifica que si el peon no esta en su posicion inicial no se mueva mas de 2 posiciones en Y
        } else if (this.ubicationY != 7 && this.ubicationY != 2 && actualMenosNuevaPosY > 1) {
            System.out.println("ERROR [Movimiento invalido]");
            return false;
            //Verifica que el peon no se mueva a un espacio vacio a la derecha o izquierda
        } else if (board.getPiece(cordX, cordY) == null && actualMenosNuevaPosX != 0) {
            System.out.println(actualMenosNuevaPosX);
            System.out.println("ERROR [Movimiento imposible]");
            return false;
        } else if (board.getBoard()[cordX][cordY] != null && actualMenosNuevaPosX == 0 && actualMenosNuevaPosY == 1) {
            System.out.println("ERROR [No puedes matar de frente]");
            return false;
            //Verifica que el peon no se mueva diagonalmente mas de un cuadro
        } else if (actualMenosNuevaPosX >1 ) {
            System.out.println("ERROR [Jugada invalida]");
        return false;
        }else {
            return true;
        }
    }
}