package com.apps.aashna.basicsensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Magnetic extends AppCompatActivity implements SensorEventListener{

    private TextView magnetic_xText, magnetic_yText, magnetic_zText;
    private Sensor sensor;
    private SensorManager SM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnetic);

        SM = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = SM.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        SM.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        magnetic_xText = (TextView)findViewById(R.id.magnetic_x_textview);
        magnetic_yText = (TextView)findViewById(R.id.magnetic_y_textview);
        magnetic_zText = (TextView)findViewById(R.id.magnetic_z_textview);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        magnetic_xText.setText(" "+sensorEvent.values[0]);
        magnetic_yText.setText(" "+sensorEvent.values[1]);
        magnetic_zText.setText(" "+sensorEvent.values[2]);
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
