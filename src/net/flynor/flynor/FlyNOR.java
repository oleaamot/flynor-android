package net.flynor.flynor;

import android.content.Context;

import android.app.Activity;
import android.os.Bundle;

import android.net.Uri;

import android.content.Intent;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

public class FlyNOR extends Activity implements LocationListener
{

    double latitude;
    double longitude;

    WebView webview;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

	LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

	lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10, 10, this);

    }

    public void onLocationChanged(Location location) {

	    if (location != null) {
		    latitude = location.getLatitude();
		    longitude = location.getLongitude();
		    Intent sendIntent = new Intent (Intent.ACTION_VIEW);
		    Uri uri = Uri.parse("http://www.flynor.net/select-airport.php?gps=1&gpsdata_latitude=" + latitude + "&gpsdata_longitude=" + longitude);
		    sendIntent.setData(uri);
		    startActivity(sendIntent);
	    }

    }

    public void onProviderDisabled(String provider) {
	    // required for interface, not used
    }

    public void onProviderEnabled(String provider) {
	    // required for interface, not used
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
	    // required for interface, not used
    }

    protected boolean isRouteDisplayed() {
           // TODO Auto-generated method stub
           return false;
    }

}
