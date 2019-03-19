package com.tapi.mathcalculator.ui.nav;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.activities.BmiActivity;
import com.tapi.mathcalculator.activities.HomePageActivity;

public class NavigationMenuView extends ConstraintLayout implements View.OnClickListener {
    private LinearLayout mBtnCalculator,mBtnEquation,mBtnPhoto,mBtnBMI,mBtnHistory,mBtnRateUs,mBtnPrivacyPolicy;
    private ConstraintLayout mBtnFloating , mBtnVibrate ,mBtnSound;
    private ImageView mSwitchFloating,mSwitchVibrate,mSwitchSound;
    private OnNavMenuclickListner onNavMenuclickListner;
    public NavigationMenuView(Context context) {
        super(context);
    }

    public NavigationMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavigationMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnNavMenuclickListner(OnNavMenuclickListner onNavMenuclickListner) {
        this.onNavMenuclickListner = onNavMenuclickListner;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
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
        mSwitchFloating = findViewById(R.id.floating_switch);
        mSwitchVibrate = findViewById(R.id.vibrate_switch);
        mSwitchSound = findViewById(R.id.sound_switch);
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
    public void onClick(View v) {
        onNavMenuclickListner.onMenuClickListner(v,v.getId());
    }
   public interface OnNavMenuclickListner{
        void onMenuClickListner(View view,int id);
   }
   public void floattingSwitchClick(){
        if (mSwitchFloating.isSelected()){
            mSwitchFloating.setSelected(false);
        }else {
            mSwitchFloating.setSelected(true);
        }
   }
   public void vibrateSwitchClick(){
       if (mSwitchVibrate.isSelected()){
           mSwitchVibrate.setSelected(false);
       }else {
           mSwitchVibrate.setSelected(true);
       }
   }
   public void soundSwitchClick(){
       if (mSwitchSound.isSelected()){
           mSwitchSound.setSelected(false);
       }else {
           mSwitchSound.setSelected(true);
       }
   }
}
