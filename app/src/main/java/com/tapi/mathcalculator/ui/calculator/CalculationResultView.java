package com.tapi.mathcalculator.ui.calculator;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputType;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.ui.keyboard.IKeyBoard;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class CalculationResultView extends LinearLayout {
    private TextView mOutText;
    private EditText mInText;
    private OnInTextChangeLister onInTextChangeLister;

    public CalculationResultView(Context context) {
        super(context);
    }

    public CalculationResultView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CalculationResultView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnInTextChangeLister(OnInTextChangeLister onInTextChangeLister) {
        this.onInTextChangeLister = onInTextChangeLister;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mOutText = findViewById(R.id.calculation_out_text);
        mInText = findViewById(R.id.calculation_in_text);
        mOutText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mOutText.getText().toString().length() > 12){
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                }
                else if (mOutText.getText().toString().length() > 10){
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
                }
                else if (mOutText.getText().toString().length() > 8){
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 60);
                }
                else if (mOutText.getText().toString().length() > 6){
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 70);
                }else {
                    mOutText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 80);
                }
            }
        });
        mInText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                onInTextChangeLister.onBeforeInTextChangeListner(s,start,count,after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onInTextChangeLister.onInTextChangeListner(s,start,before,count);
            }

            @Override
            public void afterTextChanged(Editable s) {
                onInTextChangeLister.onAfterInTextChangeListner(s);
            }
        });

        mInText.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return false;
            }
        });

        mInText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                hideSoftKeyboard(getContext());
            }
        });
        mInText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard(getContext());

            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mInText.setShowSoftInputOnFocus(false);
        }else {
            mInText.setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mInText.setSelection(0, mInText.length());
                    return true;
                }
            });
        }

    }

    public void addKey(IKeyBoard.Key key) {
        int selectionStart = mInText.getSelectionStart();
        StringBuffer buffer = new StringBuffer(mInText.getText());
        buffer.insert(selectionStart, key.outText);

        mInText.setText(buffer.toString());
        mInText.setSelection(selectionStart + key.outText.length());
    }
    public void setmOutText(String outText) {
        mOutText.setText(outText + "");
    }

    public void removeOneKeyClick() {
        int selectionStart = mInText.getSelectionStart();
        if (selectionStart != 0) {
            mInText.setText((Spanned) mInText.getText().delete(selectionStart - 1, selectionStart));
            mInText.setSelection(selectionStart - 1);
        }
    }
    public void hideSoftKeyboard(Context context) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(mInText.getWindowToken(), 0);
    }
    public interface OnInTextChangeLister{
        void onAfterInTextChangeListner(Editable s);
        void onInTextChangeListner(CharSequence s, int start, int before, int count);
        void onBeforeInTextChangeListner(CharSequence s, int start, int count, int after);
    }


}
