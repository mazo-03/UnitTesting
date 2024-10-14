package test;

import main.BasicUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BasicUtilsTest {
    @Test
    public void reversingArbitraryStringProducesCorrectResult() {
        //checks whether second arg equals the first one
        Assertions.assertEquals(
                "txet modnar", BasicUtils.reversed("random text")
        );
        Assertions.assertEquals(
                "bd#sa6f3basż;", BasicUtils.reversed(";żsab3f6as#db")
        );
    }
    @Test
    public void reversingNullReturnsNull() {
        Assertions.assertNull(BasicUtils.reversed(null));
    }
}
