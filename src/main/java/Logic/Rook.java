package Logic;

public class Rook extends Piece{

   //Constructor
   public Rook(boolean color, String name, int ubicationX, int ubicationY) {
    super(color, name, ubicationX, ubicationY);
   }
    public Rook(){}
    //Métodos
    @Override
    public boolean movePiece(int corX, int corY, Boolean color) {
        if (verifyMovement(corX, corY, color) != true) {
            return false;
        }
        this.ubicationX = corX;
        this.ubicationY = corY;
        return true;
    }

    public boolean verifyMovement(int cordX, int cordY, boolean color) {
        // Instancia d eboard
        Board board = new Board();
        
        // Ve a que direccion va el movimiento
        int dirX = Integer.compare(cordX, ubicationX);
        int dirY = Integer.compare(cordY, ubicationY);
    
        // ve si se mueve vertical
        if (dirX == 0) {
            int currentY = ubicationY + dirY;
            while (currentY != cordY) {
                if (board.getPiece(ubicationX, currentY) != null) {

                    return false; // Se ejecuta si hay algo en el camino
                }
                System.out.println(currentY);
                currentY += dirY;
            }
        }
        // si se mueve de forma horizontal
        else if (dirY == 0) {
            int currentX = ubicationX + dirX;
            while (currentX != cordX) {
                if (board.getPiece(currentX, ubicationY) != null) {
                    return false; // Se ejecuta si hay algo en el camino
                }
                currentX += dirX;
            }
        }
        // si no cumple con ninguno de los dos tipos de movimiento va a retornar falso
        else {
            return false;
        }
    
        //Verifica si el color de la pieza es igual al color de la interrupcion
        Piece targetPiece = board.getPiece(cordX, cordY);
        return targetPiece == null || targetPiece.getColor() != color;
    }

}