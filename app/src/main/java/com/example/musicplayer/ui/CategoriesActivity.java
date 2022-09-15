package com.example.musicplayer.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.GridView;

import com.example.musicplayer.IcategoryListener;
import com.example.musicplayer.decoration.GridSpacingItemDecoration;
import com.example.musicplayer.R;
import com.example.musicplayer.adapter.RVAdapter;

public class CategoriesActivity extends AppCompatActivity {

    GridView gridView;
    RecyclerView recyclerView;
    int[] images = {R.drawable.rock, R.drawable.pop, R.drawable.classical, R.drawable.hiphop, R.drawable.sad, R.drawable.rap, R.drawable.folk};
    String[] titles = {"Rock", "Pop Music", "Classical Music", "Hip Hop", "Sad Music", "Rap", "Folk Music"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        /*gridView = findViewById(R.id.categoriesRecyclerView);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(getApplicationContext(), images, titles);
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CategoriesActivity.this, CategoryDetailActivity.class);
                intent.putExtra("category", titles[i]);
                startActivity(intent);
            }
        });*/

        recyclerView = findViewById(R.id.categoriesRecyclerView);
        RVAdapter rvAdapter = new RVAdapter(titles, images, new IcategoryListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(CategoriesActivity.this, CategoryDetailActivity.class);
                intent.putExtra("category", titles[position]);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(rvAdapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setLayoutManager(mLayoutManager);
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}