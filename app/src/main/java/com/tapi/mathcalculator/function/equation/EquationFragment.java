package com.tapi.mathcalculator.function.equation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.utils.UtilsString;

public class EquationFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.equation_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (getActivity()!= null){
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(UtilsString.SHARE_PREFENT_NAME, Context.MODE_PRIVATE);
            boolean isFirtsLauncher = sharedPreferences.getBoolean(UtilsString.IS_FIRTS_LAUNCHER_EQUATION,false);
            if (!isFirtsLauncher){
                showDialogEquationTutorial();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(UtilsString.IS_FIRTS_LAUNCHER_EQUATION,true);
                editor.apply();
            }
        }
    }

    private void showDialogEquationTutorial() {

    }
}
