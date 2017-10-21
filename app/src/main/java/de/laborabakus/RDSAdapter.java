package de.laborabakus;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

// GridView-Tutorial: https://www.raywenderlich.com/127544/android-gridview-getting-started

public class RDSAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<Double> arr_x;

    // 1
    public RDSAdapter(Context context, List<Double> arr_x) {
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
/*
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1
        final double x = arr_x[position];

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linearlayout_book, null);
        }

        // 3
        final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
        final TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_book_name);
        final TextView authorTextView = (TextView)convertView.findViewById(R.id.textview_book_author);
        final ImageView imageViewFavorite = (ImageView)convertView.findViewById(R.id.imageview_favorite);

        // 4
        imageView.setImageResource(book.getImageResource());
        nameTextView.setText(mContext.getString(book.getName()));
        authorTextView.setText(mContext.getString(book.getAuthor()));

        return convertView;
    } // getView
*/
    public View getView(int position, View convertView, ViewGroup parent) {
        final double x = arr_x.get(position);

        TextView dummyTextView = new TextView(mContext);

        dummyTextView.setText(ActivityTools.fktDoubleToStringFormat(x, 4)); // 4 Nachkommastellen

        return dummyTextView;
    } // getView
} // RDSAdapter
