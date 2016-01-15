package com.photospiral.apillay.photo_spiral;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by apillay on 1/15/2016.
 */
public class PhotoSpiral extends ViewGroup {

    public PhotoSpiral(Context context) {
        super(context);
    }

    public PhotoSpiral(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PhotoSpiral(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PhotoSpiral(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        int childCount = this.getChildCount();
        View firstChild;
        int childWidth = 0;
        int childHeight = 0;
        if (childCount > 0) {
            firstChild = getChildAt(0);
            childWidth =  firstChild.getMeasuredWidth();
            childHeight =  firstChild.getMeasuredHeight();
            for (int j=0; j<childCount; j++) {
                View child = getChildAt(j);
                int x= 0;
                int y=0;
                switch (j) {
                    case 1:
                        x = childWidth;
                        break;
                    case 2:
                        x = childHeight;
                        y = childWidth;
                        break;
                    case 3:
                        y = childHeight;
                        break;
                }
                child.layout(x,y,x+child.getMeasuredWidth(),y+child.getMeasuredHeight());
            }
        }
    }

    // this control will define how each control is positionned
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount = this.getChildCount();
        View firstChild;
        int size = 0;
        int width = 0;
        int height = 0;
        if (childCount > 0) {
            // first we ask android to measure its children
            measureChildren(widthMeasureSpec,heightMeasureSpec);
            // we get the first child if any and measure it, the other children
            // will depend on this child
            firstChild = getChildAt(0);
            size =  firstChild.getMeasuredWidth() + firstChild.getMeasuredHeight();
            width =  ViewGroup.resolveSize(size, widthMeasureSpec);
            height =  ViewGroup.resolveSize(size, heightMeasureSpec);
            setMeasuredDimension(width,height);
        }
        else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

}
