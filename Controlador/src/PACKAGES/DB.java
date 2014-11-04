package PACKAGES;

import java.io.Serializable;
import java.util.ArrayList;

public class DB implements Serializable {

    public DB(String link_name, String db_name, ArrayList<String> tbs) {
        this.link_name = link_name;
        this.db_name = db_name;
        this.tablespaces = tbs;
    }

    public String getLink_name() {
        return link_name;
    }

    public String getHost() {
        return db_name;
    }

    public ArrayList<String> getTablespaces() {
        return tablespaces;
    }   
    
    private final String link_name;
    private final String db_name;
    private final ArrayList<String> tablespaces;
}
