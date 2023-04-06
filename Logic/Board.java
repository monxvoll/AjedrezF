package Logic;

public class Board {


    private Piece[][] board;

    //Queens
    public Piece[][] AssingnQueen(Piece[][] board) {
        board[5][1] = new Queen(true, "Q", 5, 1);
        board[5][8] = new Queen(false, "Q", 5, 8);
        return board;
    }

    //Kings
    public Piece[][] AssingnKings(Piece[][] board) {
        board[4][1] = new King(true, "K", 4, 1);
        board[4][8] = new King(false, "K", 4, 8);
        return board;
    }

    //Pawns
    public Piece[][] AssingnsPawns(Piece[][] board) {
        for (int i = 1; i < 9; i++) {
            board[i][2] = new Pawn(true, "P", i, 2);
            board[i][7] = new Pawn(false, "P", i, 7);
        }
        return board;
    }

    //Knight
    public Piece[][] AssingnsKnight(Piece[][] board) {
        board[2][1] = new Knight(true, "C", 2, 1);
        board[7][1] = new Knight(true, "C", 7, 1);
        board[2][8] = new Knight(false, "C", 2, 8);
        board[7][8] = new Knight(false, "C", 7, 8);
        return board;
    }

    //Bishops, Alfil
    public Piece[][] AssingnsBishops(Piece[][] board) {
        board[3][1] = new Bishop(true, "A", 4, 1);
        board[6][1] = new Bishop(true, "A", 6, 1);
        board[3][8] = new Bishop(false, "A", 3, 8);
        board[6][8] = new Bishop(false, "A", 6, 8);
        return board;
    }

    //Rooks
    public Piece[][] AssingnsRooks(Piece[][] board) {
        board[1][1] = new Rook(true, "T", 1, 1);
        board[8][1] = new Rook(true, "T", 8, 1);
        board[1][8] = new Rook(false, "T", 1, 8);
        board[8][8] = new Rook(false, "T", 8, 8);
        return board;
    }

    /*public void idetifyPiece(int cordX, int cordY, double color) {
        Piece type;
        type = getPiece(cordX, cordY);
        switch (type.getName()) {
            case "T":
                Rook newRook = new Rook();
                newRook.movePiece(cordX, cordY, color);
                break;
            case "A":
                Bishop newBishop = new Bishop();
                newBishop.movePiece(cordX, cordY, color);
                break;
            case "C":
                Knight newKnight = new Knight();
                newKnight.movePiece(cordX, cordY, color);
                break;
            case "Q":
                Queen newQueen = new Queen();
                newQueen.movePiece(cordX, cordY, color);
                break;
            case "K":
                King newKing = new King();
                newKing.movePiece(cordX, cordY, color);
                break;
            case "P":
                Pawn newPawn = new Pawn();
                newPawn.movePiece(cordX, cordY, color);
                break;
        }
    }*/

    public Piece getPiece(int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return null;
        }
        return board[x][y];
    }
    
    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public Board() {
        board = new Piece[9][9];
        AssingnKings(board);
        AssingnQueen(board);
        AssingnsBishops(board);
        AssingnsKnight(board);
        AssingnsPawns(board);
        AssingnsRooks(board);
    }

    public static void main(String[] args) {

        
        /*Board tablero = new Board();
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
        }*/
    }
}
