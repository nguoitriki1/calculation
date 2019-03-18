package com.tapi.mathcalculator.ui.keyboard;

import android.content.Context;
import android.support.annotation.IdRes;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.tapi.mathcalculator.R;

public class ScienceKeyBoardView extends ScrollView implements IKeyBoard {
    protected OnKeyboardOnClickListener mOnKeyboardOnClickListener;
    private int mAllChildHeight;

    public ScienceKeyBoardView(Context context) {
        super(context);
    }

    public ScienceKeyBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScienceKeyBoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnKeyboardOnClickListener(OnKeyboardOnClickListener mOnKeyboardOnClickListener) {
        this.mOnKeyboardOnClickListener = mOnKeyboardOnClickListener;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        addKey(R.id.kb_log, Key.log);
        addKey(R.id.kb_x2, Key.x2);
        addKey(R.id.kb_gen, Key.gen);
        addKey(R.id.kb_xn, Key.xn);
        addKey(R.id.kb_un, Key.un);
        addKey(R.id.kb_deg_rad, Key.rad);
        addKey(R.id.kb_back, Key.back);
        addKey(R.id.kb_brackets_l, Key.brackets_l);
        addKey(R.id.kb_brackets_r, Key.brackets_r);
        addKey(R.id.kb_division, Key.division);
        addKey(R.id.kb_sin, Key.sin);
        addKey(R.id.kb_7, Key.num_7);
        addKey(R.id.kb_8, Key.num_8);
        addKey(R.id.kb_9, Key.num_9);
        addKey(R.id.kb_multiply, Key.multiply);
        addKey(R.id.kb_cos, Key.cos);
        addKey(R.id.kb_4, Key.num_4);
        addKey(R.id.kb_5, Key.num_5);
        addKey(R.id.kb_6, Key.num_6);
        addKey(R.id.kb_minus, Key.minus);
        addKey(R.id.kb_tan, Key.tan);
        addKey(R.id.kb_1, Key.num_1);
        addKey(R.id.kb_2, Key.num_2);
        addKey(R.id.kb_3, Key.num_3);
        addKey(R.id.kb_plus, Key.plus);
        addKey(R.id.kb_open, Key.open);
        addKey(R.id.kb_percent, Key.percent);
        addKey(R.id.kb_0, Key.num_0);
        addKey(R.id.kb_point, Key.point);
        addKey(R.id.kb_equal, Key.equal);
        addKey(R.id.kb_asin, Key.asin);
        addKey(R.id.kb_acos, Key.acos);
        addKey(R.id.kb_atan, Key.atan);
        addKey(R.id.kb_ln, Key.ln);
        addKey(R.id.kb_lg, Key.lg);
        addKey(R.id.kb_x3, Key.x3);
        addKey(R.id.kb_x_1, Key.x_1);
        addKey(R.id.kb_3gen, Key.gen3);
        addKey(R.id.kb_pi, Key.pi);
        addKey(R.id.kb_e, Key.e);

    }

    private void addKey(@IdRes int id, Key key) {
        IKeyItem keyItem = (IKeyItem) findViewById(id);
        keyItem.setKey(key);
        keyItem.setOnClickListener(this);
        keyItem.setOnLongClickListener(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ViewGroup viewGroup = (ViewGroup) getChildAt(0);
        if (viewGroup != null) {
            viewGroup.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec((MeasureSpec.getSize(heightMeasureSpec) / 5) * 10, MeasureSpec.EXACTLY));
        }
    }

    @Override
    public void onClick(View v) {
        if (v instanceof IKeyItem) {
            Key key = ((IKeyItem) v).getKey();
            if (mOnKeyboardOnClickListener != null)
                mOnKeyboardOnClickListener.onKeyEvent(v, Event.click, key);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (v instanceof IKeyItem) {
            Key key = ((IKeyItem) v).getKey();
            if (mOnKeyboardOnClickListener != null)
                mOnKeyboardOnClickListener.onKeyEvent(v, Event.longClick, key);
        }
        return true;
    }


    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (MotionEvent.ACTION_UP != motionEvent.getAction()) {
            return super.onTouchEvent(motionEvent);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        scrollView(false);
        return onTouchEvent;
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    private void scrollView(boolean z) {
        int scrollY = getScrollY();
        if (scrollY > getHeight() / 2) {
            fullScroll(FOCUS_DOWN);
        } else {
            fullScroll(FOCUS_UP);
        }
    }

}
