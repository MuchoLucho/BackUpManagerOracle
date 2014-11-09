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
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        sql = "select tablespace_name \"TS\" from user_tablespaces";
        ArrayList<String> TS = new ArrayList();
        String ts;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ts = rs.getString("TS");
                if (!ts.equals("TEMP")) {
                    TS.add(ts);
                }
            }
        } catch (SQLException ex) {
            
        }
        return TS;
    }

    /*For Database Links*/
    public static ArrayList<String> tablespaces(String dblink) {
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        sql = "select tablespace_name \"TS\" from user_tablespaces@" + dblink;
        ArrayList<String> TS = new ArrayList();
        String ts;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ts = rs.getString("TS");
                if (!ts.equals("TEMP")) {
                    TS.add(ts);
                }
            }
        } catch (SQLException ex) {
        }
        return TS;
    }

    /*Retrieves the real name of the database*/
    public static String databaseName(String db_link) {
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        if (connectDB()) {
            sql = "select name from v$database@" + db_link;
            String db_name = "XE";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    db_name = rs.getString("name");
                }
                return db_name;
            } catch (SQLException ex) {
                return "XE";
            }
        } else {
            return "XE";
        }
    }

    public static boolean connectDB() {
        Parameters.configureDB();
        return connectDB(Parameters.dbusername, Parameters.dbpassword, "localhost", Parameters.dbport, Parameters.dbInstance);
    }

    public static boolean connectDB(String username, String pass, String hostName, String port, String SID) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:" + port + ":" + SID, username, pass);
        } catch (SQLException | ClassNotFoundException ex) {
            return false;
        }
        return true;
    }

    public static boolean llenado() {
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        if (connectDB()) {
            sql = "select db_link from all_db_links";
            String db_link;
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    db_link = rs.getString("db_link");
                    dbs.put(db_link, new DB(db_link, databaseName(db_link), tablespaces(db_link)));
                }
            } catch (SQLException ex) {
                return false;
            }
            dbs.put("Local", new DB("Local", "localhost", tablespaces()));
            Parameters.configureNodes();//-------------------------------------------------------------------------------------------------
            return true;
        } else {
            return false;
        }
    }

    public static HashMap<String, DB> getDbs() {
        return dbs;
    }

    public static String getNameFromDB(String db_link) {
        return dbs.get(db_link).getHost();
    }

    /*Variables*/
    private static Connection con = null;
    private static final HashMap<String, DB> dbs = new HashMap();
}
