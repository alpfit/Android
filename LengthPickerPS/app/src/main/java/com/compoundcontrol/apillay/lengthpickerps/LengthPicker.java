package com.compoundcontrol.apillay.lengthpickerps;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by apillay on 1/14/2016.
 */
public class LengthPicker extends LinearLayout {
    private static final String KEY_SUPER_STATE = "superstate" ;
    private static final String KEY_NUM_INCHES = "numinches" ;
    private Button mPlusButton;
    private TextView mLpTextView;
    private Button mMinusButton;
    private int mNumInches = 0;
    private OnChangeListener mListener = null;

    public LengthPicker(android.content.Context context) {
        super(context);
        init();
    }

    public LengthPicker(android.content.Context context, android.util.AttributeSet attrs) {
        super(context,attrs);
        init();
    }

    public LengthPicker(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public LengthPicker(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.length_picker, this);
        mPlusButton = (Button) findViewById(R.id.plus_button);
        mMinusButton = (Button) findViewById(R.id.minus_button);
        mLpTextView = (TextView) findViewById(R.id.lpText);
        updateControls();
        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumInches++;
                if (mListener != null) {
                    mListener.onChange(mNumInches);
                }
                updateControls();
            }
        });

        mMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mNumInches > 0) {
                    mNumInches--;
                    if (mListener != null) {
                        mListener.onChange(mNumInches);
                    }
                    updateControls();
                }
            }
        });

        setOrientation(LinearLayout.HORIZONTAL);

    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_SUPER_STATE, super.onSaveInstanceState());
        bundle.putInt(KEY_NUM_INCHES, mNumInches);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle)state;
            mNumInches = bundle.getInt(KEY_NUM_INCHES);
            super.onRestoreInstanceState(bundle.getParcelable(KEY_SUPER_STATE));
        }
        else {
            super.onRestoreInstanceState(state);
        }
        updateControls();
    }

    private void updateControls() {
        int feet = mNumInches/12;
        int inches = mNumInches % 12;
        String text = String.format("%d' %d\"", feet, inches);
        if (feet == 0) {
            text = String.format("%d\"", inches);
        }
        else if (inches == 0) {
            text = String.format("%d'", feet);
        }
        mLpTextView.setText(text);
        mMinusButton.setEnabled(mNumInches > 0);
    }

    public void setOnChangeListener(OnChangeListener listener) {
        mListener = listener;
    }

    public int getNumInches() {
        return mNumInches;
    }

    public interface OnChangeListener {
        public void onChange(int length);
    }
}
