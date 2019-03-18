package com.tapi.mathcalculator.ui.keyboard;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.ImageView;

public class KeyItemView extends AppCompatTextView implements IKeyItem {

    private ImageView mImageView;
    private IKeyBoard.Key mKey;

    public KeyItemView(Context context) {
        super(context);
    }

    public KeyItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height;
        int width;
        if (Math.abs(heightMeasureSpec) < Math.abs(widthMeasureSpec)) {
            height = heightMeasureSpec;
            width = heightMeasureSpec;
        } else {
            width = widthMeasureSpec;
            height = widthMeasureSpec;
        }
        super.onMeasure(width, height);
        if (mImageView != null) {
            mImageView.measure(width, height);
        }
    }


    @Override
    public IKeyBoard.Key getKey() {
        return mKey;
    }

    @Override
    public void setKey(IKeyBoard.Key key) {
        mKey = key;
        setText(key.keyText);
        if (!(key.hasDrawableRes() || this.mImageView == null)) {
            this.mImageView.setImageDrawable(null);
        }
        if (key.hasDrawableRes()) {
            getImageView().setImageResource(key.drawableId);
        }
        setTag(null);
        requestLayout();
    }


    public ImageView getImageView() {
        if (this.mImageView == null) {
            this.mImageView = new ImageView(getContext());
            this.mImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        return this.mImageView;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (mImageView != null)
            mImageView.layout(left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mImageView != null) {
            canvas.save();
            canvas.rotate(mImageView.getRotation(), (float) (getWidth() / 2), (float) (getHeight() / 2));
            mImageView.draw(canvas);
            canvas.restore();
        }
    }
}
