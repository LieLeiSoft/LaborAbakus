package de.laborabakus;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ActivityRegistry {
	private static List<Activity> _activities;

	public static void register(Activity activity) {
		if(_activities == null) {
		  _activities = new ArrayList<Activity>();
		}
		String strActivityName = activity.toString();
		Log.i("ActivityRegistry", "register: " + strActivityName);
		_activities.add(activity);
	} // register


	// Wird "finishAll" mit einer Activity-Bezeichnung (z.B. "HauptmenueActivity") aufgerufen,
	// werden alle Activities geschlossen, AUSSER denjenigen, die diese Bezeichnung enthalten.
	// activity.toString() liefert NICHT nur die Bezeichnung! Bsp.: "de.laborabakus.HauptmenueActivity@b5d4892"
	// Wird eine Activity erneut geöffnet, bekommt sie eine andere Nummer nach dem @-Zeichen.
	// Siehe auch:
	// https://developer.android.com/guide/components/activities/tasks-and-back-stack
	// https://stackoverflow.com/questions/14411477/how-to-stop-an-activity-in-android-using-intent
	public static void finishAll(String pActivityName) {
		if(_activities != null) {
			for (Activity activity : _activities) {
				String strActivityName = activity.toString();
				if (   (pActivityName.equals(""))
						|| (!(strActivityName.contains(pActivityName)))) {
					try {
						Log.i("ActivityRegistry", "finishAll: " + strActivityName);
						activity.finish();
					} catch (Exception e) {
						Log.i("ActivityRegistry", "finishAll: " + strActivityName + ": " + e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}
	} // finishAll

	public static void finishAll() {
		finishAll("");
	} // finishAll - overload
} // ActivityRegistry
