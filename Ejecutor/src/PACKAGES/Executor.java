package PACKAGES;

import java.util.Date;

public class Executor {

    public static Runnable executeSampleStrategy(Strategy str) {
       return ()->{
           System.out.println("EXECUTING THE FOLLOWING RMAN COMMAND: "+ str.getRmanString());
           LogsGenerator.generateSampleLog(true,new Date(), str);
       };
    }

}