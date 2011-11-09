package net.flynor.flynor;

import android.content.Context;

import android.app.Activity;
import android.os.Bundle;

import android.net.Uri;

import android.content.Intent;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;

public class FlyNOR extends Activity 
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
        Intent sendIntent = new Intent (Intent.ACTION_VIEW);
        Uri uri = Uri.parse("http://www.flynor.net/select-airport.php");
	sendIntent.setData(uri);
	startActivity(sendIntent);
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
