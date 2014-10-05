package mikecanco.de.leekspin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.VideoView;


public class LeekSpinActivity extends Activity {

    public static String TAG = "mikecanco.de.leekspin";

    Handler handler;
    Runnable runnable;


    SharedPreferences prefs;

    int timeLeeked;

    String timePref = "timeLeeked";
    String maxTimePref = "maxTimeLeeked";

    TextView tvTime;
    TextView tvMaxTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leek_spin);
        getActionBar().hide();
        prefs = this.getSharedPreferences("LeekspinPrefs", 0);

        tvTime = (TextView) findViewById(R.id.tvTime);
        tvMaxTime = (TextView) findViewById(R.id.tvMaxTime);

        // App was started. Set timer to zero.
        timeLeeked = 0;



    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
        tvMaxTime.setText(formatTime(prefs.getInt(maxTimePref, 0)));

        final VideoView videoView =
                (VideoView) findViewById(R.id.video);

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.leek_spin));

//        MediaController mediaController = new
//                MediaController(this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });
        videoView.start();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                /* do what you need to do */
                updateTimeLeeked();
                /* and here comes the "trick" */
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
        // start handler again
        //
        timeLeeked = 0;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
        updateMaxTimeLeeked();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
//        updateMaxTimeLeeked();
        // get rid of handler or something

        // ahh code

        // update time leeked to maximum maybe?
    }

    private void updateMaxTimeLeeked() {
        int maxTime = prefs.getInt(maxTimePref, 0);
        int now = timeLeeked;
        if (now > maxTime) {
            prefs.edit().putInt(maxTimePref, now).apply();
        }
    }

    private void updateTimeLeeked() {
        timeLeeked += 1;
        prefs.edit().putInt(timePref, timeLeeked).apply();
        updateTimeViews(timeLeeked);

    }

    private void updateTimeViews(int timeLeeked) {
        tvTime.setText(formatTime(timeLeeked));

    }


    private String formatTime(int time) {

       String hours = String.valueOf(time / 3600);
       String minutes = String.valueOf((time % 3600) / 60);
       String seconds = String.valueOf(time % 60);

       if (seconds.equals("0"))
           seconds = "00";

        if (minutes.equals("0"))
            minutes = "00";

        if (hours.equals("0"))
            hours = "00";

        //TODO: add days.

        String timeString = hours + ":" + minutes + ":" + seconds;

        return timeString;
    }


}
