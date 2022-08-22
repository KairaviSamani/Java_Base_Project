package com.example.javabaseproject.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPref {
    private static SharedPreferences sharedPreferences = null;

    /**
     * This method is used to initialize shared preferences
     * @param context the context is used to initialize shared preferences
     */
    private static void openPref(Context context) {
        sharedPreferences = context.getSharedPreferences(
                "AppPref",
                Context.MODE_PRIVATE
        );
    }

    /**
     * This method is used to get string preference value
     * @param context the context is used to initialize shared Preference
     * @param key The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return Returns the string preference value if it exists, or defaultValue
     */
    public static String getValue(
            Context context, String key,
            String defaultValue
    ) {
        openPref(context);
        String result = sharedPreferences.getString(key, defaultValue);
        sharedPreferences = null;
        return result;
    }

    /**
     * This method is used to set string preference value
     * @param context the context is used to initialize shared Preference
     * @param key The name of the preference to modify
     * @param value The new value for the preference.
     */
    public static void setValue(Context context, String key, String value) {
        openPref(context);
        SharedPreferences.Editor prefsPrivateEditor = sharedPreferences.edit();
        prefsPrivateEditor.putString(key, value);
        prefsPrivateEditor.apply();
        sharedPreferences = null;
    }

    /**
     * This method is used to get integer preference value
     * @param context the context is used to initialize shared Preference
     * @param key The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return Returns the integer preference value if it exists, or defaultValue
     */
    public static int getValue(Context context, String key, int defaultValue) {
        openPref(context);
        int result = sharedPreferences.getInt(key, defaultValue);
        sharedPreferences = null;
        return result;
    }

    /**
     * This method is used to set integer preference value
     * @param context the context is used to initialize shared Preference
     * @param key The name of the preference to modify
     * @param value The new value for the preference.
     */
    public static void setValue(Context context, String key, int value) {
        openPref(context);
        SharedPreferences.Editor prefsPrivateEditor = sharedPreferences.edit();
        prefsPrivateEditor.putInt(key, value);
        prefsPrivateEditor.apply();
        sharedPreferences = null;
    }

    /**
     * This method is used to get boolean preference value
     * @param context the context is used to initialize shared Preference
     * @param key The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return Returns the boolean preference value if it exists, or defaultValue
     */
    public static boolean getValue(Context context, String key, boolean defaultValue) {
        openPref(context);
        boolean result = sharedPreferences.getBoolean(key, defaultValue);
        sharedPreferences = null;
        return result;
    }

    /**
     * This method is used to set boolean preference value
     * @param context the context is used to initialize shared Preference
     * @param key The name of the preference to modify
     * @param value The new value for the preference.
     */
    public static void setValue(Context context, String key, boolean value) {
        openPref(context);
        SharedPreferences.Editor prefsPrivateEditor = sharedPreferences.edit();
        prefsPrivateEditor.putBoolean(key, value);
        prefsPrivateEditor.apply();
        sharedPreferences = null;
    }
}
