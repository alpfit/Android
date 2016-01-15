package com.ondraw.apillay.newdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by apillay on 1/15/2016.
 */
public class Pizza extends View {
    private Paint paint;
    public Pizza(Context context) {
        super(context);
        init();
    }

    public Pizza(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Pizza(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public Pizza(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        paint.setColor(Color.YELLOW);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        final int width = getWidth() - getPaddingLeft() - getPaddingRight();
        final int height = getHeight() - getPaddingTop()- getPaddingBottom();
        final int cx = width/2 + getPaddingLeft();
        final int cy = height/2 + getPaddingTop();
        final float diameter = Math.min(width,height) - paint.getStrokeWidth();
        final float radius = diameter/2;
        canvas.drawCircle(cx,cy, radius, paint);
    }
}
