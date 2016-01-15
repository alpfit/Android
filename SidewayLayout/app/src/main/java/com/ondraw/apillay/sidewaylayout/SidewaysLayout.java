package com.ondraw.apillay.sidewaylayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by apillay on 1/15/2016.
 */
public class SidewaysLayout extends LinearLayout {
    public SidewaysLayout(Context context) {
        super(context);
    }

    public SidewaysLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SidewaysLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SidewaysLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // swap width and height
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0,getHeight());
        canvas.rotate(-90);
       // canvas.drawColor(Color.GRAY);
        super.dispatchDraw(canvas);
        canvas.restore();
    }
}
