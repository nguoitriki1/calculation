package com.tapi.mathcalculator.fragment.calculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tapi.mathcalculator.R;

public class FragmentPageSpreadsheetOne extends Fragment implements View.OnClickListener {
    private TextView mBtnPrecent, mBtnOpenBrackets, mBtnCloseBrackets, mBtnDivision, mBtnMultiplication, mBtnSubtraction, mBtnAdd, mBtnSumary, mBtnZero, mBtnOne, mBtnTwo, mBtnThree, mBtnFour, mBtnFive, mBtnSix, mBtnSeven, mBtnEight, mBtnNine, mBtnDot;
    private ImageView mBtnClearText;
    private EditText mEdtResultMain;
    private TextView mTxtResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_spread_sheet_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mBtnPrecent = view.findViewById(R.id.btn_percent);
        mBtnOpenBrackets = view.findViewById(R.id.btn_open_brackets);
        mBtnCloseBrackets = view.findViewById(R.id.btn_close_brackets);
        mBtnDivision = view.findViewById(R.id.btn_division);
        mBtnMultiplication = view.findViewById(R.id.btn_multiplication);
        mBtnSubtraction = view.findViewById(R.id.btn_subtraction);
        mBtnAdd = view.findViewById(R.id.btn_add);
        mBtnSumary = view.findViewById(R.id.btn_summary);
        mBtnZero = view.findViewById(R.id.btn_number_zero);
        mBtnOne = view.findViewById(R.id.btn_number_one);
        mBtnTwo = view.findViewById(R.id.btn_number_two);
        mBtnThree = view.findViewById(R.id.btn_number_three);
        mBtnFour = view.findViewById(R.id.btn_number_four);
        mBtnFive = view.findViewById(R.id.btn_number_five);
        mBtnSix = view.findViewById(R.id.btn_number_six);
        mBtnSeven = view.findViewById(R.id.btn_number_seven);
        mBtnEight = view.findViewById(R.id.btn_number_eight);
        mBtnNine = view.findViewById(R.id.btn_number_nine);
        mBtnDot = view.findViewById(R.id.btn_dot);
        mBtnClearText = view.findViewById(R.id.btn_clear_text);
        if (getActivity() != null) {
            mEdtResultMain = getActivity().findViewById(R.id.calculator_edt_result);
            mTxtResult = getActivity().findViewById(R.id.calculator_txt_result);
        }
        setClickButton();
    }

    private void setClickButton() {
        mBtnPrecent.setOnClickListener(this);
        mBtnOpenBrackets.setOnClickListener(this);
        mBtnCloseBrackets.setOnClickListener(this);
        mBtnDivision.setOnClickListener(this);
        mBtnMultiplication.setOnClickListener(this);
        mBtnSubtraction.setOnClickListener(this);
        mBtnAdd.setOnClickListener(this);
        mBtnSumary.setOnClickListener(this);
        mBtnZero.setOnClickListener(this);
        mBtnOne.setOnClickListener(this);
        mBtnTwo.setOnClickListener(this);
        mBtnThree.setOnClickListener(this);
        mBtnFour.setOnClickListener(this);
        mBtnFive.setOnClickListener(this);
        mBtnSix.setOnClickListener(this);
        mBtnSeven.setOnClickListener(this);
        mBtnEight.setOnClickListener(this);
        mBtnNine.setOnClickListener(this);
        mBtnDot.setOnClickListener(this);
        mBtnClearText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mEdtResultMain != null && mTxtResult != null) {
            switch (v.getId()) {
                case R.id.btn_percent:
                    appendTextInEdtResult("%");
                    break;
                case R.id.btn_open_brackets:
                    appendTextInEdtResult("(");
                    break;
                case R.id.btn_close_brackets:
                    appendTextInEdtResult(")");
                    break;
                case R.id.btn_division:
                    appendTextInEdtResult("/");
                    break;
                case R.id.btn_multiplication:
                    appendTextInEdtResult("x");
                    break;
                case R.id.btn_subtraction:
                    appendTextInEdtResult("-");
                    break;
                case R.id.btn_add:
                    appendTextInEdtResult("+");
                    break;
                case R.id.btn_summary:

                    break;
                case R.id.btn_number_zero:
                    appendTextInEdtResult("0");
                    break;
                case R.id.btn_number_one:
                    appendTextInEdtResult("1");
                    break;
                case R.id.btn_number_two:
                    appendTextInEdtResult("2");
                    break;
                case R.id.btn_number_three:
                    appendTextInEdtResult("3");
                    break;
                case R.id.btn_number_four:
                    appendTextInEdtResult("4");
                    break;
                case R.id.btn_number_five:
                    appendTextInEdtResult("5");
                    break;
                case R.id.btn_number_six:
                    appendTextInEdtResult("6");
                    break;
                case R.id.btn_number_seven:
                    appendTextInEdtResult("7");
                    break;
                case R.id.btn_number_eight:
                    appendTextInEdtResult("8");
                    break;
                case R.id.btn_number_nine:
                    appendTextInEdtResult("9");
                    break;
                case R.id.btn_dot:
                    appendTextInEdtResult(".");
                    break;
                case R.id.btn_clear_text:
                    try{
                        int selectionEnd = mEdtResultMain.getSelectionEnd();
                        int length = mEdtResultMain.getText().toString().length();
                        String subStart = mEdtResultMain.getText().toString().substring(0, selectionEnd-1);
                        if (subStart.length() < length) {
                            String substringend = mEdtResultMain.getText().toString().substring(selectionEnd, length);
                            mEdtResultMain.setText(subStart + substringend);
                        } else {
                            mEdtResultMain.setText(subStart);
                        }
                        mEdtResultMain.setSelection(selectionEnd-1);
                    }catch (Exception e){

                    }
                    break;
            }
        }
    }
    public void appendTextInEdtResult(CharSequence appendText){
        int selectionEnd = mEdtResultMain.getSelectionEnd();
        int length = mEdtResultMain.getText().toString().length();
        CharSequence subStart = mEdtResultMain.getText().subSequence(0,selectionEnd);
        if (subStart.length() < length) {
            CharSequence substringend = mEdtResultMain.getText().toString().substring(selectionEnd, length);
            ((Editable) subStart).append(appendText);
            ((Editable) subStart).append(substringend);
            mEdtResultMain.setText(subStart);
        } else {
            ((Editable) subStart).append(appendText);
            mEdtResultMain.setText(subStart);
        }
        mEdtResultMain.setSelection(selectionEnd+1);
    }
}
