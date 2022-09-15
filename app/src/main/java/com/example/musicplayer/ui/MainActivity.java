package com.example.musicplayer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicplayer.R;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    Animation blinkAnimation;
    EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditTextLogin);
        passwordEditText = findViewById(R.id.passwordEditTextLogin);

        textView = findViewById(R.id.registerTextView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

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

        button = findViewById(R.id.buttonLogin);
        button.setVisibility(View.VISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //email validation
                String extractedEmailText = emailEditText.getText().toString().trim();
                if(extractedEmailText.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Email address field can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                //password validation
                String extractedPasswordText = passwordEditText.getText().toString().trim();
                if(extractedPasswordText.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Password field can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                button.setVisibility(View.VISIBLE);
                button.startAnimation(blinkAnimation);
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }
}