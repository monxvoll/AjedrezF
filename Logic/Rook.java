package Logic;

public class Rook extends Piece{
    //Instancia para acceder a Board arreglo
    Board boardInstance ;

    //Instancia de Piece
    Piece whichPiece;

    //Constructor
    public Rook(boolean color, String name, int ubicationX, int ubicationY) {
        super(color, name, ubicationX, ubicationY);
    }
    public Rook(){

    }
    //Metodos

    //Mover General
    @Override
    public void movePiece(int corX, int corY, Boolean color ) {
        Piece[][] board = boardInstance.getBoard();

        if(color){
            if(verifyRange(corX, corY)){
            
                if(recognizeSpacesA(corX, corY) != -1||recognizeSpacesAt(corX, corY) != -1||recognizeSpacesLe(corX, corY) != -1|| recognizeSpacesRi(corX, corY) != -1){
                    int cordA = recognizeSpacesA(corX, corY);
                    int cordAt = recognizeSpacesAt(corX, corY);
                    int cordLe = recognizeSpacesLe(corX, corY);
                    int cordRi = recognizeSpacesRi(corX, corY);
                    Piece piece = boardInstance.getPiece(cordA, corY); 
                    boolean colorInterference = piece.getColor();
                }
            }else{

            }  
        }else{

        }
    }
    //Espacios hacia adelante
    public int recognizeSpacesA(int corX, int corY){
        Piece[][] board = boardInstance.getBoard();

        int verify = board.length-1;
        int obstacle = -1;

        //Reconocer hacia adelante
        while(corX<=verify){
            if(board[corX][corY] != null){
                obstacle = corX;
                break;
            }
            corX--;
        }
        return obstacle;
    }
    //Espacios hacia atras
    public int recognizeSpacesAt(int corX, int corY){
        Piece[][] board = boardInstance.getBoard();

        int verify = board.length-1;
        int obstacle = -1;

        //Reconocer hacia atras
        while(corX<=verify){
            if(board[corX][corY] != null || corX<verify){
                obstacle = corX;
                break;
            }
            corX++;
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