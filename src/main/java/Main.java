import org.junit.Assert;
import org.junit.Test;

public class Main {

    @Test
    public void test1(){
        Assert.assertTrue(true);
        System.out.println(DB.selectCustomerId("654010381111"));
    }

}
