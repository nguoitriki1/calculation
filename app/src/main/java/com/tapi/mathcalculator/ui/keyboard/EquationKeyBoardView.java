package com.tapi.mathcalculator.ui.keyboard;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;

import com.tapi.mathcalculator.R;

public class EquationKeyBoardView extends ConstraintLayout implements View.OnClickListener, View.OnLongClickListener {
    protected IKeyBoard.OnKeyboardOnClickListener mOnKeyboardOnClickListener;

    public EquationKeyBoardView(Context context) {
        super(context);
    }

    public EquationKeyBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnKeyboardOnClickListener(IKeyBoard.OnKeyboardOnClickListener mOnKeyboardOnClickListener) {
        this.mOnKeyboardOnClickListener = mOnKeyboardOnClickListener;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        addKey(R.id.kb_x, IKeyBoard.Key.x);
        addKey(R.id.kb_y, IKeyBoard.Key.y);
        addKey(R.id.kb_ab, IKeyBoard.Key.ab);
        addKey(R.id.kb_enter, IKeyBoard.Key.enter);
        addKey(R.id.kb_brackets_l, IKeyBoard.Key.brackets_l);
        addKey(R.id.kb_brackets_r, IKeyBoard.Key.brackets_r);
        addKey(R.id.kb_point, IKeyBoard.Key.point);
        addKey(R.id.kb_division, IKeyBoard.Key.division);
        addKey(R.id.kb_7, IKeyBoard.Key.num_7);
        addKey(R.id.kb_8, IKeyBoard.Key.num_8);
        addKey(R.id.kb_9, IKeyBoard.Key.num_9);
        addKey(R.id.kb_multiply, IKeyBoard.Key.multiply);
        addKey(R.id.kb_4, IKeyBoard.Key.num_4);
        addKey(R.id.kb_5, IKeyBoard.Key.num_5);
        addKey(R.id.kb_6, IKeyBoard.Key.num_6);
        addKey(R.id.kb_minus, IKeyBoard.Key.minus);
        addKey(R.id.kb_1, IKeyBoard.Key.num_1);
        addKey(R.id.kb_2, IKeyBoard.Key.num_2);
        addKey(R.id.kb_3, IKeyBoard.Key.num_3);
        addKey(R.id.kb_plus, IKeyBoard.Key.plus);
        addKey(R.id.kb_0, IKeyBoard.Key.num_0);
        addKey(R.id.kb_equal, IKeyBoard.Key.equal);
        addKey(R.id.kb_back, IKeyBoard.Key.back);
        addKey(R.id.kb_solve, IKeyBoard.Key.solve);
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

    public void replaceKeyAbOrBa(IKeyBoard.Key key) {
        IKeyItem keyItemAb = (IKeyItem) findViewById(R.id.kb_ab);
        IKeyItem keyItem0 = (IKeyItem) findViewById(R.id.kb_0);
        IKeyItem keyItem1 = (IKeyItem) findViewById(R.id.kb_1);
        IKeyItem keyItem2 = (IKeyItem) findViewById(R.id.kb_2);
        IKeyItem keyItem3 = (IKeyItem) findViewById(R.id.kb_3);
        IKeyItem keyItem4 = (IKeyItem) findViewById(R.id.kb_4);
        IKeyItem keyItem5 = (IKeyItem) findViewById(R.id.kb_5);
        IKeyItem keyItem6 = (IKeyItem) findViewById(R.id.kb_6);
        IKeyItem keyItem7 = (IKeyItem) findViewById(R.id.kb_7);
        IKeyItem keyItem8 = (IKeyItem) findViewById(R.id.kb_8);
        IKeyItem keyItem9 = (IKeyItem) findViewById(R.id.kb_9);

        switch (key) {
            case ab:
                keyItemAb.setKey(IKeyBoard.Key.ba);
                keyItemAb.setOnClickListener(this);
                keyItemAb.setOnLongClickListener(this);
                keyItem0.getKey().outText = "⁰";
                keyItem1.getKey().outText = "¹";
                keyItem2.getKey().outText = "²";
                keyItem3.getKey().outText = "³";
                keyItem4.getKey().outText = "⁴";
                keyItem5.getKey().outText = "⁵";
                keyItem6.getKey().outText = "⁶";
                keyItem7.getKey().outText = "⁷";
                keyItem8.getKey().outText = "⁸";
                keyItem9.getKey().outText = "⁹";
                break;
            case ba:
                keyItemAb.setKey(IKeyBoard.Key.ab);
                keyItemAb.setOnClickListener(this);
                keyItemAb.setOnLongClickListener(this);
                keyItem0.getKey().outText = "0";
                keyItem1.getKey().outText = "1";
                keyItem2.getKey().outText = "2";
                keyItem3.getKey().outText = "3";
                keyItem4.getKey().outText = "4";
                keyItem5.getKey().outText = "5";
                keyItem6.getKey().outText = "6";
                keyItem7.getKey().outText = "7";
                keyItem8.getKey().outText = "8";
                keyItem9.getKey().outText = "9";
                break;
        }
    }
    public boolean checkAbOrBa(){
        IKeyItem keyItem = (IKeyItem) findViewById(R.id.kb_ab);
        return keyItem.getKey() == IKeyBoard.Key.ab;
    }
}
