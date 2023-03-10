package Logic;

public class Board {
    private Piece [][] board;
    //Queens
    public Piece[][] AssingnQueen(Piece[][] board){
        board[5][8] = new Queen(true,"QW",5,8);
        board[5][1] = new Queen(false,"QB",5,1);
        return board;
    }
    //Kings
    public Piece[][] AssingnKings(Piece[][] board){
        board[4][8] = new King(true,"KW",4,8);
        board[4][1] = new King(false,"KB",4,1);
        return board;
    }
    //Pawns
    public Piece[][] AssingnsPawns(Piece[][] board){
        for(int i = 1; i<9;i++){
            board[i][2] = new Pawn(true,"PB",i,2);
            board[i][7] = new Pawn(false,"PW",i,7);
        }
        return board;
    }
    //Knight
    public Piece[][] AssingnsKnight(Piece[][] board){
        board[2][1] = new Knight(true,"CB",3,1);
        board[7][1] = new Knight(true,"CB",7,1);
        board[2][8] = new Knight(false,"CW",2,8);
        board[7][8] = new Knight(false,"CW",7,8);
        return board;
    }

    //Bishops, Alfil
    public Piece[][] AssingnsBishops(Piece[][] board){
        board[3][1] = new Bishop(true,"AB",4,1);
        board[6][1] = new Bishop(true,"AB",6,1);
        board[3][8] = new Bishop(false,"AW",3,8);
        board[6][8] = new Bishop(false,"AW",6,8);
        return board;
    }
    //Rooks
    public Piece[][] AssingnsRooks(Piece[][] board){
        board[1][1] = new Rook(true,"TB",1,1);
        board[8][1] = new Rook(true,"TB",8,1);
        board[1][8] = new Rook(false,"TW",1,8);
        board[8][8] = new Rook(false,"TW",8,8);

        return board;

    }

    public Board(){
        board = new Piece[9][9];
        AssingnKings(board);
        AssingnQueen(board);
        AssingnsBishops(board);
        AssingnsKnight(board);
        AssingnsPawns(board);
        AssingnsRooks(board);
    }

    public static void main(String[] args) {

        Board tablero = new Board();
        Piece[][] pieza = new Piece[9][9];

        tablero.AssingnsRooks(pieza);
        tablero.AssingnsBishops(pieza);
        tablero.AssingnQueen(pieza);
        tablero.AssingnsKnight(pieza);
        tablero.AssingnsPawns(pieza);
        tablero.AssingnKings(pieza);
        char c = 'A';
            for (int i = 0; i < 9; i++){
                System.out.print(i);
                for (int j = 0; j < 9 ; j++){
                    if(pieza[j][i] != null) {

                        System.out.print(pieza[j][i].getName()+"\t");
                    } else if (j==0) {
                        System.out.print("\t");
                    } else if (i==0) {
                        System.out.print(c+"\t");
                        c=++c;
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
    }
}
