package FRAMEWORK.UTILS;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LoggerUtils {
    
    private static final Logger log = LogManager.getLogger();
    
    public static void infoLog(String message){
        log.info(message);
    }
    
    public static void warnLog(String message){
        log.warn(message);
    }
    
    public static void debugLog(String message){
        log.debug(message);
    }
    
    public static void errorLog(String message){
        log.error(message);
    }
    
    
    
}
