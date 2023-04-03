package Logic;

public class Pawn extends Piece {


    public Pawn(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }

    public Pawn() {

    }



    @Override
    public void movePiece(int corX, int corY, Boolean color ) {
        int enterCordY = 0; //coordenada en Y a donde se movera el peon
        int enterCordX = 0; //coordenada en X a donde se movera el peon
        //ejecuta el metodo verificar y si se cumple alguna condicion dara false y saldra del metodo mover pieza
        if (verifyMovement(corX ,corY ,color) == false) {
            System.out.println("Movimiento invalido");
            return;
        }

        //actualiza las anteriores posiciones con las nuevas
        if (color) {
            this.ubicationY = enterCordY ;
            this.ubicationX = enterCordX ;
        } else {
            this.ubicationY = enterCordY;
            this.ubicationX = enterCordX ;
        }


        //No devuelve el tablero ya que eso se hace en el identificador
    }

    public  boolean  verifyMovement(int cordX, int cordY, boolean color){
        Board board = new Board();
        //verifica que las nuevas posiciones  no muevan el peon abajo si es negro o arriba si es blanco
        if (color && cordY <=this.ubicationY || color == false && cordX >= this.ubicationY){
            return false;
        //verifica que cuando el peon esta en la ubicacion inicial no se mueva mas de 2 cuadros dependiendo su color
        }else if (color && ubicationY == 2 && cordY >4 || color ==false && ubicationY == 7 && cordY < 5) {
            return false;
        //verifica que la posicion a donde se quiere mover el peon este vacia , si no es asi no se movera
        } else if (  board.getBoard()[cordX][this.ubicationY +cordY] != null){
            return  false;
        }
        return  true;

    }
    //El peon no se movera diagonalmente si no hay una pieza del color opuesto
    public void killerMove(int cordX, int cordY, boolean color){
        Board board = new Board();
        if (cordX == this.ubicationX - 1 || cordX == this.ubicationX + 1 &&
                board.getBoard()[cordX][this.ubicationY + cordY] == null ||
                board.getBoard()[cordX][this.ubicationY + cordY].getColor() == this.color){
        }
        //No devuelve el tablero ya que eso se hace en el identificador
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