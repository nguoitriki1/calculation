package com.tapi.mathcalculator.activities;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.tapi.mathcalculator.R;

public class HomePageViewModel extends ViewModel {
    private Animation fadeIn,fadeOut,slide,fadeOutBg;

    public void startAnimationTutorialCalculator(Context context, final View mTutorialCalculatorDot, final View mTutorialCalculatorBg) {
        if (mTutorialCalculatorBg.getAnimation() == null || mTutorialCalculatorDot.getAnimation() == null){
            slide = AnimationUtils.loadAnimation(context, R.anim.slide_translate_top_tutorial);
            fadeIn = AnimationUtils.loadAnimation(context,R.anim.common_animation_fadein);
            fadeOut = AnimationUtils.loadAnimation(context,R.anim.common_animation_fadeout);
            fadeOutBg = AnimationUtils.loadAnimation(context,R.anim.bg_fadeout);
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

    public void endAnimationTutorialCalculator(FragmentActivity activity, View mTutorialCalculatorDot, View mTutorialCalculatorBg) {
        mTutorialCalculatorDot.setAnimation(null);
        mTutorialCalculatorDot.setVisibility(View.GONE);
        mTutorialCalculatorBg.setAnimation(null);
        mTutorialCalculatorBg.setVisibility(View.GONE);
    }
}
