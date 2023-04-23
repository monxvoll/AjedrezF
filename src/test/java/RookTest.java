import org.junit.Assert;
import org.junit.Test;

import Logic.Rook;

public class RookTest {
    Rook rooktest = new Rook();
    @Test
    public void verifyMovementTest(){
        
        boolean actual = rooktest.verifyMovement(1, 4, true);
        Assert.assertEquals(false, actual);
    }

}
