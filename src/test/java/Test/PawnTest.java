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
        Pawn pawB = new Pawn(true, "pawn", 2, 3);
        // Test para que no se mueva mas de dos cuadros en su posicion inicial
        assertEquals("ERROR [Movimiento invalido para esta posicion]", pawn.verifyMovement(1, 5, true, board));
        //Test para que no se mueva mas de un cuadro si no esta en su posicion inicial
        assertEquals("ERROR [Movimiento no permitido]", pawB.verifyMovement(2, 5, true, board));
        // Test para que no se mueva a una casilla vacia a la derecha o a la izquierda
        assertEquals("ERROR [Movimiento imposible]", pawn.movePiece(3, 3, true, board));
        // Test para que el peon no retroceda
        assertEquals("ERROR [No puedes retroceder]", pawn.movePiece(1, 1, true, board));
        // Test para que el peon no se mueva en diagonal si no hay enemigos
        assertEquals("ERROR [Movimiento imposible]", pawn.movePiece(2, 3, true, board));
    }
    @Test
    public void KillTest(){
        Piece[][] board = new Piece[8][8];
        Pawn pawnA = new Pawn(true, "pawnA", 2, 1);
        Pawn pawnB = new Pawn(true, "pawnB", 1, 2);
        Pawn pawnC = new Pawn(false, "pawnC", 3, 2);
        Pawn pawnD = new Pawn(false, "pawnD", 1, 7);
        board[1][2] = pawnB;
        board[3][2] = pawnC;
        board[1][7] = pawnD;
        // Test para que no mate a su propio equipo
        assertEquals("ERROR [No puedes matar a tu propio equipo]", pawnA.movePiece(1, 2, true, board));
        //Test para que mate piezas de otro color
        assertEquals("true", pawnA.movePiece(3, 2, false, board));
        //Test para que no mate diagonalmente a larga distancia
        assertEquals("ERROR [No te puedes  mover de esta manera]", pawnA.movePiece(1, 7, true, board));
    }


}
   