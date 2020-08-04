import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

    static String  driver = "oracle.jdbc.driver.OracleDriver";
    static String url = "jdbc:oracle:thin:@10.28.43.13:1521:CRMTEST";
    static String user = "smerzlikina";
    static String password = "Konstantin91";

        public static String selectCustomerId(String faId) {
            String query = "select tc.s_customer_id\n" +
                    "  from table_customer tc\n" +
                    "  join table_con_fin_accnt_role con\n" +
                    "    on tc.objid = con.fa_role2customer\n" +
                    "  join table_fin_accnt fa\n" +
                    "    on con.fin_accnt_role2fin_accnt = fa.objid\n" +
                    " where fa.s_fa_id = '" + faId + "'";
            String customerId = "";
            try (Connection con = getConnection();
                 PreparedStatement statement = con.prepareStatement(query);
                 ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    customerId = result.getString(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return customerId;
        }

    public static String selectObjId(int Objid) {
        String query = "select hg.objid, hg.title\n" +
                "  from table_customer tc\n" +
                "  join table_hgbst_elm hg\n" +
                "    on tc.x_propensity_drain2hgbst_elm = hg.objid\n" +
                " where tc.s_customer_id = '" + Objid + "'";
        String objid = "";
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(query);
             ResultSet result = statement.executeQuery()) {
            while (result.next()) {
                objid = result.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objid;
    }

    public static String selectTitle(int objid, String Title) {
        String query = "select hg.objid, hg.title\n" +
                "  from table_customer tc\n" +
                "  join table_hgbst_elm hg\n" +
                "    on tc.x_propensity_drain2hgbst_elm = hg.objid\n" +
                " where tc.s_customer_id = '" + objid + "'";
        String title = "";
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(query);
             ResultSet result = statement.executeQuery()) {
            while (result.next()) {
                title = result.getString(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return title;
    }

    public static void updateObjId(int objid, int newObjidTitle) {
        String query = "update table_customer\n" +
                "   set x_propensity_drain2hgbst_elm = '" + newObjidTitle +"'\n" +
                " where s_customer_id = '" + objid + "'";
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
             statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        //  Connection con = null;
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    }


