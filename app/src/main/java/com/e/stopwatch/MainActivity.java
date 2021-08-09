package com.e.stopwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt1 , txt2;
    Button b1;
    ImageView imv1;
    Animation atg , fade , blink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.tv1);
        txt2 = findViewById(R.id.tv2);
        b1 = findViewById(R.id.btn1);
        imv1 = findViewById(R.id.iv1);

        //Loads animation
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        fade = AnimationUtils.loadAnimation(this, R.anim.fade);
        blink = AnimationUtils.loadAnimation(this, R.anim.blink);

        //Passing animation
        imv1.startAnimation(atg);
        b1.startAnimation(atg);
        txt1.startAnimation(blink);
        txt2.startAnimation(blink);

        //Passing Event
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this , Stopwatch_Activity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }
}
