package com.tapi.mathcalculator.ui.keyboard;

import android.view.View;

public interface IKeyItem {
    IKeyBoard.Key getKey();

    void setKey(IKeyBoard.Key key);

    boolean isSelected();

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnLongClickListener(View.OnLongClickListener onLongClickListener);

    void setSelected(boolean z);

}
