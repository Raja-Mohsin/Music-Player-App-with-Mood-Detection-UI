package com.example.musicplayer.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.musicplayer.R;

public class Dashboard extends AppCompatActivity {
    CardView moodCard;
    CardView categoriesCard;
    CardView profileCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        moodCard = findViewById(R.id.firstCard);
        categoriesCard = findViewById(R.id.secondCard);
        profileCard = findViewById(R.id.thirdCard);

        moodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, MoodDetectionActivity.class);
                startActivity(intent);
            }
        });

        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, MyProfileActivity.class);
                startActivity(intent);
            }
        });

        categoriesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });
    }
}