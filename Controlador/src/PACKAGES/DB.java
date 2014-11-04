package PACKAGES;

import java.io.Serializable;
import java.util.ArrayList;

public class DB{

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
    
    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getLinux_user() {
        return linux_user;
    }

    public void setLinux_user(String linux_user) {
        this.linux_user = linux_user;
    }
    
    private final String link_name;
    private final String db_name;
    private String IP="127.0.0.1";
    private String linux_user="luiska";
    private final ArrayList<String> tablespaces;

 
}
