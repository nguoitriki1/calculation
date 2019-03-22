package com.tapi.mathcalculator.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
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
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.function.adapter.ViewPagerAdapter;
import com.tapi.mathcalculator.function.calculator.CalculatorFragment;
import com.tapi.mathcalculator.function.equation.EquationDialogTutorial;
import com.tapi.mathcalculator.function.equation.EquationFragment;
import com.tapi.mathcalculator.function.history.HistoryFragmentDialog;
import com.tapi.mathcalculator.function.photo.PhotoFragment;
import com.tapi.mathcalculator.helpler.PreferenceHelper;
import com.tapi.mathcalculator.ui.nav.NavigationMenuView;
import com.tapi.mathcalculator.ui.toolbar.HomePageToolbarView;
import com.tapi.mathcalculator.utils.UtilsString;


public class HomePageFragment extends Fragment implements ViewPager.OnPageChangeListener {
    private HomePageViewModel viewModel;
    private NavigationMenuView navigationMenuView;
    private HomePageToolbarView homePageToolbarView;
    private ViewPagerAdapter adapter;
    private DrawerLayout mDrawer;
    private ViewPager mViewPager;
    private boolean isFirtsLauncherEquation,isFirtsLauncherCalculator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_page_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(HomePageViewModel.class);
        checkFistLanch();
        initView(view);
        setClickView();
    }

    private void checkFistLanch() {
    }

    private void initView(View view) {
        mViewPager = view.findViewById(R.id.view_pager_main);
        navigationMenuView = view.findViewById(R.id.nav_menu_view);
        homePageToolbarView = view.findViewById(R.id.home_page_toolbar);
        mDrawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new CalculatorFragment(), UtilsString.TITLE_FRAGMENT_CALCULATOR);
        adapter.addFrag(new EquationFragment(), UtilsString.TITLE_FRAGMENT_EQUATION);
        adapter.addFrag(new PhotoFragment(), UtilsString.TITLE_FRAGMENT_PHOTO);
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
        navigationMenuView.setOnNavMenuclickListner(new NavigationMenuView.OnNavMenuclickListner() {
            @Override
            public void onMenuClickListner(View view, int id) {
                switch (id) {
                    case R.id.img_menu:
                        mDrawer.openDrawer(GravityCompat.START);
                        break;
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
                        startActivity(new Intent(getActivity(), BmiActivity.class));
                        hideDrawerNav();
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
                        Toast.makeText(getActivity(), "rate us", Toast.LENGTH_SHORT).show();
                        hideDrawerNav();
                        break;
                    case R.id.layout_item_privacy_policy:
                        Toast.makeText(getActivity(), "privacy policy", Toast.LENGTH_SHORT).show();
                        hideDrawerNav();
                        break;
                }
            }
        });
    }

//    @Override
//    public void onBackPressed() {
//        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
//            mDrawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        isFirtsLauncherEquation = PreferenceHelper.get().getBoolean(PreferenceHelper.IS_FIRTS_LAUNCHER_EQUATION, false);
        isFirtsLauncherCalculator = PreferenceHelper.get().getBoolean(PreferenceHelper.IS_FIRTS_LAUNCHER_CALCULATOR, false);
        if (!TextUtils.isEmpty(adapter.getPageTitle(i))) {
            homePageToolbarView.setmTitlePage(String.valueOf(adapter.getPageTitle(i)));
            if (adapter.getPageTitle(i).equals(UtilsString.TITLE_FRAGMENT_EQUATION)){
                if (!isFirtsLauncherEquation) {
                    showDialogEquationTutorial();
                    PreferenceHelper.get().putBoolean(PreferenceHelper.IS_FIRTS_LAUNCHER_EQUATION, true);
                }
            }else if (adapter.getPageTitle(i).equals(UtilsString.TITLE_FRAGMENT_CALCULATOR)){
                if (!isFirtsLauncherCalculator) {
                    CalculatorFragment calculatorFragment = (CalculatorFragment) adapter.getItem(i);
                    calculatorFragment.showTutorial();
                }
            }
        }
    }

    private void showDialogEquationTutorial() {
        EquationDialogTutorial equationDialog = new EquationDialogTutorial();
        equationDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        equationDialog.show(getActivity().getSupportFragmentManager(), UtilsString.TAG_TUTORIAL_EQUATION_DIALOG);
    }
    private void showDialogHistory() {
        HistoryFragmentDialog historyFragmentDialog = new HistoryFragmentDialog();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.window_in_animation,R.anim.window_out_animation, R.anim.window_in_animation,R.anim.window_out_animation);
        fragmentTransaction.add(R.id.homepage_contaner_fragment,historyFragmentDialog,UtilsString.TAG_HISTORY_FRAGMENT);
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
        }else {
            return false;
        }
    }
}
