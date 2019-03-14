package com.tapi.mathcalculator;

import android.arch.lifecycle.ViewModel;
import android.text.Html;

public class HomePageCalculatorViewModel extends ViewModel {
    private String mTxtResult;

    public String getmTxtResult() {
        return mTxtResult;
    }

    public void setmTxtResult(String mTxtResult) {
        this.mTxtResult = mTxtResult;
    }
}
