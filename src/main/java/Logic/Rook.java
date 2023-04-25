package Logic;

public class Rook extends Piece{

   //Constructor
    public Rook(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
    //Métodos
    @Override
    public String movePiece(int corX, int corY, Boolean color, Piece[][] board) {
        if (!verifyMovement(corX, corY, color, board).equals("true")) {
            return verifyMovement(corX, corY, getColor(), board);
        }
        this.ubicationX = corX;
        this.ubicationY = corY;
        return "true";
    }

    public String verifyMovement(int cordX, int cordY, boolean color, Piece[][] board) {
        
        // Ve a que direccion va el movimiento
        int dirX = Integer.compare(cordX, ubicationX);
        int dirY = Integer.compare(cordY, ubicationY);
    
        // ve si se mueve vertical
        if (dirX == 0) {
            int currentY = ubicationY + dirY;
            while (currentY != cordY) {
                if (board[ubicationX][currentY] != null) {

                    return "ERROR [Movimiento vertical, no puedes mover, hay una pieza en tu camino que te obstruye]"; // Se ejecuta si hay algo en el camino
                }
                currentY += dirY;
            }
        }
        // si se mueve de forma horizontal
        else if (dirY == 0) {
            int currentX = ubicationX + dirX;
            while (currentX != cordX) {
                if (board[currentX][ubicationY] != null) {
                    return "ERROR [Movimiento horizontal, no puedes mover, hay una pieza en tu camino que te obstruye]"; // Se ejecuta si hay algo en el camino
                }
                currentX += dirX;
            }
        }
        // si no cumple con ninguno de los dos tipos de movimiento va a retornar falso
        else {
            return "ERROR [No te estas moviendo horizontal ni verticalmente]";
        }
    
        //Verifica si el color de la pieza es igual al color de la interrupcion
        Piece targetPiece = board[cordX][cordY];
        if(targetPiece == null || targetPiece.getColor() != color)
        return "true";
        else
        return "ERROR [No te puedes comer a ti mismo]";
    }

}