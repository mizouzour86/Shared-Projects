package com.example.mappingpro;

import java.util.ArrayList;
import java.util.Locale;
import android.content.Intent;
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
		OnSeekBarChangeListener {

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

					Toast.makeText(parent.getContext(), R.string.absher,
							Toast.LENGTH_LONG).show();
					setLocale("ar");
				} else if (position == 3) {
					Toast.makeText(parent.getContext(),
							"Vous avez choisit une langue de merde",
							Toast.LENGTH_SHORT).show();
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
		setUpMap1();
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
		Intent refresh = new Intent(this, MainActivity.class);
		startActivity(refresh);
	}

	@Override
	protected void onResume() {
		super.onResume();

	}

	private void setUpMap1() {
		map.moveCamera(CameraUpdateFactory.newLatLng(LOCATION_SAYSSI));
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

				.strokeColor(Color.GREEN).strokeWidth(mWidthBar.getProgress())
				.fillColor(Color.CYAN));
		map.moveCamera(CameraUpdateFactory.newLatLng(LOCATION_SAYSSI));
		mWidthBar.setOnSeekBarChangeListener(this);
	}

	private void setUpMap() {
		// TODO Auto-generated method stub
		map.moveCamera(CameraUpdateFactory.newLatLng(LOCATION_JEMAA));
		ArrayList<LatLng> hole = new ArrayList<LatLng>();

		hole.add(new LatLng(32.354695, -8.907186));
		hole.add(new LatLng(32.355014, -8.907052));
		hole.add(new LatLng(32.354761, -8.906156));
		hole.add(new LatLng(32.355033, -8.906053));
		hole.add(new LatLng(32.354891, -8.905583));
		hole.add(new LatLng(32.354821, -8.905149));
		hole.add(new LatLng(32.354812, -8.904828));
		hole.add(new LatLng(32.354838, -8.904374));
		hole.add(new LatLng(32.354835, -8.904115));
		hole.add(new LatLng(32.354702, -8.903087));
		hole.add(new LatLng(32.354637, -8.902628));
		hole.add(new LatLng(32.354320, -8.901883));
		hole.add(new LatLng(32.353925, -8.900997));
		hole.add(new LatLng(32.353324, -8.899916));
		hole.add(new LatLng(32.352738, -8.900135));
		hole.add(new LatLng(32.351912, -8.900303));
		hole.add(new LatLng(32.351370, -8.900339));
		hole.add(new LatLng(32.351486, -8.900836));
		hole.add(new LatLng(32.351556, -8.901245));
		hole.add(new LatLng(32.351852, -8.902130));
		hole.add(new LatLng(32.352173, -8.903061));
		hole.add(new LatLng(32.352649, -8.902790));
		hole.add(new LatLng(32.353045, -8.903666));
		hole.add(new LatLng(32.353596, -8.903420));
		hole.add(new LatLng(32.353867, -8.904709));
		hole.add(new LatLng(32.354113, -8.905815));
		hole.add(new LatLng(32.354345, -8.906400));
		hole.add(new LatLng(32.354649, -8.907124));

		polygone = map.addPolygon(new PolygonOptions()
				.add(new LatLng(32.355025, -8.911862),
						new LatLng(32.354930, -8.911527),
						new LatLng(32.354977, -8.911493),
						new LatLng(32.354970, -8.911437),
						new LatLng(32.355167, -8.911387),
						new LatLng(32.355161, -8.911340),
						new LatLng(32.355112, -8.911175),
						new LatLng(32.355212, -8.911088),
						new LatLng(32.355181, -8.910911),
						new LatLng(32.355157, -8.910777),
						new LatLng(32.355090, -8.910444),
						new LatLng(32.355343, -8.910267),
						new LatLng(32.355213, -8.910010),
						new LatLng(32.355114, -8.909679),
						new LatLng(32.355584, -8.909265),
						new LatLng(32.355472, -8.908832),
						new LatLng(32.355320, -8.908235),
						new LatLng(32.355042, -8.907103),
						new LatLng(32.355157, -8.907040),
						new LatLng(32.355160, -8.907079),
						new LatLng(32.355448, -8.908191),
						new LatLng(32.355596, -8.908732),
						new LatLng(32.355684, -8.909082),
						new LatLng(32.355768, -8.909042),
						new LatLng(32.355507, -8.908011),
						new LatLng(32.355244, -8.907036),
						new LatLng(32.355483, -8.906915),
						new LatLng(32.355743, -8.907704),
						new LatLng(32.356061, -8.908877),
						new LatLng(32.356375, -8.908706),
						new LatLng(32.356481, -8.908944),
						new LatLng(32.356472, -8.908956),
						new LatLng(32.356536, -8.909048),
						new LatLng(32.356608, -8.909145),
						new LatLng(32.356817, -8.908783),
						new LatLng(32.356700, -8.908524),
						new LatLng(32.356486, -8.907966),
						new LatLng(32.356271, -8.907381),
						new LatLng(32.355951, -8.906574),
						new LatLng(32.356373, -8.906179),
						new LatLng(32.356308, -8.905933),
						new LatLng(32.356529, -8.905753),
						new LatLng(32.356451, -8.905519),
						new LatLng(32.356262, -8.905022),
						new LatLng(32.356050, -8.904457),
						new LatLng(32.355700, -8.903282),
						new LatLng(32.356279, -8.902927),
						new LatLng(32.355916, -8.902078),
						new LatLng(32.355490, -8.901187),
						new LatLng(32.355477, -8.901132),
						new LatLng(32.355593, -8.900959),
						new LatLng(32.355411, -8.900587),
						new LatLng(32.355401, -8.900588),
						new LatLng(32.355116, -8.900125),
						new LatLng(32.355000, -8.899982),
						new LatLng(32.355024, -8.899916),
						new LatLng(32.355523, -8.899445),
						new LatLng(32.355555, -8.899467),
						new LatLng(32.355703, -8.899638),
						new LatLng(32.356252, -8.899112),
						new LatLng(32.355667, -8.898587),
						new LatLng(32.355117, -8.897963),
						new LatLng(32.354636, -8.898406),
						new LatLng(32.354405, -8.898090),
						new LatLng(32.353985, -8.898548),
						new LatLng(32.353669, -8.898167),
						new LatLng(32.353376, -8.897651),
						new LatLng(32.352731, -8.896790),
						new LatLng(32.351798, -8.897712),
						new LatLng(32.350817, -8.898675),
						new LatLng(32.350913, -8.898966),
						new LatLng(32.350984, -8.899459),
						new LatLng(32.351285, -8.900266),
						new LatLng(32.351258, -8.900272),
						new LatLng(32.350874, -8.900229),
						new LatLng(32.350500, -8.900165),
						new LatLng(32.350143, -8.900254),
						new LatLng(32.349831, -8.900400),
						new LatLng(32.349602, -8.900535),
						new LatLng(32.349244, -8.900766),
						new LatLng(32.348803, -8.901139),
						new LatLng(32.348343, -8.901526),
						new LatLng(32.347738, -8.902073),
						new LatLng(32.347325, -8.902464),
						new LatLng(32.347323, -8.902589),
						new LatLng(32.347397, -8.902752),
						new LatLng(32.347502, -8.902885),
						new LatLng(32.347559, -8.902890),
						new LatLng(32.347894, -8.902676),
						new LatLng(32.349482, -8.901904),
						new LatLng(32.349773, -8.902938),
						new LatLng(32.350115, -8.904379),
						new LatLng(32.350673, -8.904251),
						new LatLng(32.351186, -8.904153),
						new LatLng(32.351468, -8.905528),
						new LatLng(32.351467, -8.905616),
						new LatLng(32.352175, -8.905764),
						new LatLng(32.351656, -8.906887),
						new LatLng(32.351404, -8.907480),
						new LatLng(32.352594, -8.906738),
						new LatLng(32.353338, -8.906284),
						new LatLng(32.353674, -8.906136),
						new LatLng(32.353993, -8.907113),
						new LatLng(32.353013, -8.907608),
						new LatLng(32.351936, -8.908218),
						new LatLng(32.351126, -8.908801),
						new LatLng(32.351097, -8.908820),
						new LatLng(32.350739, -8.909104),
						new LatLng(32.350818, -8.909272),
						new LatLng(32.351187, -8.909169),
						new LatLng(32.351390, -8.909141),
						new LatLng(32.352328, -8.909076),
						new LatLng(32.352908, -8.909007),
						new LatLng(32.353551, -8.908870),
						new LatLng(32.353893, -8.908729),
						new LatLng(32.354105, -8.908604),
						new LatLng(32.354515, -8.908366),
						new LatLng(32.354784, -8.908934),
						new LatLng(32.354893, -8.909196),
						new LatLng(32.354298, -8.909559),
						new LatLng(32.354832, -8.910567),
						new LatLng(32.354832, -8.910567),
						new LatLng(32.354750, -8.910689),
						new LatLng(32.354750, -8.910689),
						new LatLng(32.354586, -8.910821),
						new LatLng(32.354507, -8.910923),
						new LatLng(32.354507, -8.910923),
						new LatLng(32.353797, -8.911570),
						new LatLng(32.353797, -8.911570),
						new LatLng(32.354423, -8.911753),
						new LatLng(32.354423, -8.911753),
						new LatLng(32.354892, -8.911767),
						new LatLng(32.354914, -8.911822),
						new LatLng(32.354946, -8.911894),
						new LatLng(32.354946, -8.911894)).addHole(hole)
				.strokeColor(Color.RED).strokeWidth(mWidthBar.getProgress())
				.fillColor(Color.BLUE));

		map.moveCamera(CameraUpdateFactory.newLatLng(LOCATION_JEMAA));
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

}
