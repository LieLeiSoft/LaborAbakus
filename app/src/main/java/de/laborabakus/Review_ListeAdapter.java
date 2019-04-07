package de.laborabakus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

// GridView-Tutorial: https://www.raywenderlich.com/127544/android-gridview-getting-started

public class Review_ListeAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<String> arr_x;

    // 1
    public Review_ListeAdapter(Context context, List<String> arr_x) {
        this.mContext = context;
        this.arr_x = arr_x;
    }

    // 2
    @Override
    public int getCount() {
        return arr_x.size();
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1
        final String x = arr_x.get(position);

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.eingabeliste_textview, null);
        }

        // 3
        final TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_Eingabeliste);

        // 4
        nameTextView.setText(x);

        return convertView;
    } // getView
} // EingabelisteAdapter
