package com.tapi.mathcalculator.fragment.calculator;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.tapi.mathcalculator.HomePageCalculatorViewModel;
import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.lib.VerticalViewPager;

public class FragmentPageSpreadsheetTwo extends Fragment implements View.OnClickListener {
    private TextView mTxtResult, mBtnExponential1, mBtnExponential2, mBtnExponential3, mBtnExponential4,
            mBtnRAD, mBtnSin, mBtnCos, mBtnTan, mBtnPi, mBtnAsin, mBtnAcos, mBtnAtan, mBtnLog, mBtnLg, mBtnLn, mBtnE, mBtnHide, mBtnSquareRootOf2, mBtnSquareRootOf3, mBtnFactorialCalculation;
    private VerticalViewPager mVerticalViewPagerMain;
    private EditText mEdtResultMain;
    private HomePageCalculatorViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(HomePageCalculatorViewModel.class);
        return inflater.inflate(R.layout.fragment_spread_sheet_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mBtnExponential1 = view.findViewById(R.id.btn_exponential1);
        mBtnExponential2 = view.findViewById(R.id.btn_exponential2);
        mBtnExponential3 = view.findViewById(R.id.btn_exponential3);
        mBtnExponential4 = view.findViewById(R.id.btn_exponential4);
        mBtnRAD = view.findViewById(R.id.btn_rad);
        mBtnSin = view.findViewById(R.id.btn_sin);
        mBtnCos = view.findViewById(R.id.btn_cos);
        mBtnTan = view.findViewById(R.id.btn_tan);
        mBtnPi = view.findViewById(R.id.btn_pi);
        mBtnAsin = view.findViewById(R.id.btn_asin);
        mBtnAcos = view.findViewById(R.id.btn_acos);
        mBtnAtan = view.findViewById(R.id.btn_atan);
        mBtnLog = view.findViewById(R.id.btn_log);
        mBtnLg = view.findViewById(R.id.btn_lg);
        mBtnLn = view.findViewById(R.id.btn_ln);
        mBtnE = view.findViewById(R.id.btn_e);
        mBtnHide = view.findViewById(R.id.btn_hide);
        mBtnSquareRootOf2 = view.findViewById(R.id.btn_square_root_of_2);
        mBtnSquareRootOf3 = view.findViewById(R.id.btn_square_root_of_3);
        mBtnFactorialCalculation = view.findViewById(R.id.btn_factorial_calculation);
        if (getActivity() != null){
            mEdtResultMain = getActivity().findViewById(R.id.calculator_edt_result);
            mTxtResult = getActivity().findViewById(R.id.calculator_txt_result);
            mVerticalViewPagerMain = (VerticalViewPager) getActivity().findViewById(R.id.spreadsheet_page);
        }
        setClickButton();
        initView();
    }

    private void setClickButton() {
        mBtnExponential1.setOnClickListener(this);
        mBtnExponential2.setOnClickListener(this);
        mBtnExponential3.setOnClickListener(this);
        mBtnExponential4.setOnClickListener(this);
        mBtnRAD.setOnClickListener(this);
        mBtnSin.setOnClickListener(this);
        mBtnCos.setOnClickListener(this);
        mBtnTan.setOnClickListener(this);
        mBtnPi.setOnClickListener(this);
        mBtnAsin.setOnClickListener(this);
        mBtnAcos.setOnClickListener(this);
        mBtnAtan.setOnClickListener(this);
        mBtnLog.setOnClickListener(this);
        mBtnLg.setOnClickListener(this);
        mBtnLn.setOnClickListener(this);
        mBtnE.setOnClickListener(this);
        mBtnHide.setOnClickListener(this);
        mBtnSquareRootOf2.setOnClickListener(this);
        mBtnSquareRootOf3.setOnClickListener(this);
        mBtnFactorialCalculation.setOnClickListener(this);
    }

    private void initView() {
        //set Text view in html text
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mBtnExponential1.setText(Html.fromHtml("<p>X<sup><small>-1</small></sup></p>", Html.FROM_HTML_MODE_COMPACT));
            mBtnExponential2.setText(Html.fromHtml("<p>X<sup><small>2</small></sup></p>", Html.FROM_HTML_MODE_COMPACT));
            mBtnExponential3.setText(Html.fromHtml("<p>X<sup><small>3</small></sup></p>", Html.FROM_HTML_MODE_COMPACT));
            mBtnExponential4.setText(Html.fromHtml("<p>X<sup><small>^</small></sup></p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            mBtnExponential1.setText(Html.fromHtml("<p>X<sup><small>-1</small></sup></p>"));
            mBtnExponential2.setText(Html.fromHtml("<p>X<sup><small>2</small></sup></p>"));
            mBtnExponential3.setText(Html.fromHtml("<p>X<sup><small>3</small></sup></p>"));
            mBtnExponential4.setText(Html.fromHtml("<p>X<sup><small>^</small></sup></p>"));
        }
    }

    @Override
    public void onClick(View v) {
        int selectionEnd = mEdtResultMain.getSelectionEnd();
        int length = mEdtResultMain.getText().toString().length();
        CharSequence subStart = mEdtResultMain.getText().subSequence(0,selectionEnd);
        CharSequence substringend = mEdtResultMain.getText().subSequence(selectionEnd, length);
        switch (v.getId()) {
            case R.id.btn_rad:
                if (mBtnRAD.getText().toString().contains("RAD")){
                    mBtnRAD.setText("DEG");
                }else {
                    mBtnRAD.setText("RAD");
                }
                break;
            case R.id.btn_sin:
                appendTextInEdtResult("sin(",4);
                break;
            case R.id.btn_cos:
                appendTextInEdtResult("cos(",4);
                break;
            case R.id.btn_tan:
                appendTextInEdtResult("tan(",4);
                break;
            case R.id.btn_pi:
                appendTextInEdtResult(getString(R.string.pi),1);
                break;
            case R.id.btn_asin:
                appendTextInEdtResult("asin(",5);
                break;
            case R.id.btn_acos:
                appendTextInEdtResult("acos(",5);
                break;
            case R.id.btn_atan:
                appendTextInEdtResult("atan(",5);
                break;
            case R.id.btn_log:
                appendTextInEdtResult("log(",4);
                break;
            case R.id.btn_lg:
                appendTextInEdtResult("lg(",3);
                break;
            case R.id.btn_ln:
                appendTextInEdtResult("ln(",3);
                break;
            case R.id.btn_e:
                appendTextInEdtResult("e",1);
                break;
            case R.id.btn_hide:
                mVerticalViewPagerMain.setCurrentItem(0, true);
                break;
            case R.id.btn_exponential1:
                appendTextInEdtResult("\u00AF\u00B9",2);
                break;
            case R.id.btn_exponential2:
              appendTextInEdtResult("\u00B2",1);
                break;
            case R.id.btn_exponential3:
                appendTextInEdtResult("\u00B3",1);
                break;
            case R.id.btn_exponential4:
                appendTextInEdtResult("^",1);
                break;
            case R.id.btn_square_root_of_2:
                appendTextInEdtResult(getString(R.string.square_root_of_2),1);
                break;
            case R.id.btn_square_root_of_3:
                appendTextInEdtResult("\u00B3"+getString(R.string.square_root_of_2),2);
                break;
            case R.id.btn_factorial_calculation:
                appendTextInEdtResult("!",1);
                break;
        }
    }

    public void appendTextInEdtResult(String appendText,int slectionAdd) {
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
        mEdtResultMain.setSelection(selectionEnd+slectionAdd);
    }
}
