package Test;

import Logic.Knight;
import Logic.Piece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class KnightTest {
    @Test
    public void MovementTest() {
        Piece[][] board = new Piece[8][8];
        Knight knight = new Knight(true, "knight", 2, 1);
        //Test para que el caballo solo se mueva en L
        assertEquals("ERROR [El movimiento no cumple las reglas del ajedrez]",knight.movePiece(2, 3, true, board));
    }
    @Test
    public void KillTest(){
        Piece[][] board = new Piece[8][8];
        Knight knightA = new Knight(true, "knightA", 2, 1);
        Knight knightB = new Knight(true, "knightB", 3, 3);
        board[3][3]=knightB;
        //Test para que no mate a su propio equipo
        assertEquals("ERROR [No te puedes comer a ti mismo]", knightA.movePiece(3, 3, true, board));
    }
    
}
