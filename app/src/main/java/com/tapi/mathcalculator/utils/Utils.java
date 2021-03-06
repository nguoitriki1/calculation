package com.tapi.mathcalculator.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static android.net.ConnectivityManager.TYPE_WIFI;

public class Utils {

    public static final String charsToString(char... cArr) {
        return new String(cArr);
    }

    public static boolean checkIsOperator(int lengText, char charAt) {
        if (lengText > 0) {
            if (charAt == ((char) 247) || charAt == '+' || charAt == '-' || charAt == ((char) 215)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean checkIsNumber(char charAt) {
        if (charAt == '0' || charAt == '1' || charAt == '2' || charAt == '3' || charAt == '4' || charAt == '5' || charAt == '6' || charAt == '7' || charAt == '8' || charAt == '9' || charAt == 'x' || charAt == 'y') {
            return true;
        } else {
            return false;
        }
    }
}
