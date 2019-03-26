package com.tapi.mathcalculator.function.equation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.ui.equation.EquationResultView;
import com.tapi.mathcalculator.ui.keyboard.EquationKeyBoardView;
import com.tapi.mathcalculator.ui.keyboard.IKeyBoard;
import com.tapi.mathcalculator.ui.keyboard.CalculatorKeyBoardView;
import com.tapi.mathcalculator.utils.UtilsString;

public class EquationFragment extends Fragment {
    private EquationKeyBoardView mEquationKeyboardView;
    private EquationResultView mEquationResultView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.equation_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mEquationKeyboardView = (EquationKeyBoardView) view.findViewById(R.id.equation_keyboard_layout);
        mEquationResultView = (EquationResultView) view.findViewById(R.id.equation_result_layout);
        mEquationKeyboardView.setOnKeyboardOnClickListener(new IKeyBoard.OnKeyboardOnClickListener() {
            @Override
            public void onKeyEventClick(View view, IKeyBoard.Event event, IKeyBoard.Key key) {
                switch (key) {
                    case enter:
                        mEquationResultView.showBacketAndLineNext();
                        break;
                    case back:
                        mEquationResultView.removeOneKeyClick();
                        break;
                    case ab:
                        mEquationKeyboardView.replaceKeyAbOrBa(IKeyBoard.Key.ab);
                        break;
                    case ba:
                        mEquationKeyboardView.replaceKeyAbOrBa(IKeyBoard.Key.ba);
                        break;
                    case solve:
                        String s = mEquationResultView.equationResult();
                        if (!TextUtils.isEmpty(s)){
                            EquationResultDialog equationResultDialog = new EquationResultDialog();
                            Bundle bundle = new Bundle();
                            if (!TextUtils.isEmpty(mEquationResultView.getEdtResult1().getText())){
                                bundle.putString(UtilsString.EQUATION_RESULT1_TXT,mEquationResultView.getEdtResult1().getText().toString());
                            }
                            if (!TextUtils.isEmpty(mEquationResultView.getEdtResult2().getText())){
                                bundle.putString(UtilsString.EQUATION_RESULT2_TXT,mEquationResultView.getEdtResult2().getText().toString());
                            }
                            equationResultDialog.setArguments(bundle);
                            if (getActivity() != null)
                            equationResultDialog.show(getActivity().getSupportFragmentManager(), UtilsString.TAG_RESULT_EQUATION_DIALOG);
                        }
                        break;
                    default:
                        mEquationResultView.addKey(key);
                        break;

                }
            }

            @Override
            public void onKeyEventLongClick(View view, IKeyBoard.Event event, IKeyBoard.Key key) {
                switch (key) {
                    case enter:
                        mEquationResultView.showBacketAndLineNext();
                        break;
                    case back:
                        mEquationResultView.removeAllKey();
                        break;
                    default:
                        view.performClick();
                        break;
                }
            }
        });
    }
}
