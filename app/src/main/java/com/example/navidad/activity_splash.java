package com.example.navidad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import in.codeshuffle.typewriterview.TypeWriterView;

import static com.example.navidad.R.string.entrada;

public class activity_splash extends Activity {

    final  int tiempoTranscurrir = 20000; //1 segundo, 1000 millisegundos.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_layout);


        TextView tx = (TextView)findViewById(R.id.entrada);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "TravelingTypewriter.ttf");

        tx.setTypeface(custom_font);

        //Create Object and refer to layout view
        TypeWriterView typeWriterView=(TypeWriterView)findViewById(R.id.entrada);

        //Setting each character animation delay
        typeWriterView.setDelay(2000);

        //Setting music effect On/Off
        typeWriterView.setWithMusic(true);

        //Animating Text
        String txtentrada = getString(entrada);
        typeWriterView.animateText(txtentrada);

        ImageView iv = (ImageView) findViewById(R.id.campana);
        Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.animacion_imagen);
        iv.startAnimation(an);

        an.setAnimationListener(new Animation.AnimationListener() {
                                    @Override
                                    public void onAnimationStart(Animation animation) {
                                    }

                                    @Override
                                    public void onAnimationEnd(Animation animation) {
                                        finish();
                                        Intent i = new Intent(getBaseContext(), VideoActivity.class);
                                        startActivity(i);
                                    }

                                    @Override
                                    public void onAnimationRepeat(Animation animation) {

                                    }
            });

/*            Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //***Aquí agregamos el proceso a ejecutar.

                Intent intent = new Intent(getApplicationContext(),  VideoActivity.class);
                startActivity(intent);

                handler.removeCallbacks(null);
                finish();
            }
        }, tiempoTranscurrir );//define el tiempo.*/




        //Remove Animation. This is required to be called when you want to minimize the app while animation is going on. Call this in onPause() or onStop()
        //typeWriterView.removeAnimation();

    }
}
