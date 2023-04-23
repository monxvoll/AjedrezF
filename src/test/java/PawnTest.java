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
        
        boolean actual = newPawnTest.verifyMovement(1, 4, false);
        Assert.assertEquals(false, actual);
    }

}
