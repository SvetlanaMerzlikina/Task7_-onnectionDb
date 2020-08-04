import org.junit.Assert;
import org.junit.Test;

public class Main {

    @Test
    public void test1(){
        Assert.assertTrue(true);
        System.out.println(DB.selectCustomerId("654010381111"));
        System.out.println("Склонность к оттоку: ");
        System.out.println(DB.selectTitle(209177052, ""));
        System.out.println(DB.selectObjId(209177052));
        DB.updateObjId(209177052, 5911);
        System.out.println(DB.selectObjId(209177052));

    }

}
