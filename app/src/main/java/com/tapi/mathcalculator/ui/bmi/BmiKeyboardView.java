package com.tapi.mathcalculator.ui.bmi;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;

import com.tapi.mathcalculator.R;
import com.tapi.mathcalculator.ui.keyboard.IKeyBoard;
import com.tapi.mathcalculator.ui.keyboard.IKeyItem;

public class BmiKeyboardView extends ConstraintLayout implements View.OnClickListener, View.OnLongClickListener {
    protected IKeyBoard.OnKeyboardOnClickListener mOnKeyboardOnClickListener;
    public BmiKeyboardView(Context context) {
        super(context);
    }

    public BmiKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnKeyboardOnClickListener(IKeyBoard.OnKeyboardOnClickListener mOnKeyboardOnClickListener) {
        this.mOnKeyboardOnClickListener = mOnKeyboardOnClickListener;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        addKey(R.id.kb_num0, IKeyBoard.Key.num_0);
        addKey(R.id.kb_num1, IKeyBoard.Key.num_1);
        addKey(R.id.kb_num2, IKeyBoard.Key.num_2);
        addKey(R.id.kb_num3, IKeyBoard.Key.num_3);
        addKey(R.id.kb_num4, IKeyBoard.Key.num_4);
        addKey(R.id.kb_num5, IKeyBoard.Key.num_5);
        addKey(R.id.kb_num6, IKeyBoard.Key.num_6);
        addKey(R.id.kb_num7, IKeyBoard.Key.num_7);
        addKey(R.id.kb_num8, IKeyBoard.Key.num_8);
        addKey(R.id.kb_num9, IKeyBoard.Key.num_9);
        addKey(R.id.kb_point, IKeyBoard.Key.point);
        addKey(R.id.kb_back, IKeyBoard.Key.back);
    }
    private void addKey(@IdRes int id, IKeyBoard.Key key) {
        IKeyItem keyItem = (IKeyItem) findViewById(id);
        keyItem.setKey(key);
        keyItem.setOnClickListener(this);
        keyItem.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof IKeyItem) {
            IKeyBoard.Key key = ((IKeyItem) v).getKey();
            if (mOnKeyboardOnClickListener != null) {
                mOnKeyboardOnClickListener.onKeyEventClick(v, IKeyBoard.Event.click, key);
            }
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (v instanceof IKeyItem) {
            IKeyBoard.Key key = ((IKeyItem) v).getKey();
            if (mOnKeyboardOnClickListener != null) {
                mOnKeyboardOnClickListener.onKeyEventLongClick(v, IKeyBoard.Event.longClick, key);
            }
        }
        return true;
    }
}
