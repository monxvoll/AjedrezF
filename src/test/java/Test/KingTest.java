package Test;
import Logic.King;
import Logic.Piece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class KingTest {
    @Test
    public void MovementTest() {
        Piece[][] board = new Piece[8][8];
        King king = new King(true, "king", 4, 1);
       //Test para que el rey solo se mueva un cuadro
        assertEquals("ERROR [Movimiento no valido segun las reglas del ajedrez]",king.movePiece(4,3,true,board));
    }
    @Test
    public void KillTest(){
        Piece[][] board = new Piece[8][8];
        King kingA = new King(true, "kingA", 4, 1);
        King kingB = new King(true, "kingB", 4, 2);
        board[4][2]=kingB;
        //Test para que no mate a su propio equipo
        assertEquals("ERROR [No te puedes comer a ti mismo]", kingB.movePiece(4, 2, true, board));
    }
}
