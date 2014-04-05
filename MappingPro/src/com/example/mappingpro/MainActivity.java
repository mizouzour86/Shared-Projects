package com.example.mappingpro;

import java.util.Locale;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MainActivity extends ActionBarActivity implements
		OnSeekBarChangeListener, OnItemSelectedListener {

	private final LatLng LOCATION_SAYSSI = new LatLng(32.331975, -9.197960);
	private final LatLng LOCATION_TLAT = new LatLng(32.272647, -9.032987);
	private final LatLng LOCATION_JEMAA = new LatLng(32.355134, -8.910210);
	private GoogleMap map;
	SeekBar mWidthBar;
	Polygon polygone;
	Spinner spin;
	Locale myLocale;
	private static final int WIDTH_MAX = 50;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fragment_main);

		spin = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this,
				R.array.languages, android.R.layout.simple_spinner_item);
		spin.setAdapter(adapter);
		spin.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				if (position == 1) {

					Toast.makeText(parent.getContext(),/*R.string.absher,*/"",
							Toast.LENGTH_SHORT).show();
					setLocale("ar");
				} else if (position == 3) {
					Toast.makeText(parent.getContext(),
							"Vous avez choisit une langue de merde", Toast.LENGTH_SHORT)
							.show();
					setLocale("fr");
				} else if (position == 2) {
					Toast.makeText(parent.getContext(),
							"You have selected English", Toast.LENGTH_SHORT)
							.show();
					setLocale("en");
				}

			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}

		});

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		map.addMarker(new MarkerOptions().position(LOCATION_SAYSSI).title(
				"3zib Lhajje Driss here!"));
		map.addMarker(new MarkerOptions().position(LOCATION_TLAT).title(
				"3zib Lhajje Driss here!"));
		map.addMarker(new MarkerOptions().position(LOCATION_JEMAA).title(
				"3zib Lhajje Driss here!"));

		mWidthBar = (SeekBar) findViewById(R.id.widthSeekBar);
		mWidthBar.setMax(WIDTH_MAX);
		mWidthBar.setProgress(10);

		setUpMap();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

	

	public void setLocale(String lang) {

		myLocale = new Locale(lang);
		Resources res = getResources();
		DisplayMetrics dm = res.getDisplayMetrics();
		Configuration conf = res.getConfiguration();
		conf.locale = myLocale;
		res.updateConfiguration(conf, dm);

	}

	@Override
	protected void onResume() {
		super.onResume();

	}

	private void setUpMap() {
		// TODO Auto-generated method stub
		polygone = map.addPolygon(new PolygonOptions()
				.add(new LatLng(32.326344, -9.199293),
						new LatLng(32.327498, -9.196834),
						new LatLng(32.326861, -9.196412),
						new LatLng(32.330287, -9.191600),

						new LatLng(32.329763, -9.190736),
						new LatLng(32.329774, -9.190741),
						new LatLng(32.329105, -9.191343),
						new LatLng(32.328625, -9.192199),
						new LatLng(32.326137, -9.196081),
						new LatLng(32.325329, -9.195733),
						new LatLng(32.327916, -9.191526),
						new LatLng(32.328311, -9.190699),
						new LatLng(32.328393, -9.190225),
						new LatLng(32.328377, -9.189962),
						new LatLng(32.328226, -9.189406),
						new LatLng(32.328197, -9.188808),
						new LatLng(32.328007, -9.188383),
						new LatLng(32.327941, -9.187846),
						new LatLng(32.328246, -9.187393),
						new LatLng(32.328249, -9.187436),
						new LatLng(32.329284, -9.189475),
						new LatLng(32.330571, -9.191432),
						new LatLng(32.331122, -9.192275),
						new LatLng(32.331250, -9.192160),
						new LatLng(32.330052, -9.190189),
						new LatLng(32.328514, -9.187195),
						new LatLng(32.328777, -9.186983),
						new LatLng(32.330161, -9.189832),
						new LatLng(32.331402, -9.192042),
						new LatLng(32.331649, -9.191813),
						new LatLng(32.330670, -9.189779),
						new LatLng(32.329298, -9.186703),
						new LatLng(32.330159, -9.186391),
						new LatLng(32.330561, -9.186273),
						new LatLng(32.330807, -9.186128),
						new LatLng(32.331341, -9.185892),
						new LatLng(32.331123, -9.185527),
						new LatLng(32.331731, -9.185008),
						new LatLng(32.331753, -9.185008),
						new LatLng(32.331847, -9.185350),
						new LatLng(32.331895, -9.185621),
						new LatLng(32.331992, -9.186301),
						new LatLng(32.332013, -9.186621),
						new LatLng(32.332087, -9.187485),
						new LatLng(32.332158, -9.188355),
						new LatLng(32.332228, -9.189100),
						new LatLng(32.332243, -9.189538),
						new LatLng(32.332370, -9.190454),
						new LatLng(32.332617, -9.191587),
						new LatLng(32.332888, -9.192637),
						new LatLng(32.333039, -9.193214),
						new LatLng(32.333184, -9.193788),
						new LatLng(32.333286, -9.194090),
						new LatLng(32.333479, -9.194702),
						new LatLng(32.333672, -9.195090),
						new LatLng(32.333828, -9.195516),
						new LatLng(32.333844, -9.195765),
						new LatLng(32.333167, -9.196427),
						new LatLng(32.333557, -9.197883),
						new LatLng(32.334300, -9.197651),
						new LatLng(32.333848, -9.195779),
						new LatLng(32.334140, -9.196181),
						new LatLng(32.334376, -9.196329),
						new LatLng(32.334535, -9.196414),
						new LatLng(32.335224, -9.196857),
						new LatLng(32.335669, -9.197128),
						new LatLng(32.336243, -9.197495),
						new LatLng(32.336458, -9.197812),
						new LatLng(32.336504, -9.198036),
						new LatLng(32.336516, -9.198250),
						new LatLng(32.336502, -9.198393),
						new LatLng(32.335967, -9.198768),
						new LatLng(32.335744, -9.198332),
						new LatLng(32.335583, -9.198060),
						new LatLng(32.335420, -9.197882),
						new LatLng(32.335423, -9.197895),
						new LatLng(32.335169, -9.198132),
						new LatLng(32.335436, -9.198539),
						new LatLng(32.335637, -9.198945),
						new LatLng(32.335491, -9.199032),
						new LatLng(32.335494, -9.199035),
						new LatLng(32.334725, -9.199497),
						new LatLng(32.334121, -9.199818),
						new LatLng(32.333149, -9.200276),
						new LatLng(32.332901, -9.200232),
						new LatLng(32.333025, -9.200784),
						new LatLng(32.333335, -9.201036),
						new LatLng(32.331763, -9.202110),
						new LatLng(32.331715, -9.201958),
						new LatLng(32.331675, -9.201975),
						new LatLng(32.331582, -9.201619),
						new LatLng(32.331478, -9.201213),
						new LatLng(32.331634, -9.201173),
						new LatLng(32.331697, -9.200048),
						new LatLng(32.331702, -9.199973),
						new LatLng(32.331264, -9.199893),
						new LatLng(32.330830, -9.199822),
						new LatLng(32.329503, -9.199609),
						new LatLng(32.327483, -9.199312),
						new LatLng(32.326847, -9.199326),
						new LatLng(32.326344, -9.199293))
				.strokeColor(Color.RED).strokeWidth(mWidthBar.getProgress())
				.fillColor(Color.BLUE));

		map.moveCamera(CameraUpdateFactory.newLatLng(LOCATION_SAYSSI));

		mWidthBar.setOnSeekBarChangeListener(this);
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

		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_JEMAA,
				16);
		map.animateCamera(update);
	}

	public void onClick_Sayssi(View v) {
		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(
				LOCATION_SAYSSI, 16);
		map.animateCamera(update);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		if (polygone == null) {
			return;
		} else if (seekBar == mWidthBar) {
			polygone.setStrokeWidth(progress);
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

}
