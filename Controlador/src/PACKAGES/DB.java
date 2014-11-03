package PACKAGES;

import java.io.Serializable;
import java.util.ArrayList;

public class DB implements Serializable {

    public DB(String link_name, String host, ArrayList<String> tbs) {
        this.link_name = link_name;
        this.host = host;
        this.tablespaces = tbs;
    }

    public String getLink_name() {
        return link_name;
    }

    public String getHost() {
        return host;
    }

    public ArrayList<String> getTablespaces() {
        return tablespaces;
    }   
    
    private final String link_name;
    private final String host;
    private final ArrayList<String> tablespaces;
}
