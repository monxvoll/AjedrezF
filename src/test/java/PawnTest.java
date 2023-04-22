import org.junit.Test;

import Logic.Pawn;
import junit.framework.Assert;

public class PawnTest {
    Pawn newPawnTest = new Pawn();
    @Test
    public void verifyMovementTest(){
        
        boolean esperado = newPawnTest.verifyMovement(1, 4, true);
        Assert.assertEquals(true, esperado);
    }
    
    
    @Test
    public void verifyMovementTestT(){
        
        boolean esperado = newPawnTest.verifyMovement(1, 4, false);
        Assert.assertEquals(false, esperado);
    }

    @Test
    public void sumaTest(){
        
        int esperado = newPawnTest.suma(3, 3);
        Assert.assertEquals(7,esperado);

    }

}
