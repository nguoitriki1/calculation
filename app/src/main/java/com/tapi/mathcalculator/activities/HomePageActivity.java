package com.tapi.mathcalculator.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.function.adapter.ViewPagerAdapter;
import com.tapi.mathcalculator.function.calculator.CalculatorFragment;
import com.tapi.mathcalculator.function.equation.EquationFragment;
import com.tapi.mathcalculator.function.photo.PhotoFragment;
import com.tapi.mathcalculator.ui.nav.NavigationMenuView;
import com.tapi.mathcalculator.ui.toolbar.HomePageToolbarView;
import com.tapi.mathcalculator.utils.UtilsString;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;


public class HomePageActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private HomePageViewModel viewModel;
    private NavigationMenuView navigationMenuView;
    private HomePageToolbarView homePageToolbarView;
    private ViewPagerAdapter adapter;
    private DrawerLayout mDrawer;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM, WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        setContentView(R.layout.home_page_activity);
        initView();
        setClickView();
    }

    private void initView() {
        viewModel = ViewModelProviders.of(this).get(HomePageViewModel.class);
        mViewPager = findViewById(R.id.view_pager_main);
        navigationMenuView = findViewById(R.id.nav_menu_view);
        homePageToolbarView = findViewById(R.id.home_page_toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new CalculatorFragment(), UtilsString.TITLE_FRAGMENT_CALCULATOR);
        adapter.addFrag(new EquationFragment(), UtilsString.TITLE_FRAGMENT_EQUATION);
        adapter.addFrag(new PhotoFragment(), UtilsString.TITLE_FRAGMENT_PHOTO);
        mViewPager.setAdapter(adapter);
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
                        startActivity(new Intent(HomePageActivity.this, BmiActivity.class));
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
                        Toast.makeText(HomePageActivity.this, "history", Toast.LENGTH_SHORT).show();
                        hideDrawerNav();
                        break;
                    case R.id.layout_item_rate_us:
                        Toast.makeText(HomePageActivity.this, "rate us", Toast.LENGTH_SHORT).show();
                        hideDrawerNav();
                        break;
                    case R.id.layout_item_privacy_policy:
                        Toast.makeText(HomePageActivity.this, "privacy policy", Toast.LENGTH_SHORT).show();
                        hideDrawerNav();
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        if (!TextUtils.isEmpty(adapter.getPageTitle(i))) {
            homePageToolbarView.setmTitlePage(String.valueOf(adapter.getPageTitle(i))+"⁻¹");
        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
    public void hideDrawerNav(){
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        }
    }
}
