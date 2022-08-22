package com.example.javabaseproject.utils;

import android.util.Log;
import com.androidnetworking.BuildConfig;

/**
 * This Log class is used to print logs in debug build only
 */
public class AppLog {
    private static final String TAG = AppLog.class.getSimpleName();
    private static final Boolean DO_LOG = BuildConfig.DEBUG;

    /**
     * This method is used to print message
     *
     * @param msg the text to print
     */
    public static void print(String msg) {
        if (DO_LOG) {
            System.out.println(msg);
        }
    }

    /**
     * This method is used to print title and message
     *
     * @param title the title to print
     * @param msg   the message to print
     */
    public static void print(String title, String msg) {
        if (DO_LOG) {
            System.out.println(title + " :: " + msg);
        }
    }

    /**
     * This method is used to print tag, title and message
     *
     * @param tag   the name of class to print
     * @param title the title to print
     * @param msg   the message to print
     */
    public static void print(String tag, String title, String msg) {
        if (DO_LOG) {
            System.out.println(tag + " :: " + title + " :: " + msg);
        }
    }

    /**
     * This method is used to print verbose log
     *
     * @param title the title to print
     * @param msg   the message to print
     */
    public static void v(String title, String msg) {
        if (DO_LOG) {
            Log.v(title, msg);
        }
    }

    /**
     * This method is used to print verbose log
     *
     * @param title     the title to print
     * @param msg       the message to print
     * @param throwable Throwable to print
     */
    public static void v(
            String title,
            String msg,
            Throwable throwable
    ) {
        if (DO_LOG) {
            Log.v(title, msg, throwable);
        }
    }

    /**
     * This method is used to print debug log
     *
     * @param title the title to print
     * @param msg   the message to print
     */
    public static void d(String title, String msg) {
        if (DO_LOG) {
            Log.d(title, msg);
        }
    }

    /**
     * This method is used to print debug log
     *
     * @param title     the title to print
     * @param msg       the message to print
     * @param throwable Throwable to print
     */
    public static void d(
            String title,
            String msg,
            Throwable throwable
    ) {
        if (DO_LOG) {
            Log.d(title, msg, throwable);
        }
    }

    /**
     * This method is used to print warn log
     *
     * @param title the title to print
     * @param msg   the message to print
     */
    public static void w(String title, String msg) {
        if (DO_LOG) {
            Log.w(title, msg);
        }
    }

    /**
     * This method is used to print warn log
     *
     * @param title     the title to print
     * @param throwable Throwable to print
     */
    public static void w(String title, Throwable throwable) {
        if (DO_LOG) {
            Log.w(title, throwable);
        }
    }

    /**
     * This method is used to print warn log
     *
     * @param title     the title to print
     * @param msg       the message to print
     * @param throwable Throwable to print
     */
    public static void w(
            String title,
            String msg,
            Throwable throwable
    ) {
        if (DO_LOG) {
            Log.w(title, msg, throwable);
        }
    }

    /**
     * This method is used to print info log
     *
     * @param title     the title to print
     * @param msg       the message to print
     * @param throwable Throwable to print
     */
    public static void i(
            String title,
            String msg,
            Throwable throwable
    ) {
        if (DO_LOG) {
            Log.i(title, msg, throwable);
        }
    }

    /**
     * This method is used to print info log
     *
     * @param title the title to print
     * @param msg   the message to print
     */
    public static void i(String title, String msg) {
        if (DO_LOG) {
            Log.i(title, msg);
        }
    }

    /**
     * This method is used to print error log
     *
     * @param title the title to print
     * @param msg   the message to print
     */
    public static void e(String title, String msg) {
        if (DO_LOG) {
            Log.e(title, msg);
        }
    }

    /**
     * This method is used to print error log
     *
     * @param title the title to print
     * @param e     Exception to print
     */
    public static void e(String title, Exception e) {
        if (DO_LOG) {
            Log.e(title, "Exception :: " + e);
        }
    }

    /**
     * This method is used to print error log
     *
     * @param title the title to print
     * @param t     Throwable to print
     */
    public static void e(String title, Throwable t) {
        if (DO_LOG) {
            Log.e(title, "Throwable :: " + t);
        }
    }

    /**
     * This method is used to print error log
     *
     * @param title the title to print
     * @param msg   the message to print
     * @param e     Exception to print
     */
    public static void e(String title, String msg, Exception e) {
        if (DO_LOG) {
            Log.e(title, msg, e);
        }
    }

    /**
     * This method is used to print error log
     *
     * @param title the title to print
     * @param msg   the message to print
     * @param t     Throwable to print
     */
    public static void e(String title, String msg, Throwable t) {
        if (DO_LOG) {
            Log.e(title, msg, t);
        }
    }
}
