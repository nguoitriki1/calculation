package com.tapi.mathcalculator.activities;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.function.dialog.ExitDialog;
import com.tapi.mathcalculator.function.homepage.HomePageFragment;
import com.tapi.mathcalculator.function.photo.PhotoFragment;
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
        homePageFragment = new HomePageFragment();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == UtilsString.SETTING_APP_RESULT_CODE){
            try{
                if (ContextCompat.checkSelfPermission(HomePageActivity.this, Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_GRANTED) {
                    HomePageFragment homePageFragment = (HomePageFragment) getSupportFragmentManager().findFragmentById(R.id.homepage_contaner_fragment);
                    homePageFragment.onActivityResult(requestCode,resultCode,data);
                }
            }catch (Exception e){

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode ==  UtilsString.MY_PERMISSIONS_REQUEST_CAMERA){
            try{
                HomePageFragment homePageFragment = (HomePageFragment) getSupportFragmentManager().findFragmentById(R.id.homepage_contaner_fragment);
                homePageFragment.onRequestPermissionsResult(requestCode,permissions,grantResults);
            }catch (Exception e){

            }
        }
    }
}
