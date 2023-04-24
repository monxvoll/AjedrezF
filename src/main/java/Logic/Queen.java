package Logic;

public class Queen extends Piece {


    //True White, False Black
    public Queen(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }

    public Queen() {
    }
    public boolean movePiece(int corX, int corY, Boolean color) {

        //ejecuta el metodo verificar y si se cumple alguna condicion dara false y saldra del metodo mover pieza
        if (!verifyMovement(corX, corY, color)) {
            return false;
        }
        // Actualiza las anteriores posiciones con las nuevas
        this.ubicationX = corX;
        this.ubicationY = corY;

        //No devuelve el tablero ya que eso se hace en el identificador
        return  true;
    }


    public boolean verifyMovement(int corX, int corY, Boolean color ) {
         //Instancia Board
         Board board = new Board();

        //Si llega el caso de que el movimiento no es en diagonal
        //Se crean dos variables para calcular la cantidad de ubicaciones avanzadas
        int advancedX = Math.abs(corX-ubicationX);
        int advancedY = Math.abs(corY-ubicationY);
 
         //Verifico hacia donde va a ir
         //Hay cinco casos de iteracion (-y-x), (-x+y), (x+y), (-x-y), (x-y)
        int direccionX = Integer.compare(corX, ubicationX);
        int direccionY = Integer.compare(corY, ubicationY);
 
         //Variables posiciones actuales
        int currentlyX = ubicationX;
        int currentlyY = ubicationY;
 
        if(advancedX == advancedY){
            //Ciclo que se va a encargar de iterar hasta la nueva posicion de la pieza
            while( (currentlyX+=direccionX) != corX && (currentlyY+=direccionY) != corY ){
                if(board.getPiece(currentlyX, currentlyY) != null){
                    //Se va a entrar si har algun tipo de obstaculo  
                    return false;
                }
                //En teoria esto itera hacia la direccion en que se movio, ya sea en X o Y
                currentlyX += direccionX;
                currentlyY += direccionY;
            }
            
        }
        //movimiento vertical
        else if (direccionX == 0) {
            int currentY = ubicationY + direccionY;
            while (currentY != corY) {
                if (board.getPiece(ubicationX, currentY) != null) {
                    return false; // Se ejecuta si hay algo en el camino
                }
                currentY += direccionY;
            }
        }
        // si se mueve de forma horizontal
        else if (direccionY == 0) {
            int currentX = ubicationX + direccionX;
            while (currentX != direccionX) {
                if (board.getPiece(currentX, ubicationY) != null) {
                    return false; // Se ejecuta si hay algo en el camino
                }
                currentX += direccionX;
            }
        }else if(advancedX != advancedY && direccionX!=0 && direccionY != 0){
            return false;
        }

        Piece targetPiece = board.getPiece(corX, corY);
        return targetPiece == null || targetPiece.getColor() != getColor();
    }
}