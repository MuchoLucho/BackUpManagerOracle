package PACKAGES;

public class Executor {

    public static Runnable executeStrategy(Strategy str) {
       return ()->{
           System.out.println("EXECUTING THE FOLLOWING RMAN COMMAND: "+ str.getRmanString());
       };
    }

}