package Logic;

public class Pawn extends Piece {


    public Pawn(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }

    public Pawn() {

    }




    @Override
    public void movePiece(int corX, int corY, Boolean color ) {
        Board board = new Board();

        //ejecuta el metodo verificar y si se cumple alguna condicion dara false y saldra del metodo mover pieza
        if (verifyMovement(corX ,corY ,color) == false) {
            System.out.println("Movimiento invalido");
            return;
        }

        //actualiza las anteriores posiciones con las nuevas
            this.ubicationX = corX ;
            this.ubicationY = corY ;

        //No devuelve el tablero ya que eso se hace en el identificador

    }

    public  boolean  verifyMovement(int cordX, int cordY, boolean color){
        Board board = new Board();
        // Verifica que la nueva posicion tenga una pieza del otro color o este vacia
        if (board.getBoard()[cordX][cordY] == null || board.getBoard()[cordX][cordY].getColor() != this.color) {
            return  true;
        }
        //verifica que las nuevas posiciones  no muevan el peon abajo si es negro o arriba si es blanco
        if (color && cordY <=this.ubicationY || color == false && cordX >= this.ubicationY){
            return false;
        //verifica que cuando el peon esta en la ubicacion inicial no se mueva mas de 2 cuadros dependiendo su color
        }else if (color && ubicationY == 2 && cordY >4 || color ==false && ubicationY == 7 && cordY < 5) {
            return false;
            // Verifica que el peon no se salga del tablero
        }else if (cordX < 0 || cordX > 8 || cordY < 0 || cordY > 8) {
            return false;
        }

        return  true;

    }
    //El peon no se movera diagonalmente si no hay una pieza del color opuesto
    public void killerMove(int cordX, int cordY, boolean color) {
            Board board = new Board();
            Piece piece = board.getBoard()[cordX][cordY];
        // Verifica si la casilla a donde se movera tiene una pieza del mismo color si es asi no se movera y si no si se movera
             if (board.getBoard()[cordX][cordY] != null && board.getBoard()[cordX][cordY].getColor() == this.color) {
                 System.out.println("No se puede matar una pieza del mismo color");
            return;
             }
            //Verifica que las coordenadas para matar sean correctas y si es asi las actualiza
            if (cordX == this.ubicationX + 1 && cordY == this.ubicationY + 1 ||
                    cordX == this.ubicationX - 1 && cordY == this.ubicationY + 1 ||
                    cordX == this.ubicationX + 1 && cordY == this.ubicationY - 1 ||
                    cordX == this.ubicationX - 1 && cordY == this.ubicationY - 1) {
                //Actualiza la ubicación del peón
                this.ubicationX = cordX;
                this.ubicationY = cordY;
            }


        }



    public void specialMovement(int cordX, int cordY, boolean color) {

        //verifica si las posiciones dadas al escojer la pieza son las inciales y ejecuta el movimiento especial segun el color
        if (cordY == 2 && color == true) {
            this.ubicationY = cordY + 2;
        } else if (cordY == 7 && color == false)
            this.ubicationY = cordY - 2;
    }
    //No devuelve el tablero ya que eso se hace en el identificador



}