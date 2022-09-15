package com.example.musicplayer.animation;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Button;

public class BlinkAnimation {
    private Animation blinkAnimation;
    private Button button;
    public BlinkAnimation(Animation mBlinkAnimation)
    {
        this.blinkAnimation = mBlinkAnimation;
    }
    public void setInterpolator()
    {
        blinkAnimation.setInterpolator(new AccelerateInterpolator());
    }
    public void setAnimationListeners()
    {
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
    }
}
