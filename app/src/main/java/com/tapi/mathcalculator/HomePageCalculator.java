package com.tapi.mathcalculator;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tapi.mathcalculator.adapter.ViewPagerAdapter;
import com.tapi.mathcalculator.fragment.calculator.FragmentCalculator;
import com.tapi.mathcalculator.fragment.FragmentEquation;
import com.tapi.mathcalculator.fragment.FragmentPhoto;
import com.tapi.mathcalculator.utils.UtilsString;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;


public class HomePageCalculator extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ImageView mMenuBtn;
    private DrawerLayout mDrawer;
    private DotsIndicator mDotsIndicator;
    private ViewPager mViewPager;
    private ViewPagerAdapter adapter;
    private TextView mTitlePage;
    private LinearLayout mBtnCalculator,mBtnEquation,mBtnPhoto,mBtnBMI,mBtnFloating,mBtnVibrate,mBtnSound,mBtnHistory,mBtnRateUs,mBtnPrivacyPolicy;
    private HomePageCalculatorViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_home_page_calculator);
        //viewmodel
        viewModel = ViewModelProviders.of(this).get(HomePageCalculatorViewModel.class);
        //find by id
        mMenuBtn = findViewById(R.id.img_menu);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDotsIndicator = findViewById(R.id.dots_indicator);
        mViewPager = findViewById(R.id.view_pager_main);
        mTitlePage = findViewById(R.id.title_home_page);
        mBtnCalculator = findViewById(R.id.layout_item_calculation);
        mBtnEquation = findViewById(R.id.layout_item_equation);
        mBtnPhoto = findViewById(R.id.layout_item_photo);
        mBtnBMI = findViewById(R.id.layout_item_bmi);
        mBtnFloating = findViewById(R.id.layout_item_floating);
        mBtnVibrate = findViewById(R.id.layout_item_vibrate);
        mBtnSound = findViewById(R.id.layout_item_sound);
        mBtnHistory = findViewById(R.id.layout_item_history);
        mBtnRateUs = findViewById(R.id.layout_item_rate_us);
        mBtnPrivacyPolicy = findViewById(R.id.layout_item_privacy_policy);
        initView();
    }

    private void initView() {
        mMenuBtn.setOnClickListener(this);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentCalculator(), UtilsString.TITLE_FRAGMENT_CALCULATOR);
        adapter.addFrag(new FragmentEquation(), UtilsString.TITLE_FRAGMENT_EQUATION);
        adapter.addFrag(new FragmentPhoto(), UtilsString.TITLE_FRAGMENT_PHOTO);
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(this);
        mDotsIndicator.setViewPager(mViewPager);

        mBtnCalculator.setOnClickListener(this);
        mBtnEquation.setOnClickListener(this);
        mBtnPhoto.setOnClickListener(this);
        mBtnBMI.setOnClickListener(this);
        mBtnFloating.setOnClickListener(this);
        mBtnVibrate.setOnClickListener(this);
        mBtnSound.setOnClickListener(this);
        mBtnHistory.setOnClickListener(this);
        mBtnRateUs.setOnClickListener(this);
        mBtnPrivacyPolicy.setOnClickListener(this);

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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_menu :
                mDrawer.openDrawer(GravityCompat.START);
                break;
            case R.id.layout_item_calculation:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.layout_item_equation:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.layout_item_photo:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.layout_item_bmi:
                startActivity(new Intent(HomePageCalculator.this,BmiActivity.class));
                break;
            case R.id.layout_item_floating:
                Toast.makeText(this, "calculation", Toast.LENGTH_SHORT).show();
                break;
            case R.id.layout_item_vibrate:
                Toast.makeText(this, "calculation", Toast.LENGTH_SHORT).show();
                break;
            case R.id.layout_item_sound:
                Toast.makeText(this, "calculation", Toast.LENGTH_SHORT).show();
                break;
            case R.id.layout_item_history:
                Toast.makeText(this, "calculation", Toast.LENGTH_SHORT).show();
                break;
            case R.id.layout_item_rate_us:
                Toast.makeText(this, "calculation", Toast.LENGTH_SHORT).show();
                break;
            case R.id.layout_item_privacy_policy:
                Toast.makeText(this, "calculation", Toast.LENGTH_SHORT).show();
                break;
        }
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        if (!TextUtils.isEmpty(adapter.getPageTitle(i))){
            CharSequence pageTitle = adapter.getPageTitle(i);
            mTitlePage.setText(pageTitle);
        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
