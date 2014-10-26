package PACKAGES;

import javax.swing.table.DefaultTableModel;

public class Manager {

    public Manager() {
        modelo = new DefaultTableModel(null, ar);
    }
    
    public String[] ar = {"a", "b"};
    public DefaultTableModel modelo;

    public static void main(String[] args) {
    }

}
