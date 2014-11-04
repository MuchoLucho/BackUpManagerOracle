package PACKAGES;

import it.sauronsoftware.cron4j.SchedulerListener;
import java.util.Date;

public class ExecutorBuilder{

    public static Runnable executeSampleStrategy(Strategy str) {
       return ()->{
           System.out.println("EXECUTING THE FOLLOWING RMAN COMMAND: "+ str.getRmanString());
           LogsGenerator.generateSampleLog(true,new Date(), str);
       };
    }
    public static Runnable executeStrategy(Strategy str) {
       return ()->{
           System.err.println("*********RUNNING THE"+str.getName()+" STRATEGY***********");
           StrategyExecutor exe = new StrategyExecutor();
           boolean success = exe.executeRMANFile(str.getRmanString());
           System.out.println("EXECUTION OF RMAN SCRIPT : "+ str.getRmanString()+" "+((success)?"SUCCEEDED":"FAILED"));
           String logFile = LogsGenerator.generateLog(success,new Date(), str);
           boolean logSent = exe.sendResultLog(logFile);
           if(!logSent){
               System.err.println("***FAILURE SENDING LOGFILE "+logFile+" to mothership!!!");
           }
           else{
               System.err.println("LOG SENT returned success");
           }
       };
    }
}

/*
public class Quickstart {

    static int contador = 0;
    static String[] comando = {"C:\\narf_executor\\strategies\\estrategia01.bat", Integer.toString(5555)};
    public static void aumentar() {
        contador++;
    }

    public static void main(String[] args) {
        // Creates a Scheduler instance.
        Scheduler scheduler = new Scheduler();
        // Schedule a once-a-minute task.
        //Predictor p = new Predictor("0 5-4/4 * * *");
        // IntStream.rangeClosed(0,5).forEach((i)->{System.out.println(Integer.toString(i)+" "+p.nextMatchingDate().toString());});
        Algo a = new Algo();

        ProcessTask ptask = new ProcessTask(comando);
        ptask.setStdoutFile(new File("salida.txt"));

        

        TaskCollector tsk = new TaskCollector() {

            int numero = 0;

            public int incrementar() {
                return ++numero;

            }

            @Override
            public TaskTable getTasks() {
                TaskTable taskTab = new TaskTable();
                taskTab.add(new SchedulingPattern("* * * * *"), new Task() {

                    @Override
                    public void execute(TaskExecutionContext tec) throws RuntimeException {
                        System.out.println("Ejecutando la tarea en su iteración " + Integer.toString(contador++));
                    
                    }

                });
                taskTab.add(new SchedulingPattern("* * * * *"), new ProcessTask(comando));
                return taskTab;
            }
        };
        SchedulerListener listener = new SchedulerListener() {
            private int hola = 0;

            @Override
            public void taskLaunching(TaskExecutor te) {
                System.out.println("CORRIENDO");
            }

            @Override
            public void taskSucceeded(TaskExecutor te) {
                System.out.println("EEEXITO" + Integer.toString(this.hola));
                a.incNum();
                System.out.println("EEEXITO" + Integer.toString(a.getNum()));
                //comando= {"C:\\narf_executor\\strategies\\estrategia01.bat", Integer.toString(a.getNum())};
                comando[1]= Integer.toString(a.getNum());
            }

            @Override
            public void taskFailed(TaskExecutor te, Throwable thrwbl) {
                System.out.println("FRACASO");
            }
        };

        scheduler.schedule("* * * * *", ptask);

//        s.schedule("* * * * *", () -> {
//            System.out.println("Another minute ticked away...");
//        });
        //s.setDaemon(true);
        // Starts the scheduler.
        scheduler.addSchedulerListener(listener);
        scheduler.start();
        JOptionPane.showMessageDialog(null, "Desea cerrarlo?");
        scheduler.stop();
    }
}

class Algo {

    
    private int i = 0;

    public int getNum() {
        return i;
    }

    public void incNum() {
        this.i++;
    }
}

*/