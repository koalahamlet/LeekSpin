package mikecanco.de.leekspin;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;


public class LeekSpinActivity extends Activity {

    public static String TAG = "mikecanco.de.leekspin";
    VideoView videoView;
    VideoView video;
    MediaController mediaController;
//    MediaController ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leek_spin);

//        final VideoView mVideoView = (VideoView) findViewById(R.id.video);
//        mVideoView.setVideoPath("https://www.youtube.com/watch?v=IVGE5J7-3AQ");
//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(mVideoView);
//        mVideoView.setMediaController(mediaController);
//        mVideoView.requestFocus();
//        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            // Close the progress bar and play the video
//            public void onPrepared(MediaPlayer mp) {
//                mVideoView.start();
//            }
//        });

//
//        videoView.findViewById(R.id.bob);
//        mediaController.findViewById(R.id.joe);
//        getWindow().setFormat(PixelFormat.TRANSLUCENT);
//        Environment.getExternalStorageDirectory().setReadable(true);
//        File clip = new File(Environment.getExternalStorageDirectory(),
//                "leek_spin.mp4");
//        if (clip.exists()) {
//            Log.e("DEBUG", "got inside!");
//            video = (VideoView) findViewById(R.id.video);
//            video.setVideoPath(clip.getAbsolutePath());
//            MediaController ctlr = new MediaController(this);
//            ctlr.setMediaPlayer(video);
//            video.setMediaController(ctlr);
//            video.requestFocus();
//            video.start();
//            // tried this. full of fail.
////        videoView.setMediaController(mediaController);
////        Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.leek_spin);
////        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.leek_spin));
//        } else {
//            Log.e("DEBUG", "couldn't find video");
//            Log.e("DEBUG", "lets look at what we could find: " +Environment.getExternalStorageDirectory().getAbsolutePath());
//            Log.e("DEBUG", "can read?: " + Environment.getExternalStorageDirectory().canRead());
//            Environment.getExternalStorageDirectory().setReadable(true);
//            Log.e("DEBUG", "lets look at what we could find: "+Environment.getExternalStorageDirectory().getPath());
//            File[] files = Environment.getExternalStorageDirectory().listFiles();
//            for (File file:files){
//                Log.e("DEBUG", "filey:"+ file.toURI().toString());
//                Log.e("DEBUG", "file:"+ file.getName().toString());
//            }
//        }


    }


    @Override
    protected void onStart() {
        super.onStart();

        final VideoView videoView =
                (VideoView) findViewById(R.id.video);


        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.leek_spin));

        MediaController mediaController = new
                MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()  {
                                                    @Override
                                                    public void onPrepared(MediaPlayer mp) {
                                                        Log.i(TAG, "Duration = " +
                                                                videoView.getDuration());
                                                    }
                                                });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });
        videoView.start();



    }
}
