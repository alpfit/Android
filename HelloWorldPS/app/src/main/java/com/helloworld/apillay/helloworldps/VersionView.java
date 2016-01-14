package com.helloworld.apillay.helloworldps;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.TextView;

/**
 * Created by apillay on 1/14/2016.
 */
public class VersionView extends TextView {

    public VersionView(android.content.Context context) {
        super(context);
        setVersion();
    }

    public VersionView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        setVersion();
    }

    public VersionView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setVersion();
    }

    public VersionView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setVersion();
    }

    private void setVersion() {
        try {
            PackageInfo mpackage = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(),0);
            setText(mpackage.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
