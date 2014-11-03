package PACKAGES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DBManager {

    /*Locally used*/
    public static ArrayList<String> tablespaces() {
        sql = "select tablespace_name \"TS\" from user_tablespaces";
        ArrayList<String> TS = new ArrayList();
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String ts = rs.getString("TS");
                TS.add(ts);
            }
        } catch (SQLException ex) {
        }
        return TS;
    }

    /*For Database Links*/
    public static ArrayList<String> tablespaces(String dblink) {
        sql = "select tablespace_name \"TS\" from user_tablespaces@" + dblink;
        ArrayList<String> TS = new ArrayList();
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String ts = rs.getString("TS");
                TS.add(ts);
            }
        } catch (SQLException ex) {
        }
        return TS;
    }

    public static boolean conectDB(String username, String pass, String hostName, String port, String SID) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:" + port + ":" + SID, username, pass);
        } catch (SQLException | ClassNotFoundException ex) {
            return false;
        }
        return true;
    }

    public static boolean llenado() {
        if (conectDB("narf", "narf", "localhost", "1521", "BD1")) {            
            sql = "select db_link,host from all_db_links";
            String db_name;
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    db_name = rs.getString("db_link");
                    dbs.put(db_name, new DB(db_name, rs.getString("host"), tablespaces(db_name)));
                }                
            } catch (SQLException ex) {
                return false;
            }
            dbs.put("Local", new DB("Local", "localhost", tablespaces()));
            return true;
        } else {
            return false;
        }
    }

    public static HashMap<String, DB> getDbs() {
        return dbs;
    }

    private static Connection con = null;
    private static PreparedStatement pst;
    private static ResultSet rs;
    private static String sql;
    private static final HashMap<String, DB> dbs = new HashMap();
}
