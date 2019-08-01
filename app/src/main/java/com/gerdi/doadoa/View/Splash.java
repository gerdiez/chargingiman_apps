package com.gerdi.doadoa.View;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gerdi.doadoa.R;

public class Splash extends AppCompatActivity {
    private int waktu_loading=2000;

    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent home=new Intent(Splash.this, MainActivity.class);
                startActivity(home);
                finish();

            }
        },waktu_loading);
    }
}
