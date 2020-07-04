package com.example.kadai10;
import androidx.appcompat.app.AppCompatActivity;
import  android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private  SensorManager mSensorManager;
    private Sensor mGyrometer;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView) findViewById(R.id.textview);
        mSensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        mGyrometer=mSensorManager.getDefaultSensor(Sensor. TYPE_GYROSCOPE);
    }
    @Override
    protected void onResume(){
        super .onResume();
        mSensorManager.registerListener(this, mGyrometer,SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy){
    }
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType() == Sensor. TYPE_GYROSCOPE){
            tv.setText("Pitch:"+event.values[0]+"\n"+
                    "Roll:"+ event.values[1]+ "\n"+
                    "Azimuth:"+ event.values[2] );
        }
    }
}