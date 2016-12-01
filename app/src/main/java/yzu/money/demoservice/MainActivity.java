package yzu.money.demoservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnStop;
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
    }
}
