package com.tapi.mathcalculator.helpler;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    public static final String RATED = "rated";
    public static final String LAST_TIME_SHOW_RATE = "last_time_show_rate";
    public static final String IS_FIRTS_LAUNCHER_EQUATION = "EquationFistLauncher";
    public static final String IS_FIRTS_LAUNCHER_CALCULATOR = "CalculatorFistLauncher";

    private static PreferenceHelper sInstance;

    private SharedPreferences preferences;

    private PreferenceHelper(Context context) {
        this.preferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    public static PreferenceHelper get() {
        return sInstance; //maybe null
    }

    public static PreferenceHelper get(Context context) {
        if (sInstance == null)
            sInstance = new PreferenceHelper(context);
        return sInstance;
    }

    public static void create(Context context) {
        sInstance = new PreferenceHelper(context);
    }

    public String getString(String key, String defValue) {
        return preferences.getString(key, defValue);
    }

    public void putString(String key, String value) {
        preferences.edit().putString(key, value).apply();
    }

    public int getInt(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }

    public void putInt(String key, int value) {
        preferences.edit().putInt(key, value).apply();
    }

    public long getLong(String key, long defValue) {
        return preferences.getLong(key, defValue);
    }

    public void putLong(String key, long value) {
        preferences.edit().putLong(key, value).apply();
    }

    public float getFloat(String key, float defValue) {
        return preferences.getFloat(key, defValue);
    }

    public void putFloat(String key, float value) {
        preferences.edit().putFloat(key, value).apply();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }

    public void putBoolean(String key, boolean value) {
        preferences.edit().putBoolean(key, value).apply();
    }
}
