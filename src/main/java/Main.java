import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class Main {

    private static final String FA_ID = "654010381111";
    private static final String OBJID_YES = "5911";
    private static final String OBJID_NO = "5912";


    @Test
    public void test1(){

        System.out.println("Номер Objid: " + DB.selectCustomerId(FA_ID));
        String customerId = DB.selectCustomerId(FA_ID);
        HashMap<String, String> ObjidTitle = DB.selectObjId(customerId);
        System.out.println("Склонность к оттоку до изменений: " + ObjidTitle.get("title"));
        if(ObjidTitle.get("objid").equals(OBJID_YES))
            DB.updateObjId((customerId), OBJID_NO);
        else DB.updateObjId((customerId), OBJID_YES);
        System.out.println("Склонность к оттоку после изменений: " + DB.selectObjId(customerId).get("title"));

    }

}
