package yzu.money.demoservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import java.util.Date;

public class MyService extends Service {
    public MyService() {
    }
    Handler handler=new Handler();
    MediaPlayer mediaPlayer;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.postDelayed(show,1000);
        mediaPlayer=new MediaPlayer();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(show);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    Runnable show=new Runnable() {
        @Override
        public void run() {
            Log.i("time", new Date().toString());
            mediaPlayer.create(MyService.this,R.raw.ding);
            mediaPlayer.start();
            handler.postDelayed(this,1000);
        }
    };
}
