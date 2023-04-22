package Logic;

public class Rook extends Piece{
    //Instancia para acceder a Board arreglo
    Board boardInstance ;


    //Instancia de Piece
    Piece whichPiece;

    //Ubicacion actual del objeto
    private int actualUbicationX = this.ubicationX;
    private int actualUbicationY = this.ubicationY;

    //Constructor
    public Rook(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
    public Rook(){

    }
    //Metodos

    //Mover General
    @Override
    public boolean movePiece(int corX, int corY, Boolean color ) {

        Board board = new Board();

        //ejecuta el metodo verificar y si se cumple alguna condicion dara false y saldra del metodo mover pieza
        if (verifyMovement(corX ,corY ,color) == false) {
            System.out.println("Movimiento invalido");
            return false;
        }

        //actualiza las anteriores posiciones con las nuevas
        this.setUbicationX(corX);
        this.setUbicationY(corY);

        //No devuelve el tablero ya que eso se hace en el identificador
        return true;
    }
    public boolean verifyMovement(int cordX, int cordY, boolean color) {
        Piece[][] board = boardInstance.getBoard();

        int advancedBoxesX = cordX- this.ubicationX;
        int advancedBoxesY = cordY- this.ubicationY;

        int cordA = recognizeSpacesA(actualUbicationX, actualUbicationY);
        int cordAt = recognizeSpacesAt(actualUbicationX, actualUbicationY);
        int cordLe = recognizeSpacesLe(actualUbicationX, actualUbicationY);
        int cordRi = recognizeSpacesRi(actualUbicationX, actualUbicationY);

        if(board[cordX][cordY] != null){

            if(recognizeSpacesA(actualUbicationX, actualUbicationY)!= -1){

                //Hacia adelante blancas, hacia atras negras
                if(cordY>cordA|| cordY<cordA){
                    if(cordY > cordA && color == true){
                        return false;
                    }else{
                        return false;
                    }
                }else if(cordA == cordY && board[cordX][cordY].getColor() == board[actualUbicationX][actualUbicationY].getColor()){
                    System.out.println("No puedes matar una pieza de tu equipo");
                    return false;
                }else if (cordA == cordY && board[cordX][cordY].getColor() != board[actualUbicationX][actualUbicationY].getColor()){
                    return true;
                }
            }else{
                return true;
            }

            if(recognizeSpacesAt(actualUbicationX, actualUbicationY)!= -1){

                //Hacia adelante blancas, hacia atras negras
                if(cordY>cordA|| cordY<cordA){
                    if(cordY > cordA && color == true){
                        return false;
                    }else{
                        return false;
                    }
                }else if(cordA == cordY && board[cordX][cordY].getColor() == board[actualUbicationX][actualUbicationY].getColor()){
                    System.out.println("No puedes matar una pieza de tu equipo");
                    return false;
                }else if (cordA == cordY && board[cordX][cordY].getColor() != board[actualUbicationX][actualUbicationY].getColor()){
                    return true;
                }
            }else{
                return true;
            }
        }

        return true;
    }

    //Espacios hacia adelante de las negras, atras blancas
    public int recognizeSpacesA(int corX, int corY){
        Piece[][] board = boardInstance.getBoard();

        int verify = board.length-1;
        int obstacle = -1;

        //Reconocer hacia adelante
        while(corY<=verify && corY>0){
            if(board[corX][corY] != null){
                obstacle = corY;
                break;
            }
            corY--;
        }
        return obstacle;
    }
    //Espacios hacia atras
    public int recognizeSpacesAt(int corX, int corY){
        Piece[][] board = boardInstance.getBoard();

        int verify = board.length-1;
        int obstacle = -1;

        //Reconocer hacia atras
        while(corY<=verify){
            if(board[corX][corY] != null){
                obstacle = corY;
                break;
            }
            corY++;
        }
        return obstacle;
    }
    //Espacios hacia la izquierda
    public int recognizeSpacesLe(int corX, int corY){
        Piece[][] board = boardInstance.getBoard();

        int verify = board.length-1;
        int obstacle = -1;

        //Reconocer hacia Izquierda
        while(corY<=verify && corY> 0){
            if(board[corX][corY] != null){
                obstacle = corY;
                break;
            }
            corY--;
        }
        return obstacle;
    }
    //Espacios hacia la derecha
    public int recognizeSpacesRi(int corX, int corY){
        Piece[][] board = boardInstance.getBoard();

        int verify = board.length-1;
        int obstacle = -1;
        //Reconocer hacia derecha
        while(corY<=verify){
            if(board[corX][corY] != null){
                obstacle = corY;
                break;
            }
            corY++;
        }
        return obstacle;
    }


}