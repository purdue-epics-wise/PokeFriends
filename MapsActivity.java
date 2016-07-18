package edu.purdue.shishir.pokefriends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.MapFragment;


public class MapsActivity extends Activity {

    Button btnShowLocation;
    // GPSTracker class
    GPSTracker gps;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // create class object
        gps = new GPSTracker(MapsActivity.this);
        // check if GPS enabled
        if (gps.canGetLocation()) {
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            Intent i = new Intent(MapsActivity.this, MainActivity.class);
            Bundle b = new Bundle();
            b.putDouble("longitude", longitude);
            b.putDouble("latitude", latitude);
            i.putExtras(b);
            startActivity(i);
        } else {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }
    }

}
