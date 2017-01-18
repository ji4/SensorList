package yzu.money.demoservice;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity/* implements SensorEventListener*/{//imelemnt介面
    Button btnStart, btnStop;
    Button btnTestSensor;
    SensorManager sensorManager;
    TextView tv;
    //SensorEventListener sel=new SensorEventListener() {
    //}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart= (Button) findViewById(R.id.button);
        btnStart.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent it =new Intent(MainActivity.this,MyService.class);
                startService(it);
            }
        });

        btnStop= (Button) findViewById(R.id.button2);
        btnStop.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent it =new Intent(MainActivity.this,MyService.class);
                startService(it);
            }
        });

        //---------------------------------------
        btnTestSensor= (Button) findViewById(R.id.button3);
        btnTestSensor.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
                List<Sensor> lsensor=sensorManager.getSensorList(Sensor.TYPE_ALL);
                tv= (TextView) findViewById(R.id.textView);
                tv.setText(String.valueOf(lsensor.toString()));
                System.out.println(lsensor.toString());
                /*Sensor s=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                if(s!=null)
                    sensorManager.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
                //sensorManager.registerListener(this,lsensor.get(0),SensorManager.SENSOR_DELAY_NORMAL);
                sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);*/
            }
        });
    }

    /*@Override
    public void onSensorChanged(SensorEvent event) {
        float []v=event.values;
        Log.i("test",String.valueOf(v[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }*/
}
