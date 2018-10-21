package com.apps.aashna.basicsensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Gyrosc extends AppCompatActivity implements SensorEventListener {

    private TextView gyrosc_xText, gyrosc_yText, gyrosc_zText;
    private Sensor sensor;
    private SensorManager SM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyrosc);

        SM = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = SM.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        SM.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        gyrosc_xText = (TextView)findViewById(R.id.accel_x_textview);
        gyrosc_yText = (TextView)findViewById(R.id.accel_y_textview);
        gyrosc_zText = (TextView)findViewById(R.id.accel_z_textview);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        gyrosc_xText.setText(" "+sensorEvent.values[0]);
        gyrosc_yText.setText(" "+sensorEvent.values[1]);
        gyrosc_zText.setText(" "+sensorEvent.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void onResume() {
        super.onResume();
        SM.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onStop() {
        super.onStop();
        SM.unregisterListener(this);
    }
}
