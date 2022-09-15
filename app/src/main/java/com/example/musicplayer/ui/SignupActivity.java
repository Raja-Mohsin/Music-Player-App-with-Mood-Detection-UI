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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicplayer.R;

public class SignupActivity extends AppCompatActivity {

    EditText nameTextView, emailTextView, passwordTextView;
    RadioButton maleRadioButton, femaleRadioButton;
    TextView textView;
    Button button;
    Animation blinkAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        textView = findViewById(R.id.loginTextView);
        button = findViewById(R.id.buttonSU);

        nameTextView = findViewById(R.id.nameEditTextSU);
        emailTextView = findViewById(R.id.emailEditTextSU);
        passwordTextView = findViewById(R.id.passEditTextSU);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);

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

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //name validation
                String extractedNameText = nameTextView.getText().toString().trim();
                if(extractedNameText == "" || extractedNameText.length()<4)
                {
                    Toast.makeText(getApplicationContext(), "Name should be at least 5 characters long", Toast.LENGTH_SHORT).show();
                    return;
                }

                //email validation
                String extractedEmailText = emailTextView.getText().toString().trim();
                if(extractedEmailText == "" || !extractedEmailText.contains("@") || extractedEmailText.length()<6)
                {
                    Toast.makeText(getApplicationContext(), "Enter a valid email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                //password validation
                String extractedPasswordText = passwordTextView.getText().toString().trim();
                if(extractedPasswordText == "" || extractedPasswordText.length()<6)
                {
                    Toast.makeText(getApplicationContext(), "Password should be at least 7 characters long", Toast.LENGTH_SHORT).show();
                    return;
                }

                //gender validation
                if(!maleRadioButton.isChecked() && !femaleRadioButton.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "Select a gender", Toast.LENGTH_SHORT).show();
                    return;
                }

                button.setVisibility(View.VISIBLE);
                button.startAnimation(blinkAnimation);
                Intent intent = new Intent(SignupActivity.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }
}