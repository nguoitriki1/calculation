package com.tapi.mathcalculator.ui.bmi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.ui.keyboard.IKeyBoard;
import com.tapi.mathcalculator.utils.Utils;
import com.tapi.mathcalculator.utils.UtilsString;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BmiResultView extends ConstraintLayout implements View.OnTouchListener, TextWatcher {
    private EditText mEdtHeightcm, mEdtHeightft, mEdtHeightin, mEdtWeightkg, mEdtWeightlb, mEdtWeightlbst, mEdtWeightst;
    private TextView mCommaHeight1, mCommaHeight2, mCommaWeight1, mCommaWeight2, mTxtResultBMI, mTxtDialogResult;
    private EditText mEdtCurentforcus;
    private ConstraintLayout mLayoutTxtResultBMI;

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
        mTxtResultBMI = findViewById(R.id.bmi_txt_result_bmi);
        mLayoutTxtResultBMI = findViewById(R.id.bmi_layout_txt_result_dialog);
        mTxtDialogResult = findViewById(R.id.bmi_dialog_result_txt);
        mEdtHeightcm.requestFocus();
        mEdtCurentforcus = mEdtHeightcm;
        mEdtHeightcm.addTextChangedListener(this);
        mEdtHeightft.addTextChangedListener(this);
        mEdtHeightin.addTextChangedListener(this);
        mEdtWeightkg.addTextChangedListener(this);
        mEdtWeightlb.addTextChangedListener(this);
        mEdtWeightlbst.addTextChangedListener(this);
        mEdtWeightst.addTextChangedListener(this);
        mEdtHeightcm.setOnTouchListener(this);
        mEdtHeightft.setOnTouchListener(this);
        mEdtHeightin.setOnTouchListener(this);
        mEdtWeightkg.setOnTouchListener(this);
        mEdtWeightlb.setOnTouchListener(this);
        mEdtWeightlbst.setOnTouchListener(this);
        mEdtWeightst.setOnTouchListener(this);
    }

    public void showEditTextToStyle(int style) {
        switch (style) {
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
    }

    @SuppressLint("DefaultLocale")
    private String culatorResultBMI() {
        String s = "0";
        try {
            double height = culatorHeight();
            double weight = culatorWeight();
            Log.d("height", "height: " + height);
            Log.d("height", "weight: " + weight);
            if (height != 0 && weight != 0) {
                double totalResult = weight / (height * height) * 10000;
                if (totalResult > 0) {
                    if (totalResult > Integer.MAX_VALUE) {
                        totalResult = Integer.MAX_VALUE;
                        mLayoutTxtResultBMI.setVisibility(INVISIBLE);
                    } else if (totalResult >= 10 && totalResult < 18) {
                        //underweight
                        mLayoutTxtResultBMI.setVisibility(VISIBLE);
                        mTxtDialogResult.setText(getContext().getString(R.string.underweight));
                    } else if (totalResult >= 18 && totalResult < 25) {
                        //healthy
                        mLayoutTxtResultBMI.setVisibility(VISIBLE);
                        mTxtDialogResult.setText(getContext().getString(R.string.healthy));
                    } else if (totalResult >= 25 && totalResult < 30) {
                        //overweight
                        mLayoutTxtResultBMI.setVisibility(VISIBLE);
                        mTxtDialogResult.setText(getContext().getString(R.string.overweight));
                    } else if (totalResult >= 30 && totalResult < 100) {
                        //obese
                        mLayoutTxtResultBMI.setVisibility(VISIBLE);
                        mTxtDialogResult.setText(getContext().getString(R.string.obese));
                    } else {
                        mLayoutTxtResultBMI.setVisibility(INVISIBLE);
                    }
                }
                DecimalFormat df = new DecimalFormat("#.#");
                df.setRoundingMode(RoundingMode.CEILING);
                s = df.format(totalResult);

            }
        } catch (Exception e) {
            return "";
        }
        return s;
    }

    //1 lb = 0.45359237 kg
    //1 st = 6.35 kg
    private double culatorWeight() {
        if (!TextUtils.isEmpty(mEdtWeightkg.getText())) {
            return Double.parseDouble(mEdtWeightkg.getText().toString());
        } else if (!TextUtils.isEmpty(mEdtWeightlb.getText().toString())) {
            return Double.parseDouble(mEdtWeightlb.getText().toString()) * 0.45359237;
        } else if (!TextUtils.isEmpty(mEdtWeightlbst.getText()) || !TextUtils.isEmpty(mEdtWeightst.getText())) {
            double totalSt = 0;
            double totalLbst = 0;
            if (!TextUtils.isEmpty(mEdtWeightst.getText().toString())) {
                totalSt = Double.parseDouble(mEdtWeightst.getText().toString()) * 6.35;
            }
            if (!TextUtils.isEmpty(mEdtWeightlbst.getText().toString())) {
                totalLbst = Double.parseDouble(mEdtWeightlbst.getText().toString()) * 0.45359237;
            }
            return totalSt + totalLbst;
        } else {
            return 0;
        }
    }

    //    1 ft = 30.48 cm
    //    1 in = 2.54 cm
    private double culatorHeight() {
        if (!TextUtils.isEmpty(mEdtHeightcm.getText())) {
            return Double.parseDouble(mEdtHeightcm.getText().toString());
        } else if (!TextUtils.isEmpty(mEdtHeightft.getText()) || !TextUtils.isEmpty(mEdtHeightin.getText())) {
            double totalIn = 0;
            double totalFt = 0;
            if (!TextUtils.isEmpty(mEdtHeightft.getText())) {
                totalFt = Double.parseDouble(mEdtHeightft.getText().toString()) * 30.48;
            }
            if (!TextUtils.isEmpty(mEdtHeightin.getText())) {
                totalIn = Double.parseDouble(mEdtHeightin.getText().toString()) * 2.54;
            }
            return totalFt + totalIn;
        } else {
            return 0;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
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

    public void removeAllKey() {
        if (mEdtCurentforcus.length() > 0) {
            mEdtCurentforcus.setText("");
        }
    }

    public void removeKey() {
        if (mEdtCurentforcus.length() > 0) {
            int selectionStart = mEdtCurentforcus.getSelectionStart();
            if (selectionStart > 0) {
                mEdtCurentforcus.setText((Spanned) mEdtCurentforcus.getText().delete(selectionStart - 1, selectionStart));
                mEdtCurentforcus.setSelection(selectionStart - 1);
            }
        }
    }

    public void insertPoint(IKeyBoard.Key key) {
        String outText = key.outText;
        int selectionStart = mEdtCurentforcus.getSelectionStart();
        int selectionEnd = mEdtCurentforcus.getSelectionEnd();

        // them so 0 khi them dau .
        if (selectionStart == 0) {
            insertIntext("0" + outText, selectionStart, selectionEnd);
        } else {
            if (!mEdtCurentforcus.getText().toString().substring(0, selectionStart).contains(".")) {
                if (!Utils.checkIsNumber(mEdtCurentforcus.getText().charAt(selectionEnd - 1))) {
                    insertIntext("0" + outText, selectionStart, selectionEnd);
                } else {
                    insertIntext(outText, selectionStart, selectionEnd);
                }
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        mTxtResultBMI.setText(culatorResultBMI());
    }
}
