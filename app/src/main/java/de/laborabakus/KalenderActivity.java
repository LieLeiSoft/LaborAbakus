package de.laborabakus;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

public class KalenderActivity extends Activity
{
	private static final String TAG = "KalenderActivity";

	private CalendarView mCalendarView;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kalender);
		mCalendarView = (CalendarView) findViewById(R.id.calendarView);

		mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
			@Override
			public void onSelectedDayChange(CalendarView view, int jahr, int monat, int tag) {
				String date = tag + "." + (monat + 1) + "." + jahr;
				Log.d(TAG, "onSelectedDayChange: dd/mm/yyyy: " +date);

				Intent intent = new Intent(KalenderActivity.this, ImpressumActivity.class);
				intent.putExtra("date",date);
				startActivity(intent);
			}
		});
	}

    


}

/*
		// ********************************************************************
		// ********* Code für die Activity, die den Kalender aufruft! *********
		// ********************************************************************

		private Button btnDatum;						// der Button der beschrieben wird

		@Override
		public void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.gridlayout);


			ActivityRegistry.register(this);

			btnDatum = (Button) findViewById(R.id.button2);  // der Button der beschrieben wird

			Intent incomingIntent = getIntent();
			String date =incomingIntent.getStringExtra("date");
			btnDatum.setText(date);

			btnDatum.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Intent intent = new Intent(ImpressumActivity.this, KalenderActivity.class);
					startActivity(intent);
				}
			});
		}



 */