package com.ondraw.apillay.newdraw;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by apillay on 1/15/2016.
 * custom attributes are defined in attrs.xml and can be used in code and uin layout xml
 * for the custom attribute to work in xml we have to add the namespace to the xml file
 * xmlns:anyname="http://schemas.android.com/apk/res-auto" eg
 * xmlns:pizza="http://schemas.android.com/apk/res-auto"
 */
public class Pizza extends View {
    // Avoid creating instances in onDraw
    private Paint paint;
    //private final int NUM_EDGES = 5;
    private int numWedges = 5;
    public Pizza(Context context) {
        super(context);

        init(context, null);
    }

    public Pizza(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public Pizza(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public Pizza(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        int strokeWidth = 4;
        int color = Color.YELLOW;
        if (attrs != null) {
            TypedArray aList = context.obtainStyledAttributes(attrs, R.styleable.Pizza);
            strokeWidth = aList.getDimensionPixelSize(R.styleable.Pizza_stroke_width,strokeWidth);
            color = aList.getColor(R.styleable.Pizza_color, color);
            numWedges = aList.getInt(R.styleable.Pizza_num_wedges, numWedges);
        }
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(color);
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
        drawPizzaCut(canvas,cx,cy,radius);
    }

    // rotate pizza to simplify the cut
    private void drawPizzaCut(Canvas canvas, float x, float y, float radius) {
        final float degrees = 360f / numWedges;
        canvas.save();
        for (int i=0; i<numWedges;i++) {
            canvas.drawLine(x, y, x, y - radius, paint);
            canvas.rotate(degrees, x, y); // rotate the whole canvas
        }
        canvas.restore();  // undos any canvas rotation or transformation but not the drawing.
    }
}
