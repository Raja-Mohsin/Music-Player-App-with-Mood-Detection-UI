package com.example.musicplayer.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.musicplayer.R;

public class GridViewAdapter extends BaseAdapter {
    Context context;
    int[] images;
    String[] titles;
    LayoutInflater inflater;
    public GridViewAdapter(Context applicationContext, int[] mImages, String[] mTitles) {
        this.context = applicationContext;
        this.images = mImages;
        this.titles = mTitles;
        inflater = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return images.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.single_grid_item, null); // inflate the layout
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.gridLinearLayout); // get the reference of ImageView
        linearLayout.setBackgroundResource(images[i]);
        TextView textView = (TextView) view.findViewById(R.id.gridTextView);
        textView.setText(titles[i]);
        return view;
    }
}