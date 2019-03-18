package com.tapi.mathcalculator.ui.keyboard;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.tapi.mathcalculator.R;

public class CalculatorKeyboardView extends LinearLayout implements IKeyBoard {
    public CalculatorKeyboardView(Context context) {
        super(context);
    }

    public CalculatorKeyboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CalculatorKeyboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    private void addKey(@IdRes int id, Key key) {
        IKeyItem keyItem = (IKeyItem) findViewById(id);
        keyItem.setKey(key);
        keyItem.setOnClickListener(this);
        keyItem.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
