package com.tapi.mathcalculator.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.ui.CalculationResultView;
import com.tapi.mathcalculator.ui.keyboard.IKeyBoard;
import com.tapi.mathcalculator.ui.keyboard.ScienceKeyBoardView;

public class SplashActivity extends AppCompatActivity {
    private ScienceKeyBoardView mKeyBoard;
    private CalculationResultView mResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mKeyBoard = findViewById(R.id.calculator_keyboard_layout);
        mResultView = findViewById(R.id.calculation_result_view);

        mKeyBoard.setOnKeyboardOnClickListener(new IKeyBoard.OnKeyboardOnClickListener() {
            @Override
            public void onKeyEvent(View view, IKeyBoard.Event event, IKeyBoard.Key key) {
                mResultView.addKey(key);
            }
        });
    }
}
