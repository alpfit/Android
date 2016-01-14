package com.compoundcontrol.apillay.lengthpickerps;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

    private LengthPicker mWidth;
    private LengthPicker mHeight;
    private TextView mArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWidth = (LengthPicker)findViewById(R.id.width);
        mHeight = (LengthPicker)findViewById(R.id.height);
        mArea = (TextView)findViewById(R.id.area);
        LengthPicker.OnChangeListener listener = new LengthPicker.OnChangeListener() {
            @Override
            public void onChange(int length) {
                updateArea();
            }
        };
        mWidth.setOnChangeListener(listener);
        mHeight.setOnChangeListener(listener);
    }

    private void updateArea() {
        int area = mWidth.getNumInches() *  mHeight.getNumInches();
        mArea.setText(area + " sq in ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateArea();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
