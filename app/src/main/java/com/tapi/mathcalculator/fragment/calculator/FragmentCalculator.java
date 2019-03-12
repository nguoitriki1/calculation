package com.tapi.mathcalculator.fragment.calculator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Html;
import android.text.InputType;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.adapter.ViewPagerAdapter;
import com.tapi.mathcalculator.lib.VerticalViewPager;
import com.tapi.mathcalculator.utils.StaticFuncition;
import com.tapi.mathcalculator.utils.UtilsString;

public class FragmentCalculator extends Fragment implements View.OnClickListener {
    private TextView mTxtResult;
    private EditText mEdtResult;
    private VerticalViewPager mPageSpreadsheet;
    private ViewPagerAdapter mAdapterviewPage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculator,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mTxtResult = view.findViewById(R.id.calculator_txt_result);
        mEdtResult = view.findViewById(R.id.calculator_edt_result);
        mPageSpreadsheet = (VerticalViewPager) view.findViewById(R.id.spreadsheet_page);
        setViewClick();
        initView();
    }

    private void setViewClick() {
        mEdtResult.setOnClickListener(this);
        mEdtResult.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int inType = mEdtResult.getInputType(); // backup the input type
                mEdtResult.setInputType(InputType.TYPE_NULL); // disable soft input
                mEdtResult.onTouchEvent(event); // call native handler
                mEdtResult.setInputType(inType); // restore input type
                return false;
            }
        });
        mEdtResult.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s)){
                    mEdtResult.setText("0");
                }
            }
        });
    }

    private void initView() {
        mAdapterviewPage = new ViewPagerAdapter(getChildFragmentManager());
        mAdapterviewPage.addFrag(new FragmentPageSpreadsheetOne(), UtilsString.TITLE_FRAGMENT_SPREAD_SHEET_ONE);
        mAdapterviewPage.addFrag(new FragmentPageSpreadsheetTwo(), UtilsString.TITLE_FRAGMENT_SPREAD_SHEET_TWO);
        mPageSpreadsheet.setAdapter(mAdapterviewPage);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.calculator_edt_result:
                if (getActivity() != null)
                    StaticFuncition.hideKeyboard(getActivity());
                break;
        }
    }
}
