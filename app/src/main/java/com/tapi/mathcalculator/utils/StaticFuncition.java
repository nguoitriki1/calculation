package com.tapi.mathcalculator.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class StaticFuncition {
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public static void endSlectionInEditText (Activity activity, EditText editText){
        if (editText != null && TextUtils.isEmpty(editText.getText())){
            if (editText.getText().length() > 0){
                editText.setSelection(editText.getText().length());
            }
        }
    }
}
