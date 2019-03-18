package com.tapi.mathcalculator.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.ui.keyboard.IKeyBoard;

public class CalculationResultView extends LinearLayout {
    private TextView mOutText;
    private EditText mInText;

    public CalculationResultView(Context context) {
        super(context);
    }

    public CalculationResultView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CalculationResultView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mOutText = findViewById(R.id.calculation_out_text);
        mInText = findViewById(R.id.calculation_in_text);

        mInText.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return false;
            }
        });
    }

    public void addKey(IKeyBoard.Key key) {
        int selectionStart = mInText.getSelectionStart();
        StringBuffer buffer = new StringBuffer(mInText.getText());
        buffer.insert(selectionStart, key.outText);

        mInText.setText(buffer.toString());
        mInText.setSelection(selectionStart + key.outText.length());
    }
}
