package com.tapi.mathcalculator.ui.toolbar;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tapi.mathcalculator.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class HomePageToolbarView extends ConstraintLayout {
    private ImageView mMenuBtn;
    private DotsIndicator mDotsIndicator;
    private TextView mTitlePage;
    private OnClickBtnShowMenuNavListner onClickBtnShowMenuNavListner;

    public HomePageToolbarView(Context context) {
        super(context);
    }

    public HomePageToolbarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomePageToolbarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnClickBtnShowMenuNavListner(OnClickBtnShowMenuNavListner onClickBtnShowMenuNavListner) {
        this.onClickBtnShowMenuNavListner = onClickBtnShowMenuNavListner;
    }
    public void setmTitlePage(String title){
        mTitlePage.setText(title);
    }
    public void initDot(ViewPager viewPager){
        mDotsIndicator.setViewPager(viewPager);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuBtn = findViewById(R.id.img_menu);
        mDotsIndicator = findViewById(R.id.dots_indicator);
        mTitlePage = findViewById(R.id.title_home_page);
        mMenuBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtnShowMenuNavListner.onClickBtnShowMenuNav();
            }
        });
    }

    public interface OnClickBtnShowMenuNavListner {
        void onClickBtnShowMenuNav();
    }
}
