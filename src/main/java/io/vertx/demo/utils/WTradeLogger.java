package io.vertx.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WTradeLogger {
    public final static int ERROR_MESSAGE = -1;
    public final static int WARNING_MESSAGE = 0;
    public final static int INFO_MESSAGE = 1;
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    private static boolean isMute = false;

    public static void print(String component, String message) {
        print(component, message, INFO_MESSAGE);
    }

    public static void print(String component, String message, int type) {
        if (isMute) {
            return;
        }
        Date curTime = Calendar.getInstance().getTime();
        String logType = "?";

        if (type == ERROR_MESSAGE) {
            logType = "[ERROR]";
        }
        if (type == WARNING_MESSAGE) {
            logType = "[WARNING]";
        }
        if (type == INFO_MESSAGE) {
            logType = "[INFO]";
        }
        System.out.println(String.format("%s [%s | %s]: %s",logType,formatter.format(curTime),component,message));
    }
}
