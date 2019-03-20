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
                if (TextUtils.isEmpty(s)) {
                    mResultView.setmOutText("0");
                } else {
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
            public void onKeyEventClick(View view, IKeyBoard.Event event, IKeyBoard.Key key) {
                switch (key) {
                    case rad:
                        mKeyBoard.replaceKeyRadByKey(IKeyBoard.Key.rad);
                        break;
                    case deg:
                        mKeyBoard.replaceKeyRadByKey(IKeyBoard.Key.deg);
                        break;
                    case back:
                        mResultView.removeOneKeyClick();
                        break;
                    case equal:
                        mKeyBoard.replaceKeyBackByKey(IKeyBoard.Key.clr);
                        mResultView.animationResultTxtWhenClickEqual();
                        break;
                    case clr:
                        mResultView.removeAllKey();
                        mKeyBoard.replaceKeyBackByKey(IKeyBoard.Key.back);
                        break;
                    case open:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case sin:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case cos:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case tan:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case asin:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case acos:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case atan:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case pi:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case x_1:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case x2:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case x3:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case xn:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case log:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case lg:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case ln:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case e:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case gen3:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case gen:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    case un:
                        mKeyBoard.scrollView(true);
                        mResultView.addKey(key);
                        break;
                    default:
                        mResultView.addKey(key);
                        break;
                }
            }

            @Override
            public void onKeyEventLongClick(View view, IKeyBoard.Event event, IKeyBoard.Key key) {
                switch (key) {
                    case back:
                        mResultView.removeAllKey();
                        break;
                }
            }
        });
    }
}
