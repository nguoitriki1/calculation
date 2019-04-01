package com.tapi.mathcalculator.function.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.utils.UtilsString;

import katex.hourglass.in.mathlib.MathView;

public class PhotoDialogResult extends DialogFragment implements View.OnClickListener {
    private MathView mTxtResult;
    private ImageView mBtnRefesh,mBtnExit;
    private ConstraintLayout mLayoutResult;
    private View view;
    private RecyclerView mResultRecyclerView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogEquationResult);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.photo_dialog_result,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.view = view;
        view.startAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.common_animation_fadein));
        funFindViewById(view);
        getData();
        initView();
    }

    private void initView() {
        Animation animationSlide = AnimationUtils.loadAnimation(getActivity(), R.anim.translide_result_equation_dialog);
        mLayoutResult.startAnimation(animationSlide);
        mBtnExit.setOnClickListener(this);
        mBtnRefesh.setOnClickListener(this);
        //rv

        mResultRecyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        mResultRecyclerView.setHasFixedSize(true);
    }

    private void getData() {
        if (getArguments()!= null){
            Bundle arguments = getArguments();
            String result1 = arguments.getString(UtilsString.PHOTO_RESULT_KEY, "");
            if (!TextUtils.isEmpty(result1)){
                mTxtResult.setDisplayText(result1);
            }
        }
    }

    private void funFindViewById(View view) {
        mTxtResult = (MathView) view.findViewById(R.id.photo_dialog_result_txt);
        mBtnRefesh = view.findViewById(R.id.photo_dialog_result_refesh_btn);
        mBtnExit = view.findViewById(R.id.photo_dialog_result_closed_btn);
        mLayoutResult = view.findViewById(R.id.photo_dialog_result_layout);
        mResultRecyclerView = view.findViewById(R.id.photo_dialog_result_rv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.photo_dialog_result_refesh_btn:
                break;
            case R.id.photo_dialog_result_closed_btn:
                if (view != null){
                    Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.common_animation_fadeout);
                    view.setAnimation(animation);
                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            dismiss();
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    view.startAnimation(animation);
                }
                break;
        }
    }
}
