package com.example.musicplayer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.musicplayer.R;
import com.example.musicplayer.adapter.ListViewAdapter;

public class CategoryDetailActivity extends AppCompatActivity {
    TextView categoryTextView;
    ListView listView;
    String[] songs = {"Arcade", "Let me down slowly", "Believe in me", "Need To KnowDoja Cat", "See You Again", "Blank Space", "Megan Thee Stallion", "Shape of You"};
    String[] artists = {"Ed Sheeran", "Alan Walker", "Sia", "Ed Sheeran", "Chain smokers", "Alan Walker", "Justin Bieber", "Ed Sheeran"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        categoryTextView = (TextView) findViewById(R.id.categoryTextView);

        /*ArrayList<SingleListViewItem> songsList = new ArrayList<SingleListViewItem>();
        for(int i=0; i<songs.length; i++)
        {
            songsList.add(new SingleListViewItem(songs[i], artists[i]));
        }*/

        Intent intent = getIntent();
        String selectedCategory = intent.getStringExtra("category");
        categoryTextView.setText(selectedCategory);

        listView = findViewById(R.id.categoryDetailListView);
        listView.setHeaderDividersEnabled(true);
        listView.setFooterDividersEnabled(true);
        ListViewAdapter listViewAdapter = new ListViewAdapter(getApplicationContext(), songs, artists);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(CategoryDetailActivity.this, MusicPlayerActivity.class);
                startActivity(intent1);
            }
        });
    }
}