package com.tapi.mathcalculator.utils.convent;

import android.text.TextUtils;

import com.tapi.mathcalculator.utils.UtilsString;

public class CalculatorConventLenght {

    public static double conventLength(String inputLenght,int typeFrom,int typeTo){
        double s = 0;
        switch (typeFrom){
            case UtilsString.KEY_LENGHT_MM:
                s = CalculatorConventLenght.conventLengthCulatorMM(inputLenght,typeTo);
                break;
            case UtilsString.KEY_LENGHT_CM:
                s = CalculatorConventLenght.conventLengthCulatorCM(inputLenght,typeTo);
                break;
            case UtilsString.KEY_LENGHT_DM:
                s = CalculatorConventLenght.conventLengthCulatorDM(inputLenght,typeTo);
                break;
            case UtilsString.KEY_LENGHT_M:
                s = CalculatorConventLenght.conventLengthCulatorM(inputLenght,typeTo);
                break;
            case UtilsString.KEY_LENGHT_KM:
                s = CalculatorConventLenght.conventLengthCulatorKM(inputLenght,typeTo);
                break;
            case UtilsString.KEY_LENGHT_IN:
                s = CalculatorConventLenght.conventLengthCulatorIN(inputLenght,typeTo);
                break;
            case UtilsString.KEY_LENGHT_FT:
                s = CalculatorConventLenght.conventLengthCulatorFT(inputLenght,typeTo);
                break;
            case UtilsString.KEY_LENGHT_YD:
                s = CalculatorConventLenght.conventLengthCulatorYD(inputLenght,typeTo);
                break;
            case UtilsString.KEY_LENGHT_MILES:
                s = CalculatorConventLenght.conventLengthCulatorMiles(inputLenght,typeTo);
                break;
            case UtilsString.KEY_LENGHT_NAUTICAL_MILE:
                s = CalculatorConventLenght.conventLengthCulatorNauticalMile(inputLenght,typeTo);
                break;
        }
        return s;
    }

    public static double conventLengthCulatorCM(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_LENGHT_MM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.1;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_CM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_DM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/10;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_M:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/100;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_KM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/100000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_IN:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/2.54;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_FT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/30.48;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_YD:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/91.44;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_MILES:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/160934.4;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_NAUTICAL_MILE:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/185200;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    public static double conventLengthCulatorMM(String inputLenght,int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_LENGHT_MM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_CM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/10;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_DM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/100;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_M:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_KM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1000000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_IN:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/25.4;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_FT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/304.8;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_YD:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/914.4;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_MILES:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1609344;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_NAUTICAL_MILE:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1852000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    public static double conventLengthCulatorDM(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_LENGHT_MM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.01;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_CM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.1;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_DM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_M:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/10;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_KM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/10000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_IN:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.254;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_FT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/3.048;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_YD:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/9.144;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_MILES:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/16093.44;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_NAUTICAL_MILE:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/18520;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    public static double conventLengthCulatorM(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_LENGHT_MM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.001;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_CM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.01;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_DM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.1;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_M:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_KM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_IN:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0254;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_FT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.3048;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_YD:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.9144;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_MILES:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1609.344;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_NAUTICAL_MILE:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1852;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    public static double conventLengthCulatorKM(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_LENGHT_MM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.000001;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_CM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.00001;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_DM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0001;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_M:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.001;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_KM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_IN:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0000254;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_FT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0003048;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_YD:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0009144;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_MILES:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1.609344;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_NAUTICAL_MILE:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1.852;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    public static double conventLengthCulatorIN(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_LENGHT_MM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0393701;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_CM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.393701;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_DM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/3.93701;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_M:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/39.3701;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_KM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/39370.07874;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_IN:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_FT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/12;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_YD:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/36;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_MILES:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/63360;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_NAUTICAL_MILE:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/72913.385827;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    public static double conventLengthCulatorFT(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_LENGHT_MM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.00328084;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_CM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0328084;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_DM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.328084;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_M:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/3.28084;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_KM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/3280.839895;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_IN:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.083333;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_FT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_YD:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/3;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_MILES:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/5280;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_NAUTICAL_MILE:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/6076.115486;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    public static double conventLengthCulatorYD(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_LENGHT_MM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.00109361;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_CM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0109361;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_DM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.109361;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_M:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1.09361;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_KM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1093.613298;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_IN:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0277778;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_FT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.333333;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_YD:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_MILES:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1760;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_NAUTICAL_MILE:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/2025.371829;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    public static double conventLengthCulatorMiles(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_LENGHT_MM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0000006214;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_CM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.000006214;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_DM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.00006214;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_M:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0006214;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_KM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.6214;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_IN:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0000157828;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_FT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.000189394;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_YD:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.000568182;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_MILES:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_NAUTICAL_MILE:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1.150779;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    public static double conventLengthCulatorNauticalMile(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_LENGHT_MM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.00000054;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_CM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0000054;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_DM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.000054;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_M:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.00054;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_KM:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.54;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_IN:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0000137149;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_FT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.000164579;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_YD:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.000493737;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_MILES:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.868976;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_LENGHT_NAUTICAL_MILE:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }
}
