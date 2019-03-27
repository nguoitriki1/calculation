package com.tapi.mathcalculator.ui.bmi;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.ui.keyboard.IKeyBoard;
import com.tapi.mathcalculator.utils.UtilsString;

public class BmiResultView extends ConstraintLayout implements View.OnTouchListener {
    private EditText mEdtHeightcm, mEdtHeightft, mEdtHeightin, mEdtWeightkg, mEdtWeightlb, mEdtWeightlbst, mEdtWeightst;
    private TextView mCommaHeight1, mCommaHeight2, mCommaWeight1, mCommaWeight2;
    private EditText mEdtCurentforcus;

    public BmiResultView(Context context) {
        super(context);
    }

    public BmiResultView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mEdtHeightcm = findViewById(R.id.bmi_edt_height);
        mEdtHeightft = findViewById(R.id.bmi_edt_height_ft);
        mEdtHeightin = findViewById(R.id.bmi_edt_height_in);
        mEdtWeightkg = findViewById(R.id.bmi_edt_weight);
        mEdtWeightlb = findViewById(R.id.bmi_edt_weight_lb);
        mEdtWeightlbst = findViewById(R.id.bmi_edt_weight_lbst);
        mEdtWeightst = findViewById(R.id.bmi_edt_weight_st);
        mCommaHeight1 = findViewById(R.id.bmi_height_comma1);
        mCommaHeight2 = findViewById(R.id.bmi_height_comma2);
        mCommaWeight1 = findViewById(R.id.bmi_weight_comma1);
        mCommaWeight2 = findViewById(R.id.bmi_weight_comma2);
        mEdtHeightcm.requestFocus();
        mEdtCurentforcus = mEdtHeightcm;
        mEdtHeightcm.setOnTouchListener(this);
        mEdtHeightft.setOnTouchListener(this);
        mEdtHeightin.setOnTouchListener(this);
        mEdtWeightkg.setOnTouchListener(this);
        mEdtWeightlb.setOnTouchListener(this);
        mEdtWeightlbst.setOnTouchListener(this);
        mEdtWeightst.setOnTouchListener(this);
    }
    public void showEditTextToStyle(int style){
        switch (style){
            case UtilsString.STYLE_HEIGHT_CM:
                mEdtHeightcm.setVisibility(VISIBLE);
                mEdtHeightft.setVisibility(INVISIBLE);
                mEdtHeightft.setText("");
                mEdtHeightin.setVisibility(INVISIBLE);
                mEdtHeightin.setText("");
                mCommaHeight1.setVisibility(INVISIBLE);
                mCommaHeight2.setVisibility(INVISIBLE);
                mEdtHeightcm.requestFocus();
                mEdtCurentforcus = mEdtHeightcm;
                break;
            case UtilsString.STYLE_HEIGHT_FT:
                mEdtHeightft.setVisibility(VISIBLE);
                mEdtHeightin.setVisibility(VISIBLE);
                mCommaHeight1.setVisibility(VISIBLE);
                mCommaHeight2.setVisibility(VISIBLE);
                mEdtHeightcm.setVisibility(INVISIBLE);
                mEdtHeightcm.setText("");
                mEdtHeightin.requestFocus();
                mEdtCurentforcus = mEdtHeightin;
                break;
            case UtilsString.STYLE_WEIGHT_KG:
                mEdtWeightkg.setVisibility(VISIBLE);
                mEdtWeightlb.setVisibility(INVISIBLE);
                mEdtWeightlb.setText("");
                mEdtWeightlbst.setVisibility(INVISIBLE);
                mEdtWeightlbst.setText("");
                mEdtWeightst.setVisibility(INVISIBLE);
                mEdtWeightst.setText("");
                mCommaWeight1.setVisibility(INVISIBLE);
                mCommaWeight2.setVisibility(INVISIBLE);
                mEdtWeightkg.requestFocus();
                mEdtCurentforcus = mEdtWeightkg;
                break;
            case UtilsString.STYLE_WEIGHT_LB:
                mEdtWeightlb.setVisibility(VISIBLE);
                mEdtWeightkg.setVisibility(INVISIBLE);
                mEdtWeightkg.setText("");
                mEdtWeightlbst.setVisibility(INVISIBLE);
                mEdtWeightlbst.setText("");
                mEdtWeightst.setVisibility(INVISIBLE);
                mEdtWeightst.setText("");
                mCommaWeight1.setVisibility(INVISIBLE);
                mCommaWeight2.setVisibility(INVISIBLE);
                mEdtWeightlb.requestFocus();
                mEdtCurentforcus = mEdtWeightlb;
                break;
            case UtilsString.STYLE_WEIGHT_LBST:
                mEdtWeightlbst.setVisibility(VISIBLE);
                mEdtWeightst.setVisibility(VISIBLE);
                mEdtWeightkg.setVisibility(INVISIBLE);
                mEdtWeightkg.setText("");
                mEdtWeightlb.setVisibility(INVISIBLE);
                mEdtWeightlb.setText("");
                mCommaWeight1.setVisibility(VISIBLE);
                mCommaWeight2.setVisibility(VISIBLE);
                mEdtWeightlbst.requestFocus();
                mEdtCurentforcus = mEdtWeightlbst;
                break;
        }
    }

    public void addKey(IKeyBoard.Key key) {
        int selectionEnd = mEdtCurentforcus.getSelectionEnd();
        int selectionStart = mEdtCurentforcus.getSelectionStart();
        String outText = key.outText;
        insertIntext(outText, selectionStart, selectionEnd);
    }

    private void insertIntext(String outText, int selectionStart, int selectionEnd) {
        StringBuilder buffer = new StringBuilder(mEdtCurentforcus.getText());
        if (selectionEnd == selectionStart) {
            buffer.insert(selectionStart, outText);
            mEdtCurentforcus.setText(buffer.toString());
            mEdtCurentforcus.setSelection(selectionStart + outText.length());
        } else {
            buffer.replace(selectionStart, selectionEnd, outText);
            mEdtCurentforcus.setText(buffer.toString());
            mEdtCurentforcus.setSelection(selectionStart + outText.length());
        }
        culatorResultBMI();
    }

    private String culatorResultBMI() {
        String s ="0";
        try {
            double height = culatorHeight();
            double weight = culatorWeight();

        }catch (Exception e){

        }
        return s;
    }

    private double culatorWeight() {
        return 0;
    }

    private double culatorHeight() {
        return 0;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.bmi_edt_height:
                mEdtCurentforcus = mEdtHeightcm;
                break;
            case R.id.bmi_edt_height_ft:
                mEdtCurentforcus = mEdtHeightft;
                break;
            case R.id.bmi_edt_height_in:
                mEdtCurentforcus = mEdtHeightin;
                break;
            case R.id.bmi_edt_weight:
                mEdtCurentforcus = mEdtWeightkg;
                break;
            case R.id.bmi_edt_weight_lb:
                mEdtCurentforcus = mEdtWeightlb;
                break;
            case R.id.bmi_edt_weight_lbst:
                mEdtCurentforcus = mEdtWeightlbst;
                break;
            case R.id.bmi_edt_weight_st:
                mEdtCurentforcus = mEdtWeightst;
                break;
        }
        return false;
    }
}
