package com.tapi.mathcalculator.function.calculator;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.activities.HomePageViewModel;
import com.tapi.mathcalculator.helpler.PreferenceHelper;
import com.tapi.mathcalculator.ui.calculator.CalculationResultView;
import com.tapi.mathcalculator.ui.keyboard.IKeyBoard;
import com.tapi.mathcalculator.ui.calculator.CalculatorKeyBoardView;

public class CalculatorFragment extends Fragment {
    private CalculatorKeyBoardView mKeyBoard;
    private CalculationResultView mResultView;
    private HomePageViewModel homePageViewModel;
    private View mTutorialCalculatorDot, mTutorialCalculatorBg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.calculator_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (getActivity() != null)
            homePageViewModel = ViewModelProviders.of(getActivity()).get(HomePageViewModel.class);
        funfindViewById(view);
        checkTutorialCalculator();
        initView();
    }

    private void checkTutorialCalculator() {
        boolean isFirtsLauncherCalculator = PreferenceHelper.get().getBoolean(PreferenceHelper.IS_FIRTS_LAUNCHER_CALCULATOR, false);
        if (!isFirtsLauncherCalculator) {
            showTutorial();
        }
    }

    private void funfindViewById(View view) {
        mKeyBoard = view.findViewById(R.id.calculator_keyboard_layout);
        mResultView = view.findViewById(R.id.calculation_result_view);
        mTutorialCalculatorDot = view.findViewById(R.id.view5);
        mTutorialCalculatorBg = view.findViewById(R.id.view6);
    }

    private void initView() {
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
                        mResultView.inputDbHistory();
                        break;
                    case clr:
                        mResultView.removeAllKey();
                        mKeyBoard.replaceKeyBackByKey(IKeyBoard.Key.back);
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
                    default:
                        view.performClick();
                        break;
                }
            }
        });
        mKeyBoard.setOnKeyboardScrollDownListener(new CalculatorKeyBoardView.OnKeyboardScrollDownListener() {
            @Override
            public void onKeyboardScrollDownListener(boolean isDown) {
                if (isDown) {
                    PreferenceHelper.get().putBoolean(PreferenceHelper.IS_FIRTS_LAUNCHER_CALCULATOR, true);
                    homePageViewModel.endAnimationTutorialCalculator(getActivity(), mTutorialCalculatorDot, mTutorialCalculatorBg);
                }
            }
        });
    }
    public void showTutorial() {
        homePageViewModel.startAnimationTutorialCalculator(getActivity(), mTutorialCalculatorDot, mTutorialCalculatorBg);
    }
}
