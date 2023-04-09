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
    

    //Metodo mover pieza
    public Piece[][] movePiece(int cordX, int cordY, int newCordX, int newCordY, Piece type, boolean color){
        Piece[][]boards = new Piece[9][9];
        if (type != null) {
            if (type.getColor() != color) {
                System.out.println("No es el turno del jugador");
                return null;
            }
    
            if (type.movePiece(newCordX, newCordY, color)) {
                System.out.println("Turno: "+type.getColor());
                System.out.println("Pieza identificada: " + type.getName());
                System.out.println("Coordenada de la pieza x: "+ cordX+" y: "+cordY);
                System.out.println("Coordenada de la pieza en su nueva ubicacionx: "+ newCordX+" y: "+newCordY);
                boards = getBoard();
                boards[newCordX][newCordY] = type;
                boards[cordX][cordY] = null;
                setBoard(boards);
            }
    
        }
        
        return getBoard();
    }

}
