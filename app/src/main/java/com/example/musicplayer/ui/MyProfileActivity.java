package com.example.musicplayer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.musicplayer.R;

public class MyProfileActivity extends AppCompatActivity {

    Button button;
    Animation blinkAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        button = findViewById(R.id.editProfileButton);

        blinkAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_animation);
        blinkAnimation.setInterpolator(new AccelerateInterpolator());
        blinkAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.startAnimation(blinkAnimation);
            }
        });
    }
}