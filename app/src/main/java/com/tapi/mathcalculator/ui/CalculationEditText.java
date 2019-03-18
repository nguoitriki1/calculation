package com.tapi.mathcalculator.ui;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import java.sql.Types;

public class CalculationEditText extends EditText {
    public CalculationEditText(Context context) {
        super(context);
    }

    public CalculationEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CalculationEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int type = getInputType();
        setInputType(InputType.TYPE_NULL);

        boolean result = super.onTouchEvent(event);

        setInputType(type);
        return result;
    }
}
