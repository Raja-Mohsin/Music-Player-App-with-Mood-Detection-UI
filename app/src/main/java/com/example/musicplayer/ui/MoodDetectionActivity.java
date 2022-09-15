package com.example.musicplayer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.musicplayer.R;

public class MoodDetectionActivity extends AppCompatActivity {

    Button takePicButton, nextButton;
    Animation blinkAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_detection);

        takePicButton = findViewById(R.id.takePicButton);
        nextButton = findViewById(R.id.nextButton);

        blinkAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_animation);
        blinkAnimation.setInterpolator(new AccelerateInterpolator());
        blinkAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                takePicButton.setVisibility(View.VISIBLE);
                nextButton.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                nextButton.clearAnimation();
                takePicButton.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        takePicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicButton.setVisibility(View.VISIBLE);
                takePicButton.startAnimation(blinkAnimation);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextButton.setVisibility(View.VISIBLE);
                nextButton.startAnimation(blinkAnimation);
            }
        });
    }
}