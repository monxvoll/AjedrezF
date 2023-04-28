package Test;
import Logic.Bishop;
import Logic.Piece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class BishopTest {
    @Test
    public void MovementTest() {
        Piece[][] board = new Piece[8][8];
        Bishop bishop = new Bishop(true, "bishop", 3, 1);
        //Test para que solo se mueva diagonalmente
        assertEquals("ERROR [Movimiento no valido, movimiento no diagonal]",bishop.movePiece(3,3,true,board));
    }
    @Test
    public void KillTest(){
        Piece[][] board = new Piece[8][8];
        Bishop bishopA = new Bishop(true, "bishopA", 3, 1);
        Bishop bishopB = new Bishop(true, "bishopB", 2, 2);
        board[2][2]=bishopB;
        //Test para que no mate a su propio equipo
        assertEquals("ERROR [No te puedes comer a ti mismo]", bishopA.movePiece(2, 2, true, board));
    }
    public void OthersTest(){
        Piece[][] board = new Piece[8][8];
        Bishop bishopA = new Bishop(true, "bishopA", 3, 1);
        Bishop bishopB = new Bishop(true, "bishopB", 2, 2);
        Bishop bishopC = new Bishop(false, "bishopC", 4, 3);
        board[2][2]=bishopB;
        board[4][3]=bishopB;
        //Test para que no salte piezas
        assertEquals("ERROR [No puedes mover, hay una pieza en tu camino que te obstruye]", bishopA.movePiece(1, 3, true, board));
        //Test para que mate piezas de otro color
        assertEquals("true", bishopA.movePiece(4, 3, true, board));
    }
}
