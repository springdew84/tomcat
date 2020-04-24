package org.apache;

import org.apache.juli.logging.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyLogger {

    /**
     * log
     *
     * @param log
     */
    public static void log(String log) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        System.out.println("->"
                + new SimpleDateFormat("HH:mm:ss:SSS").format(new Date())
                + "[" + Thread.currentThread().getId()
                + "#" + Thread.currentThread().getName() + "]"
                + " " + ste.getClassName()
                + ":" + ste.getMethodName() + "()"
                + " " + log);
    }

    /**
     * log
     *
     * @param object
     */
    public static void log(Object object) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        System.out.println("->"
                + new SimpleDateFormat("HH:mm:ss:SSS").format(new Date())
                + "[" + Thread.currentThread().getId()
                + "#" + Thread.currentThread().getName() + "]"
                + " " + ste.getClassName()
                + ":" + ste.getMethodName() + "()"
                + " " + object.getClass().getName());
    }

    /**
     * add by cassey
     *
     * @param logger
     * @param log
     */
    public static void printTrack(Object object, Log logger, String log) {
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        if (null == st) {
            logger.info("invalid stack");
            return;
        }

        StringBuffer sbf = new StringBuffer();
        for (int i = 2; i < st.length; i++) {
            if (sbf.length() > 0) {
                //sbf.append(" <- ");
                sbf.append(System.getProperty("line.separator"));
            }
            sbf.append(java.text.MessageFormat.format("{0}.{1}() line:{2}"
                    , st[i].getClassName()
                    , st[i].getMethodName()
                    , st[i].getLineNumber()));
        }

        logger.info("[" + object.getClass().getName() + "] "
                + (log == null ? "" : log)
                + "\n************************************************************\n"
                + sbf.toString()
                + "\n************************************************************");
    }
}
