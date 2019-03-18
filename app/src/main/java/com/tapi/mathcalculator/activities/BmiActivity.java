package com.tapi.mathcalculator.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.function.fragment.bmi.DialogQuestionFragment;
import com.tapi.mathcalculator.utils.StaticFuncition;
import com.tapi.mathcalculator.utils.UtilsString;

public class BmiActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private LinearLayout mLayoutDropDownSpinerHeight, mLayoutDropDownSpinerWeight;
    private ConstraintLayout mLayoutSpinerHeight, mLayoutSpinerWeight, mLayoutParent;
    private ImageView mImgBack, mBtnClearText, mImgQuestion;
    private TextView mTxtSpinerHeightCm, mTxtSpinerHeightst, mTxtSpinerWeightKg, mTxtSpinerWeightLb, mTxtSpinerWeightSt, mBtnNumberZero, mBtnNumberOne, mBtnNumberTwo, mBtnNumberThree, mBtnNumberFour, mBtnNumberFive, mBtnNumberSix, mBtnNumberSevent, mBtnNumberEight, mBtnNumberNight, mBtnDot, mTxtMainSpinerHeight, mTxtMainSpinerWeight;
    private EditText mEdtSpinerHeightWithCm, mEdtSpinerHeightWithFt, mEdtSpinerHeightWithIn, mEdtSpinerWeightWithKg, mEdtSpinerWeightWithLb, mEdtSpinerWeightWithSt, mEdtSpinerWeightWithStLb;
    private EditText mEditTextForcus;
    private Double mHeightResult,mWeightResult;
    private TextView mTxtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_bmi);
        mLayoutDropDownSpinerHeight = findViewById(R.id.layout_drop_spiner_height);
        mLayoutDropDownSpinerWeight = findViewById(R.id.layout_drop_spiner_weight);
        mLayoutSpinerHeight = findViewById(R.id.layout_spinner_height);
        mLayoutSpinerWeight = findViewById(R.id.layout_spinner_weight);
        mLayoutParent = findViewById(R.id.layout_parent_bmi_activity);
        mImgBack = findViewById(R.id.bmi_back_img);
        mTxtSpinerHeightCm = findViewById(R.id.spiner_height_txt_cm);
        mTxtSpinerHeightst = findViewById(R.id.spiner_height_txt_ft);
        mTxtSpinerWeightKg = findViewById(R.id.spiner_weight_txt_kg);
        mTxtSpinerWeightLb = findViewById(R.id.spiner_weight_txt_lb);
        mTxtSpinerWeightSt = findViewById(R.id.spiner_weight_txt_st);
        mBtnNumberZero = findViewById(R.id.btn_number_zero);
        mBtnNumberOne = findViewById(R.id.btn_number_one);
        mBtnNumberTwo = findViewById(R.id.btn_number_two);
        mBtnNumberThree = findViewById(R.id.btn_number_three);
        mBtnNumberFour = findViewById(R.id.btn_number_four);
        mBtnNumberFive = findViewById(R.id.btn_number_five);
        mBtnNumberSix = findViewById(R.id.btn_number_six);
        mBtnNumberSevent = findViewById(R.id.btn_number_seven);
        mBtnNumberEight = findViewById(R.id.btn_number_eight);
        mBtnNumberNight = findViewById(R.id.btn_number_nine);
        mBtnDot = findViewById(R.id.btn_dot);
        mBtnClearText = findViewById(R.id.btn_clear_text);
        mTxtMainSpinerHeight = findViewById(R.id.spiner_height_txt_main);
        mTxtMainSpinerWeight = findViewById(R.id.spiner_weight_txt_main);
        mEdtSpinerHeightWithCm = findViewById(R.id.edt_spiner_height_with_cm);
        mEdtSpinerHeightWithFt = findViewById(R.id.edt_spiner_height_with_ft);
        mEdtSpinerHeightWithIn = findViewById(R.id.edt_spiner_height_with_in);
        mEdtSpinerWeightWithKg = findViewById(R.id.edt_spiner_weight_with_kg);
        mEdtSpinerWeightWithLb = findViewById(R.id.edt_spiner_weight_with_lb);
        mEdtSpinerWeightWithSt = findViewById(R.id.edt_spiner_weight_with_st);
        mEdtSpinerWeightWithStLb = findViewById(R.id.edt_spiner_weight_with_stlb);
        mImgQuestion = findViewById(R.id.bmi_img_question);
        mTxtResult = findViewById(R.id.bmi_txt_result);
        setClickView();
        initView();

    }

    private void setClickView() {
        mLayoutSpinerHeight.setOnClickListener(this);
        mLayoutSpinerWeight.setOnClickListener(this);
        mBtnNumberZero.setOnClickListener(this);
        mBtnNumberOne.setOnClickListener(this);
        mBtnNumberTwo.setOnClickListener(this);
        mBtnNumberThree.setOnClickListener(this);
        mBtnNumberFour.setOnClickListener(this);
        mBtnNumberFive.setOnClickListener(this);
        mBtnNumberSix.setOnClickListener(this);
        mBtnNumberSevent.setOnClickListener(this);
        mBtnNumberEight.setOnClickListener(this);
        mBtnNumberNight.setOnClickListener(this);
        mImgBack.setOnClickListener(this);
        mBtnClearText.setOnClickListener(this);
        mBtnDot.setOnClickListener(this);
        mTxtSpinerHeightCm.setOnClickListener(this);
        mTxtSpinerHeightst.setOnClickListener(this);
        mTxtSpinerWeightKg.setOnClickListener(this);
        mTxtSpinerWeightLb.setOnClickListener(this);
        mTxtSpinerWeightSt.setOnClickListener(this);
        mEdtSpinerHeightWithCm.setOnClickListener(this);
        mEdtSpinerHeightWithFt.setOnClickListener(this);
        mEdtSpinerHeightWithIn.setOnClickListener(this);
        mEdtSpinerWeightWithKg.setOnClickListener(this);
        mEdtSpinerWeightWithLb.setOnClickListener(this);
        mEdtSpinerWeightWithSt.setOnClickListener(this);
        mEdtSpinerWeightWithStLb.setOnClickListener(this);
        mImgQuestion.setOnClickListener(this);
        //setonTouch Editext
        mEdtSpinerHeightWithCm.setOnTouchListener(this);
        mEdtSpinerHeightWithFt.setOnTouchListener(this);
        mEdtSpinerHeightWithIn.setOnTouchListener(this);
        mEdtSpinerWeightWithKg.setOnTouchListener(this);
        mEdtSpinerWeightWithLb.setOnTouchListener(this);
        mEdtSpinerWeightWithSt.setOnTouchListener(this);
        mEdtSpinerWeightWithStLb.setOnTouchListener(this);
    }


    private void initView() {
        mEdtSpinerHeightWithCm.requestFocus();
        mEditTextForcus = mEdtSpinerHeightWithCm;

        //onTextChange
        mEdtSpinerHeightWithCm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculatorResultBmi();
            }
        });
        mEdtSpinerHeightWithFt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculatorResultBmi();
            }
        });
        mEdtSpinerHeightWithIn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculatorResultBmi();
            }
        });
        mEdtSpinerWeightWithKg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculatorResultBmi();
            }
        });
        mEdtSpinerWeightWithLb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculatorResultBmi();
            }
        });
        mEdtSpinerWeightWithSt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculatorResultBmi();
            }
        });
        mEdtSpinerWeightWithStLb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculatorResultBmi();
            }
        });
    }

    private void calculatorResultBmi() {
        try {
            double resultHeight = getResultHeight();
            double resultWeight = getResultWeight();
            double totalResult = (resultWeight/Math.pow(resultHeight/100, 2));
            if (String.valueOf(totalResult).length()>5){
                String s = String.valueOf(totalResult).substring(0,5);
                mTxtResult.setText(s);
            }else {
                mTxtResult.setText(totalResult+"");
            }
        }catch (Exception e){
            if (mTxtResult != null)
            mTxtResult.setText("");
        }
    }
    // 1st= 6.350293kg
    // 1lb= 0.4535923kg
    private double getResultWeight() {
        if (mTxtMainSpinerWeight.getText().toString().equals("kg")){
            return Double.parseDouble(mEdtSpinerWeightWithKg.getText().toString());
        }else if (mTxtMainSpinerWeight.getText().toString().equals("lb")){
            return Double.parseDouble(mEdtSpinerWeightWithLb.getText().toString());
        }else {
            float st = Float.parseFloat( mEdtSpinerWeightWithSt.getText().toString());
            float stlb = Float.parseFloat( mEdtSpinerWeightWithStLb.getText().toString());
            return Double.parseDouble((st*6.35)+(stlb*0.45)+"");
        }
    }

    //1 inch is equal to 2.54cm
    //1 foot is equal to 30.48cm
    private double getResultHeight() {
        if (mTxtMainSpinerHeight.getText().toString().equals("cm")){
            return Double.parseDouble(mEdtSpinerHeightWithCm.getText().toString());
        }else {
            float fit = Float.parseFloat( mEdtSpinerHeightWithFt.getText().toString());
            float in = Float.parseFloat( mEdtSpinerHeightWithIn.getText().toString());
            return Double.parseDouble((fit*30.48)+(in*2.54)+"");
        }
    }

    @Override
    public void onClick(View v) {
        if (!hideViewDropDownSpiner()) {
            switch (v.getId()) {
                case R.id.layout_spinner_height:
                    mLayoutDropDownSpinerWeight.setVisibility(View.GONE);
                    if (mLayoutDropDownSpinerHeight.getVisibility() == View.VISIBLE) {
                        mLayoutDropDownSpinerHeight.animate()
                                .translationY(0)
                                .alpha(0.0f)
                                .setDuration(300)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        mLayoutDropDownSpinerHeight.setVisibility(View.GONE);
                                    }
                                });
                    } else {
                        mLayoutDropDownSpinerHeight.setVisibility(View.VISIBLE);
                        mLayoutDropDownSpinerHeight.setAlpha(0.0f);
                        mLayoutDropDownSpinerHeight.animate()
                                .alpha(1.0f)
                                .setDuration(300)
                                .setListener(null);
                    }

                    break;
                case R.id.layout_spinner_weight:
                    mLayoutDropDownSpinerHeight.setVisibility(View.GONE);
                    if (mLayoutDropDownSpinerWeight.getVisibility() == View.VISIBLE) {
                        mLayoutDropDownSpinerWeight.animate()
                                .translationY(0)
                                .alpha(0.0f)
                                .setDuration(300)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        mLayoutDropDownSpinerWeight.setVisibility(View.GONE);
                                    }
                                });
                    } else {
                        mLayoutDropDownSpinerWeight.setVisibility(View.VISIBLE);
                        mLayoutDropDownSpinerWeight.setAlpha(0.0f);
                        mLayoutDropDownSpinerWeight.animate()
                                .alpha(1.0f)
                                .setDuration(300)
                                .setListener(null);
                    }

                    break;
                case R.id.bmi_back_img:
                    finish();
                    break;
                case R.id.btn_number_zero:
                    appendTextInEdtForcus("0",1);
                    break;
                case R.id.btn_number_one:
                    appendTextInEdtForcus("1",1);
                    break;
                case R.id.btn_number_two:
                    appendTextInEdtForcus("2",1);
                    break;
                case R.id.btn_number_three:
                    appendTextInEdtForcus("3",1);
                    break;
                case R.id.btn_number_four:
                    appendTextInEdtForcus("4",1);
                    break;
                case R.id.btn_number_five:
                    appendTextInEdtForcus("5",1);
                    break;
                case R.id.btn_number_six:
                    appendTextInEdtForcus("6",1);
                    break;
                case R.id.btn_number_seven:
                    appendTextInEdtForcus("7",1);
                    break;
                case R.id.btn_number_eight:
                    appendTextInEdtForcus("8",1);
                    break;
                case R.id.btn_number_nine:
                    appendTextInEdtForcus("9",1);
                    break;
                case R.id.btn_dot:
                    appendTextInEdtForcus(".",1);
                    break;
                case R.id.btn_clear_text:
                    int selectionEnd = mEditTextForcus.getSelectionEnd();
                    int length = mEditTextForcus.getText().toString().length();
                    if (length > 0 && selectionEnd > 0){
                      if (selectionEnd == length){
                            String substring = mEditTextForcus.getText().toString().substring(0, length-1);
                            mEditTextForcus.setText(substring);
                        }else {
                            String startString = mEditTextForcus.getText().toString().substring(0, selectionEnd-1);
                            String endString = mEditTextForcus.getText().toString().substring(selectionEnd, length);
                            mEditTextForcus.setText(startString+endString);
                        }
                        mEditTextForcus.setSelection(selectionEnd-1);
                    }
                    break;
                case R.id.bmi_img_question:
                    FragmentManager fm = getSupportFragmentManager();
                    DialogQuestionFragment dialogFragment = new DialogQuestionFragment();
                    if (!dialogFragment.isHidden()) {
                        dialogFragment.show(fm, "DialogQuestionFragment");
                    }
                    break;

