package com.apps.aashna.basicsensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Accel extends AppCompatActivity implements SensorEventListener{

    private TextView accel_xText, accel_yText, accel_zText;
    private Sensor sensor;
    private SensorManager SM;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        accel_xText.setText(" "+sensorEvent.values[0]);
        accel_yText.setText(" "+sensorEvent.values[1]);
        accel_zText.setText(" "+sensorEvent.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accel);

        SM = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SM.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        accel_xText = (TextView)findViewById(R.id.gyrosc_x_textview);
        accel_yText = (TextView)findViewById(R.id.gyrosc_y_textview);
        accel_zText = (TextView)findViewById(R.id.gyrosc_z_textview);
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
