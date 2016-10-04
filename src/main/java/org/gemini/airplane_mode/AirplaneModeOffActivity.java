package org.gemini.gps_onoff;

import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;

public final class GpsOffActivity extends Activity
{
    @Override
    @SuppressWarnings("deprecation")
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Settings.Secure.setLocationProviderEnabled(
            getContentResolver(), LocationManager.GPS_PROVIDER, false);
        Settings.Secure.setLocationProviderEnabled(
            getContentResolver(), LocationManager.NETWORK_PROVIDER, false);
        Settings.Secure.setLocationProviderEnabled(
            getContentResolver(), LocationManager.PASSIVE_PROVIDER, false);
        finish();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Process.killProcess(Process.myPid());
        System.exit(0);
    }
}
