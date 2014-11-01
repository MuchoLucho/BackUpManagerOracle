package PACKAGES;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Reader {

    public static Object[][] toTableModel(String str) {
        int i = 0;
         i=0;
        Object[] aux = readFiles(str).toArray();
        Object[] dummy;
        Object[][] ret = new Object[aux.length][5];
        for (Object o : aux) {
            dummy = (Object[]) o;
            ret[i++] = new Object[]{(String) dummy[0], (String) dummy[1], (String) dummy[2], (String) dummy[3], dummy[4].equals("true")};
        }
        return ret;
    }
       
    private static List<String[]> readFiles(String str) {
        List<String[]> tb = new ArrayList();
        listFiles().stream().forEach((File f) -> {
            try {
                Files.lines(f.toPath()).forEach((String s) -> {
                    if (s.contains(str)) {
                        tb.add(s.split("\t"));
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return tb;
    }
    
    private static List<File> listFiles() {
        List<File> filesInFolder = null;
        try {
           filesInFolder = Files.walk(Paths.get("./bkup_files"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filesInFolder;
    }
}
