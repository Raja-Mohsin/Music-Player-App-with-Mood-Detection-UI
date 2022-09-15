package com.example.musicplayer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.musicplayer.R;

public class ListViewAdapter extends BaseAdapter {

    Context context;
    String[] mSongs;
    String[] mArtists;
    private static LayoutInflater inflater = null;

    public ListViewAdapter(Context context, String[] songs, String[] artists) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.mSongs = songs;
        this.mArtists = artists;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mSongs.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mSongs[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.single_list_view_item, null);
        TextView songName = (TextView) vi.findViewById(R.id.singleListName);
        songName.setText(mSongs[position]);
        TextView artistName = (TextView) vi.findViewById(R.id.singleListArtist);
        artistName.setText(mArtists[position]);
        return vi;
    }
}
