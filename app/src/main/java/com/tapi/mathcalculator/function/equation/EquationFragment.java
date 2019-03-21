package com.tapi.mathcalculator.function.equation;

import android.content.Context;
import android.content.SharedPreferences;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.ui.keyboard.IKeyBoard;
import com.tapi.mathcalculator.ui.keyboard.ScienceKeyBoardView;
import com.tapi.mathcalculator.utils.UtilsString;

public class EquationFragment extends Fragment {
    private ScienceKeyBoardView mEquationKeyboardView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.equation_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mEquationKeyboardView = view.findViewById(R.id.calculator_keyboard_layout);
        mEquationKeyboardView.setOnKeyboardOnClickListener(new IKeyBoard.OnKeyboardOnClickListener() {
            @Override
            public void onKeyEventClick(View view, IKeyBoard.Event event, IKeyBoard.Key key) {

            }

            @Override
            public void onKeyEventLongClick(View view, IKeyBoard.Event event, IKeyBoard.Key key) {

            }
        });
    }
}
