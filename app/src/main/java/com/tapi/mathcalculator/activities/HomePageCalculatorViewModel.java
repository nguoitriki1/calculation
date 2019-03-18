package com.tapi.mathcalculator.activities;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.tapi.mathcalculator.fragment.calculator.Equation;
import com.tapi.mathcalculator.utils.UtilsString;

import java.util.ArrayList;
import java.util.List;

public class HomePageCalculatorViewModel extends ViewModel {
    private List<StringObject> listNumbers, listOperations;
    private Equation eq = new Equation();
    private MutableLiveData<String> txtResultOb;

    public MutableLiveData<String> getTxtResultOb() {
        if (txtResultOb == null) {
            txtResultOb = new MutableLiveData<>();
            txtResultOb.setValue("");
        }
        return txtResultOb;
    }

    public void clearListResult() {
        eq.clear();
    }

    public Equation getEq() {
        return eq;
    }

    public void setEq(Equation eq) {
        this.eq = eq;
    }

    public void setTxtResultOb(String value) {
        if (txtResultOb == null) {
            getTxtResultOb();
        }
        this.txtResultOb.setValue(value);
    }

    public List<StringObject> getListNumbers() {
        if (listNumbers == null) {
            listNumbers = new ArrayList<>();
            listNumbers.add(new StringObject("0", "0"));
            listNumbers.add(new StringObject("1", "1"));
            listNumbers.add(new StringObject("2", "2"));
            listNumbers.add(new StringObject("3", "3"));
            listNumbers.add(new StringObject("4", "4"));
            listNumbers.add(new StringObject("5", "5"));
            listNumbers.add(new StringObject("6", "6"));
            listNumbers.add(new StringObject("7", "7"));
            listNumbers.add(new StringObject("8", "8"));
            listNumbers.add(new StringObject("9", "9"));
        }
        return listNumbers;
    }

    public void setListNumbers(List<StringObject> listNumbers) {
        this.listNumbers = listNumbers;
    }

    public List<StringObject> getListOperations() {
        if (listOperations == null) {
            listOperations = new ArrayList<>();
            listOperations.add(new StringObject("%", "%"));
            listOperations.add(new StringObject("+", "+"));
            listOperations.add(new StringObject("-", "-"));
            listOperations.add(new StringObject("x", "x"));
            listOperations.add(new StringObject("÷", "÷"));
            listOperations.add(new StringObject("÷", "÷"));
            listOperations.add(new StringObject("(", "("));
            listOperations.add(new StringObject(")", ")"));
            listOperations.add(new StringObject("s", "sin("));
            listOperations.add(new StringObject("c", "cos("));
            listOperations.add(new StringObject("t", "tan("));
            listOperations.add(new StringObject("π", "π"));
            listOperations.add(new StringObject("p", "asin("));
            listOperations.add(new StringObject("o", "acos("));
            listOperations.add(new StringObject("i", "atan("));
            listOperations.add(new StringObject("u", "log("));
            listOperations.add(new StringObject("l", "lg("));
            listOperations.add(new StringObject("k", "ln("));
            listOperations.add(new StringObject("e", "e"));
            listOperations.add(new StringObject("x_1", "\u00AF\u00B9"));
            listOperations.add(new StringObject("x_2", "\u00B2"));
            listOperations.add(new StringObject("x_3", "\u00B3"));
            listOperations.add(new StringObject("^", "^"));
            listOperations.add(new StringObject("√", "√"));
            listOperations.add(new StringObject("³√", "\u00B3" + "√"));
            listOperations.add(new StringObject("!", "!"));
        }
        return listOperations;
    }

    public void setListOperations(List<StringObject> listOperations) {
        this.listOperations = listOperations;
    }

    public void numOpNum(char id) {
        if (eq.getLast().endsWith("."))
            eq.detachFromLast();
        if (id != '-' || (eq.isOperator(0) && eq.isStartCharacter(1)))
            while (eq.isOperator(0))
                eq.removeLast();
        if (id == '-' || !eq.isStartCharacter(0))
            eq.add("" + id);
    }

    public void digit(char id) {
        if (eq.size() > 0) {
            String s = eq.get(eq.size() - 1);
            if (s.contains("%")) {
                eq.add("*");
                eq.attachToLast(id);
            } else {
                eq.attachToLast(id);
            }
        }else {
            eq.attachToLast(id);
        }
        Log.d("size", "" + eq.getText());
    }

    public void decimal(String s) {
        if (!Character.isDigit(eq.getLastChar()))
            digit('0');
        if (!eq.getLast().contains("."))
            eq.attachToLast('.');

    }

    public void totalResul(String s) {
        setTxtResultOb(eq.getText());
    }

    public String calculatorString(String s) {
        for (int i = 0; i < s.length(); i++) {
            s = checkCharInString(s, s.charAt(i), i, s.length());
        }
        return s;
    }

    public String checkCharInString(String txtResult, char charAt, int index, int lenght) {
        if (index == 0){
            //ky' tu do nam o dau tien

        }else if (index == lenght - 1){
            //neu ky tu do nam o cuoi cung

            switch (charAt){
                case '%':
                    return txtResult.replace("%", "/100");
            }
        }else {
            // neu ky tu do nam o giua

            switch (charAt){
                case '%':
                    return txtResult.replace("%", "/100*");
            }

        }
        return txtResult;
    }

}
