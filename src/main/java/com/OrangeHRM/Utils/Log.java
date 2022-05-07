package com.OrangeHRM.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.Status;

public class Log extends TestNGITestListener{
    //Initialize Log4j instance
    public static final Logger Log =  LogManager.getLogger(Log.class);
    //Info Level Logs
    public static void info (String message) {
        Log.info(message);
        //extentTest.get().log(Status.INFO, message);
    }
    //Warn Level Logs
    public static void warn (String message) {
        Log.warn(message);
        //extentTest.get().log(Status.WARNING, message);
    }
    //Error Level Logs
    public static void error (String message) {
        Log.error(message);
        //extentTest.get().log(Status.FAIL, message);
    }
    //Fatal Level Logs
    public static void fatal (String message) {
        Log.fatal(message);
        //extentTest.get().log(Status.FAIL, "FATAL : " + message);
    }
    //Debug Level Logs
    public static void debug (String message) {
        Log.debug(message);
        //extentTest.get().log(Status.INFO, "[DEBUG] : " + message);
    }
}