package edu.purdue.shishir.pokefriends;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Shishir on 18/07/16.
 */

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements OnMapReadyCallback {
    private double longitude;
    private double latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle b = getIntent().getExtras();
        longitude = b.getDouble("longitude");
        latitude = b.getDouble("latitude");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng myLocation = new LatLng(latitude, longitude);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 13));

        map.addMarker(new MarkerOptions()
                .title("Your Location")
                .position(myLocation));
    }
}
