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
    private TextView accel_xMin, accel_xMax, accel_yMin, accel_yMax, accel_zMin, accel_zMax;
    private Sensor sensor;
    private SensorManager SM;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        accel_xText.setText(" "+sensorEvent.values[0]);
        accel_yText.setText(" "+sensorEvent.values[1]);
        accel_zText.setText(" "+sensorEvent.values[2]);

        if(((String)accel_xMin.getText()).equals("xMin") || sensorEvent.values[0] < Float.valueOf((String)accel_xMin.getText())) accel_xMin.setText(" "+sensorEvent.values[0]);
        if(((String)accel_yMin.getText()).equals("yMin") || sensorEvent.values[1] < Float.valueOf((String)accel_yMin.getText())) accel_yMin.setText(" "+sensorEvent.values[1]);
        if(((String)accel_zMin.getText()).equals("zMin") || sensorEvent.values[2] < Float.valueOf((String)accel_zMin.getText())) accel_zMin.setText(" "+sensorEvent.values[2]);

        if(((String)accel_xMax.getText()).equals("xMax") || sensorEvent.values[0] > Float.valueOf((String)accel_xMax.getText())) accel_xMax.setText(" "+sensorEvent.values[0]);
        if(((String)accel_yMax.getText()).equals("yMax") || sensorEvent.values[1] > Float.valueOf((String)accel_yMax.getText())) accel_yMax.setText(" "+sensorEvent.values[1]);
        if(((String)accel_zMax.getText()).equals("zMax") || sensorEvent.values[2] > Float.valueOf((String)accel_zMax.getText())) accel_zMax.setText(" "+sensorEvent.values[2]);
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

        accel_xText = (TextView)findViewById(R.id.accel_x_textview);
        accel_yText = (TextView)findViewById(R.id.accel_y_textview);
        accel_zText = (TextView)findViewById(R.id.accel_z_textview);

        accel_xMin = (TextView)findViewById(R.id.accel_x_min_text);
        accel_yMin = (TextView)findViewById(R.id.accel_y_min_text);
        accel_zMin = (TextView)findViewById(R.id.accel_z_min_text);

        accel_xMax = (TextView)findViewById(R.id.accel_x_max_text);
        accel_yMax = (TextView)findViewById(R.id.accel_y_max_text);
        accel_zMax = (TextView)findViewById(R.id.accel_z_max_text);
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
