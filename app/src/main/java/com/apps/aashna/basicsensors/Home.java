package com.apps.aashna.basicsensors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        accelerometer();
        gyroscope();
        light();
        magnetic();
        proximity();
    }

    public void accelerometer() {

        Button accelButton = (Button)findViewById(R.id.accel_button);
        accelButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Home.this, Accel.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void gyroscope() {
        Button gyroButton = (Button)findViewById(R.id.gyrosc_button);
        gyroButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Home.this, Gyrosc.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void light() {
        Button lightButton = (Button)findViewById(R.id.light_button);
        lightButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Home.this, Light.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void magnetic() {
        Button magneticButton = (Button)findViewById(R.id.magnetic_button);
        magneticButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Home.this, Magnetic.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void proximity() {
        Button proxButton = (Button)findViewById(R.id.prox_button);
        proxButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Home.this, Proximity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
