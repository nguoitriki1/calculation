package com.tapi.mathcalculator.utils.convent;

import android.text.TextUtils;

import com.tapi.mathcalculator.utils.UtilsString;

public class CalculatorConventWeight {
    public static double conventWeight(String inputLenght,int typeFrom,int typeTo){
        double s = 0;
        switch (typeFrom){
            case UtilsString.KEY_WEIGHT_MG:
                s = CalculatorConventWeight.conventWeightCulatorMG(inputLenght,typeTo);
                break;
            case UtilsString.KEY_WEIGHT_G:
                s = CalculatorConventWeight.conventWeightCulatorG(inputLenght,typeTo);
                break;
            case UtilsString.KEY_WEIGHT_KG:
                s = CalculatorConventWeight.conventWeightCulatorKG(inputLenght,typeTo);
                break;
            case UtilsString.KEY_WEIGHT_TON:
                s = CalculatorConventWeight.conventWeightCulatorTON(inputLenght,typeTo);
                break;
            case UtilsString.KEY_WEIGHT_GR:
                s = CalculatorConventWeight.conventWeightCulatorGR(inputLenght,typeTo);
                break;
            case UtilsString.KEY_WEIGHT_OZ:
                s = CalculatorConventWeight.conventWeightCulatorOZ(inputLenght,typeTo);
                break;
            case UtilsString.KEY_WEIGHT_LB:
                s = CalculatorConventWeight.conventWeightCulatorLB(inputLenght,typeTo);
                break;
            case UtilsString.KEY_WEIGHT_OZT:
                s = CalculatorConventWeight.conventWeightCulatorOZT(inputLenght,typeTo);
                break;
            case UtilsString.KEY_WEIGHT_CT:
                s = CalculatorConventWeight.conventWeightCulatorCT(inputLenght,typeTo);
                break;
        }
        return s;
    }

    private static double conventWeightCulatorCT(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_WEIGHT_MG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.005;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_G:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/5;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_KG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/5000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_TON:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/5000000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_GR:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.323995;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZ:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/141.747616;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_LB:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/2267.96185;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/155.517384;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_CT:
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

    private static double conventWeightCulatorOZT(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_WEIGHT_MG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0000321507;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_G:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0321507;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_KG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/32.150747;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_TON:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/32150.746569;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_GR:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.00208333;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZ:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.911458;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_LB:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/14.583333;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_CT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.00643015;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    private static double conventWeightCulatorLB(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_WEIGHT_MG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0000022046;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_G:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0022046;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_KG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/2.204623;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_TON:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/2204.623;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_GR:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.000142857;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZ:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0625;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_LB:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0685714;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_CT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.000440925;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    private static double conventWeightCulatorOZ(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_WEIGHT_MG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.000035274;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_G:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.035274;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_KG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/35.274;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_TON:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/35273.96195;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_GR:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/35273961.95;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZ:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_LB:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/16;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1.097143;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_CT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.00705479;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    private static double conventWeightCulatorGR(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_WEIGHT_MG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0154324;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_G:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/15.432358;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_KG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/15432.358353;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_TON:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/15432358.353;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_GR:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZ:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/437.5;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_LB:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/7000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/480;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_CT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/3.086472;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    private static double conventWeightCulatorTON(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_WEIGHT_MG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.000000001;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_G:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.000001;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_KG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.001;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_TON:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_GR:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.00000006479891;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZ:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.000028349523125;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_LB:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.00045359237;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0000311034768;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_CT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0000002;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    private static double conventWeightCulatorKG(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_WEIGHT_MG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.000001;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_G:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.001;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_KG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_TON:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_GR:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.00006479891;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZ:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.028349523125;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_LB:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.45359237;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0311034768;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_CT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.0002;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    private static double conventWeightCulatorG(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_WEIGHT_MG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.001;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_G:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_KG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_TON:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1000000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_GR:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.06479891;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZ:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/28.349523125;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_LB:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/453.59237;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/31.1034768;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_CT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/0.2;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }

    private static double conventWeightCulatorMG(String inputLenght, int typeTo) {
        double s = 0;
        switch (typeTo){
            case UtilsString.KEY_WEIGHT_MG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght);
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_G:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_KG:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1000000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_TON:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/1000000000;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_GR:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/64.79891;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZ:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/28349.523125;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_LB:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/453592.37;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_OZT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/31103.4768;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
            case UtilsString.KEY_WEIGHT_CT:
                if (!TextUtils.isEmpty(inputLenght)){
                    try {
                        s = Double.parseDouble(inputLenght)/200;
                    }catch (Exception e){
                        s = 0;
                    }
                }
                break;
        }
        return s;
    }
}
