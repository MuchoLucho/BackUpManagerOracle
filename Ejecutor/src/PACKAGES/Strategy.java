/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACKAGES;

/**
 *
 * @author Javier
 */
public class Strategy {

    private String cronString = "* * * * *";
    private String name = "EC00001";
    private String rmanString = "rman blablabla";
    private String cronID = null;
    private boolean active = true;

    public Strategy(String name, String cron, String rman) {
        this.cronString = cron;
        this.name = name;
        this.rmanString = rman;
    }

    public String getCronString() {
        return cronString;
    }

    public void setCronString(String cronString) {
        this.cronString = cronString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRmanString() {
        return rmanString;
    }

    public void setRmanString(String rmanString) {
        this.rmanString = rmanString;
    }

    public String getCronID() {
        return cronID;
    }

    public void setCronID(String cronID) {
        this.cronID = cronID;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(name).append(" ").append(cronString).append(" ").append(rmanString).append(" ").toString();
    }

}
