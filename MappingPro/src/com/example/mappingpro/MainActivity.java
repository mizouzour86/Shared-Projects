package com.example.mappingpro;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends ActionBarActivity {
	private final LatLng LOCATION_SAYSSI = new LatLng(32.331975, -9.197960);
	private final LatLng LOCATION_TLAT = new LatLng(32.272647, -9.032987);
	private final LatLng LOCATION_JEMAA = new LatLng(32.355134, -8.910210);
	private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		map.addMarker(new MarkerOptions().position(LOCATION_SAYSSI).title("3zib Lhajje Driss here!"));
		map.addMarker(new MarkerOptions().position(LOCATION_TLAT).title("3zib Lhajje Driss here!"));
		map.addMarker(new MarkerOptions().position(LOCATION_JEMAA).title("3zib Lhajje Driss here!"));
		/*
		 * if (savedInstanceState == null) {
		 * getSupportFragmentManager().beginTransaction() .add(R.id.container,
		 * new PlaceholderFragment()).commit(); }
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void onClick_Tlat(View v) {
		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		// CameraUpdate update = CameraUpdateFactory.newLatLng(LOCATION_SAYSSI);
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_TLAT,
				16);
		map.animateCamera(update);
	}

	public void onClick_Jemaa(View v) {
		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(
				LOCATION_JEMAA, 16);
		map.animateCamera(update);
	}

	public void onClick_Sayssi(View v) {
		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(
				LOCATION_SAYSSI, 16);
		map.animateCamera(update);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
