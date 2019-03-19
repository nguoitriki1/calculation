package com.tapi.mathcalculator.function.calculator;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.ui.calculator.CalculationResultView;
import com.tapi.mathcalculator.ui.keyboard.IKeyBoard;
import com.tapi.mathcalculator.ui.keyboard.ScienceKeyBoardView;

public class CalculatorFragment extends Fragment {
    private ScienceKeyBoardView mKeyBoard;
    private CalculationResultView mResultView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.calculator_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mKeyBoard = view.findViewById(R.id.calculator_keyboard_layout);
        mResultView = view.findViewById(R.id.calculation_result_view);
        mResultView.setmOutText("0");
        mResultView.setOnInTextChangeLister(new CalculationResultView.OnInTextChangeLister() {
            @Override
            public void onAfterInTextChangeListner(Editable s) {
                if (TextUtils.isEmpty(s)){
                    mResultView.setmOutText("0");
                }else {
                    mResultView.setmOutText(String.valueOf(s));
                }
            }

            @Override
            public void onInTextChangeListner(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void onBeforeInTextChangeListner(CharSequence s, int start, int count, int after) {

            }
        });

        mKeyBoard.setOnKeyboardOnClickListener(new IKeyBoard.OnKeyboardOnClickListener() {
            @Override
            public void onKeyEvent(View view, IKeyBoard.Event event, IKeyBoard.Key key) {
                switch (key) {
                    case back:
                        mResultView.removeOneKeyClick();
                        break;
                    default:
                        try {
                            mResultView.addKey(key);
                        } catch (Exception e) {

                        }
                        break;
                }
            }
        });
    }
}
