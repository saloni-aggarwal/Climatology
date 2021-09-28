package com.example.brij.sunshine;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Splash_screen extends Activity implements Animation.AnimationListener {
    boolean ic;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       ic=mybroadcast.check_error(Splash_screen.this);



         img=(ImageView)findViewById(R.id.splash_img);
        Animation animation;
        animation= AnimationUtils.loadAnimation(this,R.anim.bounce);
        animation.setAnimationListener(this);
        img.startAnimation(animation);

        TextView text=(TextView)findViewById(R.id.spash_text);
        animation= AnimationUtils.loadAnimation(this,R.anim.zoom_out);
        animation.setAnimationListener(this);
        text.startAnimation(animation);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(ic==true)
                {
                    Toast.makeText(Splash_screen.this, "Active connection", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Splash_screen.this,MainActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.open_next,0);
                    finish();
                }
                else
                {
                    Toast.makeText(Splash_screen.this, "No connection", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Splash_screen.this,No_connection.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.open_main,0);
                    finish();

                }



            }
        },4000);
    }

    @Override
    public void onAnimationStart(Animation animation) {


    }

    @Override
    public void onAnimationEnd(Animation animation) {




    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
