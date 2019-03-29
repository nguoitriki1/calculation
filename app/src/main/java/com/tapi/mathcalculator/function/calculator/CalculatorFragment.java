package com.tapi.mathcalculator.function.calculator;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.helpler.PreferenceHelper;
import com.tapi.mathcalculator.ui.calculator.CalculationResultView;
import com.tapi.mathcalculator.ui.keyboard.IKeyBoard;
import com.tapi.mathcalculator.ui.calculator.CalculatorKeyBoardView;

public class CalculatorFragment extends Fragment {
    private CalculatorKeyBoardView mKeyBoard;
    private CalculationResultView mResultView;
    private View mTutorialCalculatorDot, mTutorialCalculatorBg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.calculator_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        funfindViewById(view);
        checkTutorialCalculatorLaunchFirst();
        initView();
    }

    private void checkTutorialCalculatorLaunchFirst() {
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
                    mTutorialCalculatorDot.setAnimation(null);
                    mTutorialCalculatorDot.setVisibility(View.GONE);
                    mTutorialCalculatorBg.setAnimation(null);
                    mTutorialCalculatorBg.setVisibility(View.GONE);
                }
            }
        });
    }

    public void startAnimationTutorialCalculator(Context context, final View mTutorialCalculatorDot, final View mTutorialCalculatorBg) {
        if (mTutorialCalculatorBg.getAnimation() == null || mTutorialCalculatorDot.getAnimation() == null){
            final Animation slide = AnimationUtils.loadAnimation(context, R.anim.slide_translate_top_tutorial);
            Animation  fadeIn = AnimationUtils.loadAnimation(context,R.anim.common_animation_fadein);
            final Animation  fadeOut = AnimationUtils.loadAnimation(context,R.anim.common_animation_fadeout);
            final Animation  fadeOutBg = AnimationUtils.loadAnimation(context,R.anim.bg_fadeout);
            fadeOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mTutorialCalculatorDot.startAnimation(slide);
                    mTutorialCalculatorBg.startAnimation(slide);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            fadeIn.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mTutorialCalculatorDot.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mTutorialCalculatorDot.startAnimation(slide);
                            mTutorialCalculatorBg.startAnimation(slide);
                        }
                    },300);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            slide.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mTutorialCalculatorDot.startAnimation(fadeOut);
                    mTutorialCalculatorBg.startAnimation(fadeOutBg);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            mTutorialCalculatorDot.startAnimation(fadeIn);

        }
    }
    public void showTutorial() {
        startAnimationTutorialCalculator(getActivity(), mTutorialCalculatorDot, mTutorialCalculatorBg);
    }
}
