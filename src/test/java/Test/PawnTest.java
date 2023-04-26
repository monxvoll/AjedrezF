package Test;

import Logic.Pawn;
import Logic.Piece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    public void MovementTest() {
        Piece[][] board = new Piece[8][8];
        Pawn pawn = new Pawn(true, "pawn", 1, 2);
        // Test para que no se mueva mas de dos cuadros
        assertEquals("ERROR [Movimiento invalido para esta posicion]", pawn.verifyMovement(1, 5, true, board));
        // Test para que no se mueva a una casilla vacia a la derecha o a la izquierda
        assertEquals("ERROR [Movimiento imposible]", pawn.movePiece(3, 3, true, board));
        // Test para que el peon no retroceda
        assertEquals("ERROR [No puedes retroceder]", pawn.movePiece(1, 1, true, board));
        // Test para que el peon no se mueva en diagonal
        assertEquals("ERROR [Movimiento imposible]", pawn.movePiece(2, 3, true, board));

    }
    @Test
    public void KillTest(){
        Piece[][] board = new Piece[8][8];
        Pawn pawnA = new Pawn(true, "pawnA", 1, 2);
        Pawn pawnB = new Pawn(true, "pawnB", 1, 3);
        board[1][3] = pawnB;
        // Test para que no mate a su propio equipo
        assertEquals("ERROR [No puedes matar a tu propio equipo]", pawnA.movePiece(1, 3, true, board));
    }


}
   