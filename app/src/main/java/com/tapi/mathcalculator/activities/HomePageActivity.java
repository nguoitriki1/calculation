package com.tapi.mathcalculator.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.function.dialog.ExitDialog;
import com.tapi.mathcalculator.utils.UtilsString;

public class HomePageActivity extends AppCompatActivity {
    private HomePageFragment homePageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM, WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        setContentView(R.layout.activity_home_page);
        replaceFragmentHomePage();
    }

    private void replaceFragmentHomePage() {
        HomePageFragment homePageFragment = new HomePageFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.homepage_contaner_fragment, homePageFragment, UtilsString.TAG_HOMEPAGE_FRAGMENT);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (homePageFragment != null) {
            if (homePageFragment.hideDrawerNav()) {
                homePageFragment.hideDrawerNav();
            } else {
                if (getSupportFragmentManager().getBackStackEntryCount() == 0){
                    showDialogExit();
                }else {
                    super.onBackPressed();
                }
            }
        } else {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0){
                showDialogExit();
            }else {
                super.onBackPressed();
            }
        }
    }
    private void showDialogExit() {
        ExitDialog exitDialog = new ExitDialog();
        exitDialog.setCancelable(false);
        exitDialog.show(getSupportFragmentManager(), UtilsString.TAG_EXIT_DIALOG);
    }
}
