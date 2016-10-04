package org.gemini.airplane_mode;

import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;

public final class AirplaneModeOnActivity extends Activity
{
    @Override
    @SuppressWarnings("deprecation")
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Settings.Global.putInt(getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 1);
        Settings.Secure.setLocationProviderEnabled(
            getContentResolver(), LocationManager.GPS_PROVIDER, true);
        Settings.Secure.setLocationProviderEnabled(
            getContentResolver(), LocationManager.NETWORK_PROVIDER, true);
        Settings.Secure.setLocationProviderEnabled(
            getContentResolver(), LocationManager.PASSIVE_PROVIDER, true);
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
