package org.apache;

public class Logger {

    /**
     * log
     * @param log
     */
    public static void log(String log) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        System.out.println(">>>>" + ste.getClassName()
                + ":" + ste.getLineNumber() + " " + log);
    }
}
