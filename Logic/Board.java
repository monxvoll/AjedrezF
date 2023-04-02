package Logic;

public class Board {


    private Piece[][] board;

    //Queens
    public Piece[][] AssingnQueen(Piece[][] board) {
        board[5][1] = new Queen(true, "♛", 5, 1);
        board[5][8] = new Queen(false, "♕", 5, 8);
        return board;
    }

    //Kings
    public Piece[][] AssingnKings(Piece[][] board) {
        board[4][1] = new King(true, "♚", 4, 1);
        board[4][8] = new King(false, "♔", 4, 8);
        return board;
    }

    //Pawns
    public Piece[][] AssingnsPawns(Piece[][] board) {
        for (int i = 1; i < 9; i++) {
            board[i][2] = new Pawn(true, "♙", i, 2);
            board[i][7] = new Pawn(false, "♟", i, 7);
        }
        return board;
    }

    //Knight
    public Piece[][] AssingnsKnight(Piece[][] board) {
        board[2][1] = new Knight(true, "♞", 3, 1);
        board[7][1] = new Knight(true, "♞", 7, 1);
        board[2][8] = new Knight(false, "♘", 2, 8);
        board[7][8] = new Knight(false, "♘", 7, 8);
        return board;
    }

    //Bishops, Alfil
    public Piece[][] AssingnsBishops(Piece[][] board) {
        board[3][1] = new Bishop(true, "♝", 4, 1);
        board[6][1] = new Bishop(true, "♝", 6, 1);
        board[3][8] = new Bishop(false, "♗", 3, 8);
        board[6][8] = new Bishop(false, "♗", 6, 8);
        return board;
    }

    //Rooks
    public Piece[][] AssingnsRooks(Piece[][] board) {
        board[1][1] = new Rook(true, "♜", 1, 1);
        board[8][1] = new Rook(true, "♜", 8, 1);
        board[1][8] = new Rook(false, "♖", 1, 8);
        board[8][8] = new Rook(false, "♖", 8, 8);

        return board;
    }
    public Piece[][] AssingnsBlocks(Piece[][] board) {
        board[1][3] = new Block(true, "⬜", 1, 3);
        board[1][4] = new Block(true, "⬛", 1, 4);
        board[1][5] = new Block(false, "⬜", 1, 5);
        board[1][6] = new Block(false, "⬛", 1, 6);

        board[2][3] = new Block(true, "⬛", 2, 3);
        board[2][4] = new Block(true, "⬜", 2, 4);
        board[2][5] = new Block(false, "⬛", 2, 5);
        board[2][6] = new Block(false, "⬜", 2, 6);

        board[3][3] = new Block(true, "⬜", 3, 3);
        board[3][4] = new Block(true, "⬛", 3, 4);
        board[3][5] = new Block(false, "⬜", 3, 5);
        board[3][6] = new Block(false, "⬛", 3, 6);

        board[4][3] = new Block(true, "⬛", 4, 3);
        board[4][4] = new Block(true, "⬜", 4, 4);
        board[4][5] = new Block(false, "⬛", 4, 5);
        board[4][6] = new Block(false, "⬜", 4, 6);

        board[5][3] = new Block(true, "⬜", 5, 3);
        board[5][4] = new Block(true, "⬛", 5, 4);
        board[5][5] = new Block(false, "⬜", 5, 5);
        board[5][6] = new Block(false, "⬛", 5, 6);

        board[6][3] = new Block(true, "⬛", 6, 3);
        board[6][4] = new Block(true, "⬜", 6, 4);
        board[6][5] = new Block(false, "⬛", 6, 5);
        board[6][6] = new Block(false, "⬜", 7, 6);

        board[7][3] = new Block(true, "⬜", 7, 3);
        board[7][4] = new Block(true, "⬛", 7, 4);
        board[7][5] = new Block(false, "⬜", 7, 5);
        board[7][6] = new Block(false, "⬛", 7, 6);

        board[8][3] = new Block(true, "⬛", 8, 3);
        board[8][4] = new Block(true, "⬜", 8, 4);
        board[8][5] = new Block(false, "⬛", 8, 5);
        board[8][6] = new Block(false, "⬜", 8, 6);



        return board;
    }

    public Piece getPiece(int cordX, int cordY) {
        Piece movement;
        movement = board[cordX][cordY];
        return movement;
    }

    public void idetifyPiece(int cordX, int cordY) {
        Piece type;
        type = getPiece(cordX, cordY);
        switch (type.getName()) {
            case "T":
                Rook newRook = new Rook();
                newRook.movePiece(cordX, cordY);
                break;
            case "A":
                Bishop newBishop = new Bishop();
                newBishop.movePiece(cordX, cordY);
                break;
            case "C":
                Knight newKnight = new Knight();
                newKnight.movePiece(cordX, cordY);
                break;
            case "Q":
                Queen newQueen = new Queen();
                newQueen.movePiece(cordX, cordY);
                break;
            case "K":
                King newKing = new King();
                newKing.movePiece(cordX, cordY);
                break;
            case "P":
                Pawn newPawn = new Pawn();
                newPawn.movePiece(cordX, cordY);
                break;
        }


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
        AssingnsBlocks(board);
    }

    public void showBoard() {
        Board tablero = new Board();
        Piece[][] pieza = new Piece[9][9];

        tablero.AssingnsRooks(pieza);
        tablero.AssingnsBishops(pieza);
        tablero.AssingnQueen(pieza);
        tablero.AssingnsKnight(pieza);
        tablero.AssingnsPawns(pieza);
        tablero.AssingnKings(pieza);
        tablero.AssingnsBlocks(pieza);


        char c = 'A';
        for (int i = 0; i < 9; i++) {
            System.out.print(i);
            for (int j = 0; j < 9; j++) {
                if (pieza[j][i] != null) {

                    System.out.print(pieza[j][i].getName() + "\t");
                } else if (j == 0) {
                    System.out.print("\t");
                } else if (i == 0) {
                    System.out.print(c + "\t");
                    c = ++c;
                } else  {
                    System.out.print(" \t");
                }
            }
             System.out.println();
        }
    }
}
