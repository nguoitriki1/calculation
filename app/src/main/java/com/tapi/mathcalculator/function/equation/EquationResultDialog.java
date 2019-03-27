package com.tapi.mathcalculator.function.equation;

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

public class EquationResultDialog extends DialogFragment implements View.OnClickListener {
    private ImageView mImgBracket;
    private TextView mTxtResult1,mTxtResult2;
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
        return inflater.inflate(R.layout.equation_result_dialog,container,false);
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
            String result1 = arguments.getString(UtilsString.EQUATION_RESULT1_TXT, "");
            String result2 = arguments.getString(UtilsString.EQUATION_RESULT2_TXT, "");
            if (!TextUtils.isEmpty(result1)){
                mTxtResult1.setText(result1);
            }
            if (!TextUtils.isEmpty(result2)){
                mTxtResult2.setText(result2);
                mTxtResult2.setVisibility(View.VISIBLE);
                mImgBracket.setVisibility(View.VISIBLE);
            }else {
                mTxtResult2.setVisibility(View.INVISIBLE);
                mImgBracket.setVisibility(View.GONE);
            }
        }
    }

    private void funFindViewById(View view) {
        mImgBracket = view.findViewById(R.id.equation_dialog_result_bracket_img);
        mTxtResult1 = view.findViewById(R.id.equation_dialog_result_1_txt);
        mTxtResult2 = view.findViewById(R.id.equation_dialog_result_2_txt);
        mBtnRefesh = view.findViewById(R.id.equation_dialog_result_refesh_btn);
        mBtnExit = view.findViewById(R.id.equation_dialog_result_closed_btn);
        mLayoutResult = view.findViewById(R.id.equation_dialog_result_layout);
        mResultRecyclerView = view.findViewById(R.id.equation_dialog_result_rv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.equation_dialog_result_refesh_btn:
                break;
            case R.id.equation_dialog_result_closed_btn:
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
