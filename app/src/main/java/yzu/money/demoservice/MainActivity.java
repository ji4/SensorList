package yzu.money.demoservice;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnStop;
    Button btnTestSensor;
    SensorManager sensorManager;
    TextView tv;
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
                List lsensor=sensorManager.getSensorList(Sensor.TYPE_ALL);
                tv= (TextView) findViewById(R.id.textView);
                tv.setText(lsensor.size());
            }
        });
    }
}
