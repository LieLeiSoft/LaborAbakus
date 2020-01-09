package de.laborabakus;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class ImpressumActivity extends Activity 
{
    private Button btnDatum;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
     	setContentView(R.layout.impressum);
     	
		// Activity registrieren, damit sie später an zentraler Stelle (Hauptmenue) geschlossen werden kann
	    ActivityRegistry.register(this);
/*
		btnDatum = (Button) findViewById(R.id.button2);

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
		*/
    }

}