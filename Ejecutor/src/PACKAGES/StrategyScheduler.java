/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PACKAGES;
import it.sauronsoftware.cron4j.*;
import java.util.HashMap;
/**
 *
 * @author Javier
 */
public class StrategyScheduler extends it.sauronsoftware.cron4j.Scheduler{
    private static HashMap<String,Strategy> strategyMap = new HashMap<>();//Name,strategy
    private static Scheduler scheduler = new Scheduler();
    public static boolean existsStrategy(String name){
        return strategyMap.containsKey(name);
    } 
    public static String getStrategyID(Strategy str){
        return strategyMap.keySet().stream()
                .filter((key)->strategyMap.get(key).equals(str))
                .findFirst().get();
    }
    public static boolean scheduleStrategy(Strategy str){//Receives a valid strategy and schedules it.
        String cronString = str.getCronString();    
        if(!StrategyScheduler.existsStrategy(str.getName())){
            String cronID = scheduler.schedule(cronString, Executor.executeStrategy(str));
            str.setCronID(cronID);
            strategyMap.put(str.getName(), str);//Putting the strategy in the hashmap for reference purposes.
            return true;
        }
       
        return false;
    }
    
    public static boolean startScheduler(){
        StrategyScheduler.scheduler.start();
        return true;
    }
     public static boolean stopScheduler(){
        StrategyScheduler.scheduler.stop();
        return true;
    }
    public static boolean descheduleStrategy(Strategy str){
        StrategyScheduler.scheduler.deschedule(str.getCronID());
        str.setActive(false);
        FolderChecker.deactivateStrategy(str);
        return true;
    }
    
}
