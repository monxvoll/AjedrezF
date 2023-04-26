package Test;
import Logic.Piece;
import Logic.Rook;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RookTest {
    @Test
    public void MovementTest() {
        Piece[][] board = new Piece[8][8];
        Rook rookA = new Rook (true, "rookA", 1, 1);
        //Test para que no se mueva si el movimiento no es V u H
        assertEquals("ERROR [No te estas moviendo horizontal ni verticalmente]",rookA.movePiece(2,3,true,board));
    }
    @Test
    public void KillTest(){
        Piece[][] board = new Piece[8][8];
        Rook rookA = new Rook (true, "rookA", 1, 1);
        Rook rookB = new Rook (true, "rookA", 1, 5);
        board[1][5]=rookB;
        //Test para que no mate a su propio equipo
        assertEquals("ERROR [No te puedes comer a ti mismo]", rookA.movePiece(1, 5, true, board));
    }
    public void OthersTest(){
        Piece[][] board = new Piece[8][8];
        Rook rookA = new Rook (true, "rookA", 1, 1);
        Rook rookB = new Rook (true, "rookA", 1, 5);
        Rook rookC = new Rook (true, "rookA", 3, 1);
        board[1][5]=rookB;
        board[3][1]=rookC;
        //Test para que no salte piezas verticalmente
        assertEquals("ERROR [Movimiento vertical, no puedes mover, hay una pieza en tu camino que te obstruye]", rookA.movePiece(1, 6, true, board));
        //Test para que no salte piezas horizontalmente
        assertEquals("ERROR [Movimiento horizontal, no puedes mover, hay una pieza en tu camino que te obstruye]", rookA.movePiece(3, 2, true, board));
    }

}
