package Logic;



public class Bishop extends Piece{



    public Bishop(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
    public Bishop(){

    }

    @Override
    public boolean movePiece(int corX, int corY, Boolean color) {
        if (verifyMovement(corX, corY, color) != true) {
            return false;
        }
        this.ubicationX = corX;
        this.ubicationY = corY;
        return true;
    }
    public boolean verifyMovement(int destX, int destY, boolean color) {
        Board board = new Board();
        
        // Verifica si el destino es válido y no es la misma posición actual
        if ((destX < 1 || destX > 8) || (destY < 1 || destY > 8) || (destX == ubicationX && destY == ubicationY)) {
            return false;
        }
    
        // Verifica que se esté moviendo en diagonal
        int deltaX = Math.abs(destX - ubicationX);
        int deltaY = Math.abs(destY - ubicationY);
        if (deltaX != deltaY) {
            return false;
        }
    
        // Determina la dirección del movimiento
        int dirX = Integer.compare(destX, ubicationX);
        int dirY = Integer.compare(destY, ubicationY);
    
        // Verifica que no haya piezas en el camino
        int currentX = ubicationX + dirX;
        int currentY = ubicationY + dirY;
        while (currentX != destX || currentY != destY) {
            if (board.getPiece(currentX, currentY) != null) {
                return false;
            }
            currentX += dirX;
            currentY += dirY;
        }
    
        // Verifica si la pieza en la posición de destino es de otro color
        Piece targetPiece = board.getPiece(destX, destY);
        return targetPiece == null || targetPiece.getColor() != color;
    }
}
