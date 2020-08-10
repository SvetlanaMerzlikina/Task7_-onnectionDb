import org.junit.Assert;
import org.junit.Test;

public class Main {


    @Test
    public void test1(){

        System.out.println(DB.selectCustomerId(DB.selectCustomerId("faId")));
        System.out.println(DB.selectObjId(DB.selectCustomerId("faId")));
        String newObjidTitle;
        if (DB.selectObjId(DB.selectCustomerId("faId")).get("objid").equals("5911"))
            newObjidTitle = "5912";
        else newObjidTitle = "5911";
        DB.updateObjId(DB.selectCustomerId("faId"),newObjidTitle);
        System.out.println(DB.selectObjId(DB.selectCustomerId("faId")));

    }

}
