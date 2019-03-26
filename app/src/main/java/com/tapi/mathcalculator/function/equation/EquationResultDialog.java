package com.tapi.mathcalculator.function.equation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.utils.UtilsString;

public class EquationResultDialog extends DialogFragment implements View.OnClickListener {
    private ImageView mImgBracket;
    private TextView mTxtResult1,mTxtResult2;
    private ImageView mBtnRefesh,mBtnExit;
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
        funFindViewById(view);
        getData();
        initView();
    }

    private void initView() {
        mBtnExit.setOnClickListener(this);
        mBtnRefesh.setOnClickListener(this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.equation_dialog_result_refesh_btn:
                break;
            case R.id.equation_dialog_result_closed_btn:
                dismiss();
                break;
        }
    }
}