//                mEdtSpinerHeightWithCm = findViewById(R.id.edt_spiner_height_with_cm);
//                mEdtSpinerHeightWithFt = findViewById(R.id.edt_spiner_height_with_ft);
//                mEdtSpinerHeightWithIn = findViewById(R.id.edt_spiner_height_with_in);
//                mEdtSpinerWeightWithKg = findViewById(R.id.edt_spiner_weight_with_kg);
//                mEdtSpinerWeightWithLb = findViewById(R.id.edt_spiner_weight_with_lb);
//                mEdtSpinerWeightWithSt = findViewById(R.id.edt_spiner_weight_with_st);
//                mEdtSpinerWeightWithStLb = findViewById(R.id.edt_spiner_weight_with_stlb);
                case R.id.edt_spiner_height_with_cm:
                   StaticFuncition.hideKeyboard(this);
                    break;
                case R.id.edt_spiner_height_with_ft:
                    StaticFuncition.hideKeyboard(this);
                    break;
                case R.id.edt_spiner_height_with_in:
                    StaticFuncition.hideKeyboard(this);
                    break;
                case R.id.edt_spiner_weight_with_kg:
                    StaticFuncition.hideKeyboard(this);
                    break;
                case R.id.edt_spiner_weight_with_lb:
                    StaticFuncition.hideKeyboard(this);
                    break;
                case R.id.edt_spiner_weight_with_st:
                    StaticFuncition.hideKeyboard(this);
                    break;
                case R.id.edt_spiner_weight_with_stlb:
                    StaticFuncition.hideKeyboard(this);
                    break;
            }
        } else {
            switch (v.getId()) {
                case R.id.spiner_height_txt_cm:
                    showEditTextWithHeight("cm", UtilsString.STYLE_HEIGHT_CM);
                    break;
                case R.id.spiner_height_txt_ft:
                    showEditTextWithHeight("ft+in", UtilsString.STYLE_HEIGHT_FT);
                    break;
                case R.id.spiner_weight_txt_kg:
                    showEditTextWithWeight("kg", UtilsString.STYLE_WEIGHT_KG);
                    break;
                case R.id.spiner_weight_txt_lb:
                    showEditTextWithWeight("lb", UtilsString.STYLE_WEIGHT_LB);
                    break;
                case R.id.spiner_weight_txt_st:
                    showEditTextWithWeight("st+lb", UtilsString.STYLE_WEIGHT_SBLT);
                    break;
            }
        }
    }
    public void appendTextInEdtForcus(String appendText,int selectAdd){
        int selectionEnd = mEditTextForcus.getSelectionEnd();
        int length = mEditTextForcus.getText().toString().length();
        if (selectionEnd == 0){
            String substring = mEditTextForcus.getText().toString().substring(selectionEnd, length);
            mEditTextForcus.setText(appendText+substring);
        }else if (selectionEnd == length){
            String substring = mEditTextForcus.getText().toString().substring(0, length);
            mEditTextForcus.setText(substring+appendText);
        }else {
            String startString = mEditTextForcus.getText().toString().substring(0, selectionEnd);
            String endString = mEditTextForcus.getText().toString().substring(selectionEnd, length);
            mEditTextForcus.setText(startString+appendText+endString);
        }
        mEditTextForcus.setSelection(selectionEnd+selectAdd);
    }

    public boolean hideViewDropDownSpiner() {
        if (mLayoutDropDownSpinerHeight.getVisibility() == View.VISIBLE || mLayoutDropDownSpinerWeight.getVisibility() == View.VISIBLE) {
            mLayoutDropDownSpinerHeight.setVisibility(View.GONE);
            mLayoutDropDownSpinerWeight.setVisibility(View.GONE);
            return true;
        } else {
            return false;
        }
    }

    public void showEditTextWithHeight(String txtSpiner, int style) {
        mTxtMainSpinerHeight.setText(txtSpiner);
        switch (style) {
            case UtilsString.STYLE_HEIGHT_CM:
                mEdtSpinerHeightWithCm.setVisibility(View.VISIBLE);
                mEdtSpinerHeightWithCm.requestFocus();
                mEditTextForcus = mEdtSpinerHeightWithCm;
                mEdtSpinerHeightWithFt.setText("");
                mEdtSpinerHeightWithIn.setText("");
                break;
            case UtilsString.STYLE_HEIGHT_FT:
                if (mEdtSpinerHeightWithCm.getVisibility() == View.VISIBLE) {
                    mEdtSpinerHeightWithFt.requestFocus();
                    mEditTextForcus = mEdtSpinerHeightWithFt;
                }
                mEdtSpinerHeightWithCm.setVisibility(View.INVISIBLE);
                mEdtSpinerHeightWithCm.setText("");
                break;
        }

    }

    public void showEditTextWithWeight(String txtSpiner, int style) {
        mTxtMainSpinerWeight.setText(txtSpiner);
        switch (style) {
            case UtilsString.STYLE_WEIGHT_KG:
                mEdtSpinerWeightWithLb.setText("");
                mEdtSpinerWeightWithSt.setText("");
                mEdtSpinerWeightWithStLb.setText("");
                mEdtSpinerWeightWithKg.setVisibility(View.VISIBLE);
                mEdtSpinerWeightWithLb.setVisibility(View.INVISIBLE);
                mEdtSpinerWeightWithKg.requestFocus();
                mEditTextForcus = mEdtSpinerWeightWithKg;
                break;
            case UtilsString.STYLE_WEIGHT_LB:
                mEdtSpinerWeightWithKg.setText("");
                mEdtSpinerWeightWithSt.setText("");
                mEdtSpinerWeightWithStLb.setText("");
                mEdtSpinerWeightWithLb.setVisibility(View.VISIBLE);
                mEdtSpinerWeightWithKg.setVisibility(View.INVISIBLE);
                mEdtSpinerWeightWithLb.requestFocus();
                mEditTextForcus = mEdtSpinerWeightWithLb;
                break;
            case UtilsString.STYLE_WEIGHT_SBLT:
                mEdtSpinerWeightWithLb.setText("");
                mEdtSpinerWeightWithKg.setText("");
                mEdtSpinerWeightWithLb.setVisibility(View.INVISIBLE);
                mEdtSpinerWeightWithKg.setVisibility(View.INVISIBLE);
                mEdtSpinerWeightWithSt.requestFocus();
                mEditTextForcus = mEdtSpinerWeightWithSt;
                break;
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int inType = mEdtSpinerHeightWithCm.getInputType();
        //                mEdtSpinerHeightWithCm = findViewById(R.id.edt_spiner_height_with_cm);
//                mEdtSpinerHeightWithFt = findViewById(R.id.edt_spiner_height_with_ft);
//                mEdtSpinerHeightWithIn = findViewById(R.id.edt_spiner_height_with_in);
//                mEdtSpinerWeightWithKg = findViewById(R.id.edt_spiner_weight_with_kg);
//                mEdtSpinerWeightWithLb = findViewById(R.id.edt_spiner_weight_with_lb);
//                mEdtSpinerWeightWithSt = findViewById(R.id.edt_spiner_weight_with_st);
//                mEdtSpinerWeightWithStLb = findViewById(R.id.edt_spiner_weight_with_stlb);
        switch (v.getId()){
            case R.id.edt_spiner_height_with_cm:
                mEditTextForcus = mEdtSpinerHeightWithCm;
                mEdtSpinerHeightWithCm.setInputType(InputType.TYPE_NULL); // disable soft input
                mEdtSpinerHeightWithCm.onTouchEvent(event); // call native handler
                mEdtSpinerHeightWithCm.setInputType(inType); // restore input type
                break;
            case R.id.edt_spiner_height_with_ft:
                mEditTextForcus = mEdtSpinerHeightWithFt;
                mEdtSpinerHeightWithFt.setInputType(InputType.TYPE_NULL); // disable soft input
                mEdtSpinerHeightWithFt.onTouchEvent(event); // call native handler
                mEdtSpinerHeightWithFt.setInputType(inType); // restore input type
                break;
            case R.id.edt_spiner_height_with_in:
                mEditTextForcus = mEdtSpinerHeightWithIn;
                mEdtSpinerHeightWithIn.setInputType(InputType.TYPE_NULL); // disable soft input
                mEdtSpinerHeightWithIn.onTouchEvent(event); // call native handler
                mEdtSpinerHeightWithIn.setInputType(inType); // restore input type
                break;
            case R.id.edt_spiner_weight_with_kg:
                mEditTextForcus = mEdtSpinerWeightWithKg;
                mEdtSpinerWeightWithKg.setInputType(InputType.TYPE_NULL); // disable soft input
                mEdtSpinerWeightWithKg.onTouchEvent(event); // call native handler
                mEdtSpinerWeightWithKg.setInputType(inType); // restore input type
                break;
            case R.id.edt_spiner_weight_with_lb:
                mEditTextForcus = mEdtSpinerWeightWithLb;
                mEdtSpinerWeightWithLb.setInputType(InputType.TYPE_NULL); // disable soft input
                mEdtSpinerWeightWithLb.onTouchEvent(event); // call native handler
                mEdtSpinerWeightWithLb.setInputType(inType); // restore input type
                break;
            case R.id.edt_spiner_weight_with_st:
                mEditTextForcus = mEdtSpinerWeightWithSt;
                mEdtSpinerWeightWithSt.setInputType(InputType.TYPE_NULL); // disable soft input
                mEdtSpinerWeightWithSt.onTouchEvent(event); // call native handler
                mEdtSpinerWeightWithSt.setInputType(inType); // restore input type
                break;
            case R.id.edt_spiner_weight_with_stlb:
                mEditTextForcus = mEdtSpinerWeightWithStLb;
                mEdtSpinerWeightWithStLb.setInputType(InputType.TYPE_NULL); // disable soft input
                mEdtSpinerWeightWithStLb.onTouchEvent(event); // call native handler
                mEdtSpinerWeightWithStLb.setInputType(inType); // restore input type
                break;
        }
        return false;
    }
}
