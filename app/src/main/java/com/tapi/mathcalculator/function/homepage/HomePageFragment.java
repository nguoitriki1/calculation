package com.tapi.mathcalculator.function.homepage;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.ViewGroup;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.function.adapter.ViewPagerAdapter;
import com.tapi.mathcalculator.function.bmi.BmiActivity;
import com.tapi.mathcalculator.function.calculator.CalculatorFragment;
import com.tapi.mathcalculator.function.dialog.EquationTutorialDialog;
import com.tapi.mathcalculator.function.equation.EquationFragment;
import com.tapi.mathcalculator.function.history.HistoryFragment;
import com.tapi.mathcalculator.function.photo.PhotoFragment;
import com.tapi.mathcalculator.helpler.PreferenceHelper;
import com.tapi.mathcalculator.ui.nav.NavigationMenuView;
import com.tapi.mathcalculator.ui.toolbar.HomePageToolbarView;
import com.tapi.mathcalculator.utils.Utils;
import com.tapi.mathcalculator.utils.UtilsString;


public class HomePageFragment extends Fragment implements ViewPager.OnPageChangeListener {
    private NavigationMenuView navigationMenuView;
    private HomePageToolbarView homePageToolbarView;
    private ViewPagerAdapter adapter;
    private DrawerLayout mDrawer;
    private ViewPager mViewPager;
    private boolean isFirtsLauncherEquation, isFirtsLauncherCalculator;
    private boolean isStartCameraPhoto = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_page_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        setClickView();
        drawMenuNavigationClick();
    }

    private void drawMenuNavigationClick() {
        navigationMenuView.setOnNavMenuclickListner(new NavigationMenuView.OnNavMenuclickListner() {
            @Override
            public void onMenuClickListner(View view, int id) {
                switch (id) {
                    case R.id.layout_item_calculation:
                        mViewPager.setCurrentItem(0);
                        hideDrawerNav();
                        break;
                    case R.id.layout_item_equation:
                        hideDrawerNav();
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.layout_item_photo:
                        hideDrawerNav();
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.layout_item_bmi:
                        hideDrawerNav();
                        startActivity(new Intent(getActivity(), BmiActivity.class));
                        break;
                    case R.id.layout_item_floating:
                        navigationMenuView.floattingSwitchClick();
                        break;
                    case R.id.layout_item_vibrate:
                        navigationMenuView.vibrateSwitchClick();
                        break;
                    case R.id.layout_item_sound:
                        navigationMenuView.soundSwitchClick();
                        break;
                    case R.id.layout_item_history:
                        showDialogHistory();
                        hideDrawerNav();
                        break;
                    case R.id.layout_item_rate_us:
                        hideDrawerNav();
                        break;
                    case R.id.layout_item_privacy_policy:
                        hideDrawerNav();
                        break;
                }
            }
        });
    }

    private void initView(View view) {
        mViewPager = view.findViewById(R.id.view_pager_main);
        navigationMenuView = view.findViewById(R.id.nav_menu_view);
        homePageToolbarView = view.findViewById(R.id.home_page_toolbar);
        mDrawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new CalculatorFragment(), UtilsString.TITLE_FRAGMENT_CALCULATOR);
        adapter.addFrag(new EquationFragment(), UtilsString.TITLE_FRAGMENT_EQUATION);
        PhotoFragment photoFragment = new PhotoFragment();
        photoFragment.setOnStartMathpixCameraView(new PhotoFragment.OnStartMathpixCameraView() {
            @Override
            public void onStartMathpixCameraView(Boolean isStart) {
                if (isStart != null){
                    isStartCameraPhoto = isStart;
                }
            }
        });
        adapter.addFrag(photoFragment, UtilsString.TITLE_FRAGMENT_PHOTO);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(this);
        homePageToolbarView.initDot(mViewPager);
    }

    private void setClickView() {
        homePageToolbarView.setOnClickBtnShowMenuNavListner(new HomePageToolbarView.OnClickBtnShowMenuNavListner() {
            @Override
            public void onClickBtnShowMenuNav() {
                mDrawer.openDrawer(Gravity.START);
            }
        });
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        isFirtsLauncherEquation = PreferenceHelper.get().getBoolean(PreferenceHelper.IS_FIRTS_LAUNCHER_EQUATION, false);
        isFirtsLauncherCalculator = PreferenceHelper.get().getBoolean(PreferenceHelper.IS_FIRTS_LAUNCHER_CALCULATOR, false);
        if (!TextUtils.isEmpty(adapter.getPageTitle(i))) {
            homePageToolbarView.setmTitlePage(String.valueOf(adapter.getPageTitle(i)));
            if (adapter.getPageTitle(i).equals(UtilsString.TITLE_FRAGMENT_EQUATION)) {
                EquationFragment equationFragment = (EquationFragment) adapter.getItem(i);
                equationFragment.requestForcusEditText();
                if (!isFirtsLauncherEquation) {
                    showDialogEquationTutorial();
                    PreferenceHelper.get().putBoolean(PreferenceHelper.IS_FIRTS_LAUNCHER_EQUATION, true);
                }
            } else if (adapter.getPageTitle(i).equals(UtilsString.TITLE_FRAGMENT_CALCULATOR)) {
                if (!isFirtsLauncherCalculator) {
                    CalculatorFragment calculatorFragment = (CalculatorFragment) adapter.getItem(i);
                    calculatorFragment.showTutorial();
                }
            } else if (adapter.getPageTitle(i).equals(UtilsString.TITLE_FRAGMENT_PHOTO)) {
                PhotoFragment photoFragment = (PhotoFragment) adapter.getItem(i);
                photoFragment.setViewDefault(isStartCameraPhoto);
                photoFragment.checkPermission();
            }
        }
    }

    private void showDialogEquationTutorial() {
        EquationTutorialDialog equationDialog = new EquationTutorialDialog();
        equationDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        equationDialog.show(getActivity().getSupportFragmentManager(), UtilsString.TAG_TUTORIAL_EQUATION_DIALOG);
    }

    private void showDialogHistory() {
        HistoryFragment historyFragment = new HistoryFragment();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.window_in_animation, R.anim.window_out_animation, R.anim.window_in_animation, R.anim.window_out_animation);
        fragmentTransaction.add(R.id.homepage_contaner_fragment, historyFragment, UtilsString.TAG_HISTORY_FRAGMENT);
        fragmentTransaction.addToBackStack(UtilsString.TAG_HISTORY_FRAGMENT);
        fragmentTransaction.commit();
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    public boolean hideDrawerNav() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == UtilsString.SETTING_APP_RESULT_CODE){
            checkPermissionHideViewPhotoFragment();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            checkPermissionHideViewPhotoFragment();
        }
    }
    private void checkPermissionHideViewPhotoFragment(){
        try{
            PhotoFragment photoFragment = (PhotoFragment) adapter.getItem(2);
            photoFragment.hideViewPermission();
        }catch (Exception e){

        }
    }
}
