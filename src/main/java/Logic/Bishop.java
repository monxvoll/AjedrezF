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
        //Instancia Board
        Board board = new Board();

        //Si llega el caso de que el movimiento no es en diagonal
        //Se crean dos variables para calcular la cantidad de ubicaciones avanzadas
        int advancedX = Math.abs(destX-ubicationX);
        int advancedY = Math.abs(destY-ubicationY);

        //Compara los avances, si no son iguales eso significa que no es un movimiento valido
        if(advancedX != advancedY){
            return false;
        }

        //Verifico hacia donde va a ir
        //Hay cinco casos de iteracion (-y-x), (-x+y), (x+y), (-x-y), (x-y)
        int direccionX = Integer.compare(destX, ubicationX);
        int direccionY = Integer.compare(destY, ubicationY);

        //Variables posiciones actuales
        int currentlyX = ubicationX;
        int currentlyY = ubicationY;

        //Ciclo que se va a encargar de iterar hasta la nueva posicion de la pieza
        while( (currentlyX+=direccionX) != destX && (currentlyY+=direccionY) != destY ){
            if(board.getPiece(currentlyX, currentlyY) != null){
                //Se va a entrar si har algun tipo de obstaculo
                return false;
            }
            //En teoria esto itera hacia la direccion en que se movio, ya sea en X o Y
            currentlyX += direccionX;
            currentlyY += direccionY;
        }

        Piece targetPiece = board.getPiece(destX, destY);
        return targetPiece == null || targetPiece.getColor() != getColor();
    }
}
