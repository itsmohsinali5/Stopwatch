package com.e.stopwatch;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;


public class Stopwatch_Activity extends AppCompatActivity {

    Button btnstart;
    Button btnstop;
    ImageView icanchor;
    Animation round;
    Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch_);

        btnstart = findViewById(R.id.btnst1);
        btnstop = findViewById(R.id.btnst2);
        icanchor = findViewById(R.id.iv1);
        timer = findViewById(R.id.timer);



        //Create optional Animation
        btnstop.setAlpha(0);

        //Load Animation
        round = AnimationUtils.loadAnimation(this, R.anim.round);
        round.setRepeatCount(Animation.INFINITE);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Passing Animation
                icanchor.startAnimation(round);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();

                //Start Time
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();

            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* icanchor.startAnimation(round);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(1).setDuration(300).start();

                //End Time
                timer.setBase(SystemClock.elapsedRealtime());*/
                icanchor.clearAnimation();
                timer.stop();
                btnstart.animate().alpha(1).setDuration(300).start();

            }
        });

    }
}
