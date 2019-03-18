package com.tapi.mathcalculator.fragment.calculator;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tapi.mathcalculator.HomePageCalculatorViewModel;
import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.adapter.ViewPagerAdapter;
import com.tapi.mathcalculator.lib.VerticalViewPager;
import com.tapi.mathcalculator.utils.StaticFuncition;
import com.tapi.mathcalculator.utils.UtilsString;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class FragmentCalculator extends Fragment implements View.OnClickListener {
    private TextView mTxtResult;
    private EditText mEdtResult;
    private VerticalViewPager mPageSpreadsheet;
    private ViewPagerAdapter mAdapterviewPage;
    private HomePageCalculatorViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(getActivity()).get(HomePageCalculatorViewModel.class);
        return inflater.inflate(R.layout.fragment_calculator, container, false);
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
        mTxtResult.setOnClickListener(this);
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
        mEdtResult.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (getActivity() != null)
                    StaticFuncition.hideKeyboard(getActivity());
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

            @SuppressLint("WrongConstant")
            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s)) {
                    mTxtResult.setTextSize(200);
                    mTxtResult.setText("0");
                } else {
                    ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
                    try {
                        //convent chuỗi để tính toán
                        // lọc dữ liệu
                        //b1 : lấy từng phần tử của chuỗi ra để tính toán
                        String s2 = viewModel.calculatorString(String.valueOf(s));
                        String s1 = formatToDisplayMode(s2);
                        mTxtResult.setText("" + engine.eval(String.valueOf(s1)));
                    } catch (Exception e) {
                        mTxtResult.setText("Error");
                    }
                }
            }
        });
    }

    private String formatToDisplayMode(String s) {
        return s.replace("/", "/").replace("x", "*").replace("-", "-").replace(" ", "");
    }

    private void initView() {
        mAdapterviewPage = new ViewPagerAdapter(getChildFragmentManager());
        mAdapterviewPage.addFrag(new FragmentPageSpreadsheetOne(), UtilsString.TITLE_FRAGMENT_SPREAD_SHEET_ONE);
        mAdapterviewPage.addFrag(new FragmentPageSpreadsheetTwo(), UtilsString.TITLE_FRAGMENT_SPREAD_SHEET_TWO);
        mPageSpreadsheet.setAdapter(mAdapterviewPage);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calculator_edt_result:
                if (getActivity() != null)
                    StaticFuncition.hideKeyboard(getActivity());
                break;
            case R.id.calculator_txt_result:
                if (getActivity() != null) {
                    ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("result", mTxtResult.getText().toString());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(getActivity(), "Result copied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
