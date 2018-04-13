package com.yanftch.applibrary.manager;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.yanftch.applibrary.Constants;

/**
 * Author : yanftch
 * Date : 2018/4/12
 * Time : 22:06
 * Desc : 定位管理器
 */

public class LocationManager {
    static public boolean checkLocationPermission(final @NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Constants.LOCATION_PERMISSION_REQ_CODE);
                return false;
            }
        }

        return true;
    }

}
