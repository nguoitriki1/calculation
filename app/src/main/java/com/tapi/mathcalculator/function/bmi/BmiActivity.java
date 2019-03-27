package com.tapi.mathcalculator.function.bmi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.ui.bmi.BmiKeyboardView;
import com.tapi.mathcalculator.ui.bmi.BmiResultView;
import com.tapi.mathcalculator.ui.keyboard.IKeyBoard;
import com.tapi.mathcalculator.utils.UtilsString;

public class BmiActivity extends AppCompatActivity implements View.OnClickListener {
    private BmiKeyboardView mBmiKeyboardView;
    private BmiResultView mBmiResultView;
    private ImageView mBtnBack;
    private TextView mSpinerHeightTxtCm, mSpinerHeightTxtFtin, mSpinerWeightTxtkg, mSpinerWeightTxtlb, mSpinerHeightTxtlbst,mTxtSpinerHeight,mTxtSpinerWeight;
    private ConstraintLayout mSpinerHeight, mSpinerWeight, mSpinerHeightDialog, mSpinerWeightDialog, mBmiLayoutParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM, WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        setContentView(R.layout.bmi_activity);
        funFindViewbyId();
        setClickView();
        initView();
    }

    private void setClickView() {
        mBmiLayoutParent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideViewDropDownSpiner();
                mBmiLayoutParent.setVisibility(View.GONE);
                return false;
            }
        });
        mSpinerHeight.setOnClickListener(this);
        mSpinerWeight.setOnClickListener(this);
        mSpinerHeightTxtCm.setOnClickListener(this);
        mSpinerHeightTxtFtin.setOnClickListener(this);
        mSpinerWeightTxtkg.setOnClickListener(this);
        mSpinerWeightTxtlb.setOnClickListener(this);
        mSpinerHeightTxtlbst.setOnClickListener(this);

    }

    private void funFindViewbyId() {
        mBmiKeyboardView = findViewById(R.id.bmi_keyboard_view);
        mBmiResultView = findViewById(R.id.bmi_result_view);
        mBtnBack = findViewById(R.id.bmi_back_btn);
        mSpinerHeight = findViewById(R.id.bmi_spinner_height);
        mSpinerWeight = findViewById(R.id.bmi_spinner_weight);
        mSpinerHeightDialog = findViewById(R.id.bmi_spiner_dialog_layout_height);
        mSpinerWeightDialog = findViewById(R.id.bmi_spiner_dialog_layout_weight);
        mSpinerHeightTxtCm = findViewById(R.id.bmi_spiner_height_txt_cm);
        mSpinerHeightTxtFtin = findViewById(R.id.bmi_spiner_height_txt_ftin);
        mSpinerWeightTxtkg = findViewById(R.id.bmi_spiner_weight_txt_kg);
        mSpinerWeightTxtlb = findViewById(R.id.bmi_spiner_weight_txt_lb);
        mSpinerHeightTxtlbst = findViewById(R.id.bmi_spiner_weight_txt_stlb);
        mTxtSpinerHeight = findViewById(R.id.bmi_spiner_height_txt_spiner);
        mTxtSpinerWeight = findViewById(R.id.bmi_spiner_weight_txt_spiner);
        mBmiLayoutParent = findViewById(R.id.bmi_layout_parent);
    }

    private void initView() {
        mBtnBack.setOnClickListener(this);
        mBmiKeyboardView.setOnKeyboardOnClickListener(new IKeyBoard.OnKeyboardOnClickListener() {
            @Override
            public void onKeyEventClick(View view, IKeyBoard.Event event, IKeyBoard.Key key) {
                switch (key) {
                    case point:
                        break;
                    case back:
                        break;
                    default:
                        mBmiResultView.addKey(key);
                        break;
                }
            }

            @Override
            public void onKeyEventLongClick(View view, IKeyBoard.Event event, IKeyBoard.Key key) {

            }
        });
    }

    private void hideViewDropDownSpiner() {
        mBmiLayoutParent.setVisibility(View.GONE);
        if (mSpinerHeightDialog.getVisibility() == View.VISIBLE) {
            mSpinerHeightDialog.setAlpha(1.0f);
            mSpinerHeightDialog.animate()
                    .alpha(0.0f)
                    .setDuration(300)
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            mSpinerHeightDialog.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
        }
        if (mSpinerWeightDialog.getVisibility() == View.VISIBLE) {
            mSpinerWeightDialog.setAlpha(1.0f);
            mSpinerWeightDialog.animate()
                    .alpha(0.0f)
                    .setDuration(300)
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            mSpinerWeightDialog.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bmi_spiner_height_txt_cm:
                spinerTxtClick(mTxtSpinerHeight,getString(R.string.cm),UtilsString.STYLE_HEIGHT_CM);
                break;
            case R.id.bmi_spiner_height_txt_ftin:
                spinerTxtClick(mTxtSpinerHeight,getString(R.string.ft_in),UtilsString.STYLE_HEIGHT_FT);
                break;
            case R.id.bmi_spiner_weight_txt_kg:
                spinerTxtClick(mTxtSpinerWeight,getString(R.string.kg),UtilsString.STYLE_WEIGHT_KG);
                break;
            case R.id.bmi_spiner_weight_txt_lb:
                spinerTxtClick(mTxtSpinerWeight,getString(R.string.lb),UtilsString.STYLE_WEIGHT_LB);
                break;
            case R.id.bmi_spiner_weight_txt_stlb:
                spinerTxtClick(mTxtSpinerWeight,getString(R.string.st_lb),UtilsString.STYLE_WEIGHT_LBST);
                break;
            case R.id.bmi_back_btn:
                finish();
                break;
            case R.id.bmi_spinner_height:
                mSpinerWeightDialog.setVisibility(View.INVISIBLE);
                mBmiLayoutParent.setVisibility(View.VISIBLE);
                mSpinerHeightDialog.setVisibility(View.VISIBLE);
                mSpinerHeightDialog.setAlpha(0.0f);
                mSpinerHeightDialog.animate().alpha(1.0f).setDuration(300)
                        .setListener(null);
                break;
            case R.id.bmi_spinner_weight:
                mBmiLayoutParent.setVisibility(View.VISIBLE);
                mSpinerHeightDialog.setVisibility(View.INVISIBLE);
                mSpinerWeightDialog.setVisibility(View.VISIBLE);
                mSpinerWeightDialog.setAlpha(0.0f);
                mSpinerWeightDialog.animate()
                        .alpha(1.0f)
                        .setDuration(300)
                        .setListener(null);
                break;
        }
    }

    public boolean checkHideViewDropDownSpiner() {
        return mSpinerHeightDialog.getVisibility() == View.VISIBLE || mSpinerWeightDialog.getVisibility() == View.VISIBLE;
    }
    public void spinerTxtClick(TextView textView,String text ,int style){
        hideViewDropDownSpiner();
        textView.setText(text);
        mBmiResultView.showEditTextToStyle(style);
    }
}
