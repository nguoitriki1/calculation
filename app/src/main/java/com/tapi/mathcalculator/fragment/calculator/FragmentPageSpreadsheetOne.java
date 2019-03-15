package com.tapi.mathcalculator.fragment.calculator;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.tapi.mathcalculator.HomePageCalculatorViewModel;
import com.tapi.mathcalculator.R;

public class FragmentPageSpreadsheetOne extends Fragment implements View.OnClickListener {
    private TextView mBtnPrecent, mBtnOpenBrackets, mBtnCloseBrackets, mBtnDivision, mBtnMultiplication, mBtnSubtraction, mBtnAdd, mBtnSumary, mBtnZero, mBtnOne, mBtnTwo, mBtnThree, mBtnFour, mBtnFive, mBtnSix, mBtnSeven, mBtnEight, mBtnNine, mBtnDot, mBtnCLR;
    private ImageView mBtnClearText;
    private EditText mEdtResultMain;
    private TextView mTxtResult;
    private HomePageCalculatorViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(getActivity()).get(HomePageCalculatorViewModel.class);
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
        mBtnCLR = view.findViewById(R.id.btn_clr);
        if (getActivity() != null) {
            mEdtResultMain = getActivity().findViewById(R.id.calculator_edt_result);
            mTxtResult = getActivity().findViewById(R.id.calculator_txt_result);
        }
        setClickButton();
        initView();
    }

    private void initView() {
        mEdtResultMain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s)) {
                    mEdtResultMain.setVisibility(View.INVISIBLE);
                    mTxtResult.setText("0");
                } else {
                    mEdtResultMain.setVisibility(View.VISIBLE);
                    mEdtResultMain.setSelection(s.length());
                }
            }
        });
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
        mBtnCLR.setOnClickListener(this);
        mBtnClearText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mEdtResultMain.setText("");
                mTxtResult.setText("0");
                viewModel.clearListResult();
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (mEdtResultMain != null && mTxtResult != null) {
            switch (v.getId()) {
                case R.id.btn_percent:
                    changeButtonClr();
                    appendTextInEdtResult("%");
                    viewModel.digit("%".charAt(0));
                    break;
                case R.id.btn_open_brackets:
                    changeButtonClr();
                    appendTextInEdtResult("(");
                    viewModel.digit("(".charAt(0));
                    break;
                case R.id.btn_close_brackets:
                    changeButtonClr();
                    appendTextInEdtResult(")");
                    viewModel.digit(")".charAt(0));
                    break;
                case R.id.btn_division:
                    changeButtonClr();
                    appendTextInEdtResult("/");
                    viewModel.digit("/".charAt(0));
                    break;
                case R.id.btn_multiplication:
                    changeButtonClr();
                    appendTextInEdtResult("x");
                    viewModel.digit("x".charAt(0));
                    break;
                case R.id.btn_subtraction:
                    changeButtonClr();
                    appendTextInEdtResult("-");
                    viewModel.digit("-".charAt(0));
                    break;
                case R.id.btn_add:
                    changeButtonClr();
                    appendTextInEdtResult("+");
                    viewModel.digit("+".charAt(0));
                    break;
                case R.id.btn_summary:
                    if (TextUtils.isEmpty(mEdtResultMain.getText().toString())){
                        mTxtResult.setText("0");
                    }else {
                        mTxtResult.setText(mEdtResultMain.getText().toString());
                        final Animation in = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_top);
                        mTxtResult.setAnimation(in);
                        final Animation out = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_bottom);
                        in.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                mTxtResult.setAnimation(out);
                                mTxtResult.startAnimation(out);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        mTxtResult.startAnimation(in);
                    }
                    mBtnCLR.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn_number_zero:
                    changeButtonClr();
                    appendTextInEdtResult("0");
                    viewModel.digit("0".charAt(0));
                    break;
                case R.id.btn_number_one:
                    changeButtonClr();
                    appendTextInEdtResult("1");
                    viewModel.digit("1".charAt(0));
                    break;
                case R.id.btn_number_two:
                    changeButtonClr();
                    appendTextInEdtResult("2");
                    viewModel.digit("2".charAt(0));
                    break;
                case R.id.btn_number_three:
                    changeButtonClr();
                    appendTextInEdtResult("3");
                    viewModel.digit("3".charAt(0));
                    break;
                case R.id.btn_number_four:
                    changeButtonClr();
                    appendTextInEdtResult("4");
                    viewModel.digit("4".charAt(0));
                    break;
                case R.id.btn_number_five:
                    changeButtonClr();
                    appendTextInEdtResult("5");
                    viewModel.digit("5".charAt(0));
                    break;
                case R.id.btn_number_six:
                    changeButtonClr();
                    appendTextInEdtResult("6");
                    viewModel.digit("6".charAt(0));
                    break;
                case R.id.btn_number_seven:
                    changeButtonClr();
                    appendTextInEdtResult("7");
                    viewModel.digit("7".charAt(0));
                    break;
                case R.id.btn_number_eight:
                    changeButtonClr();
                    appendTextInEdtResult("8");
                    viewModel.digit("8".charAt(0));
                    break;
                case R.id.btn_number_nine:
                    changeButtonClr();
                    appendTextInEdtResult("9");
                    viewModel.digit("9".charAt(0));
                    break;
                case R.id.btn_dot:
                    changeButtonClr();
                    appendTextInEdtResult(".");
                    viewModel.decimal(".");
                    break;
                case R.id.btn_clear_text:
                    try {
                        int selectionEnd = mEdtResultMain.getSelectionEnd();
                        int length = mEdtResultMain.getText().toString().length();
                        String subStart = mEdtResultMain.getText().toString().substring(0, selectionEnd - 1);
                        if (subStart.length() < length) {
                            String substringend = mEdtResultMain.getText().toString().substring(selectionEnd, length);
                            mEdtResultMain.setText(subStart + substringend);
                        } else {
                            mEdtResultMain.setText(subStart);
                        }
                        mEdtResultMain.setSelection(selectionEnd - 1);
                    } catch (Exception e) {

                    }
                    break;
                case R.id.btn_clr:
                    mEdtResultMain.setText("");
                    mBtnCLR.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    }

    public void appendTextInEdtResult(CharSequence appendText) {
        int selectionEnd = mEdtResultMain.getSelectionEnd();
        int length = mEdtResultMain.getText().toString().length();
        CharSequence subStart = mEdtResultMain.getText().subSequence(0, selectionEnd);
        if (subStart.length() < length) {
            CharSequence substringend = mEdtResultMain.getText().toString().substring(selectionEnd, length);
            ((Editable) subStart).append(appendText);
            ((Editable) subStart).append(substringend);
            mEdtResultMain.setText(subStart);
        } else {
            ((Editable) subStart).append(appendText);
            mEdtResultMain.setText(subStart);
        }
        mEdtResultMain.setSelection(selectionEnd + 1);
    }

    public void changeButtonClr() {
        if (mBtnCLR.getVisibility() == View.VISIBLE) {
            mBtnCLR.setVisibility(View.INVISIBLE);
            mEdtResultMain.setText("");
        }
    }
}
