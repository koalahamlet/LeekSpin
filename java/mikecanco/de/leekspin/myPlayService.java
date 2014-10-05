//package mikecanco.de.leekspin;
//
//import android.app.Service;
//import android.content.Intent;
//import android.media.MediaPlayer;
//import android.os.IBinder;
//
///**
// * Created by koalahamlet on 8/10/14.
// */
//public class myPlayService extends Service implements MediaPlayer.OnCompletionListener,
//        MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener,
//        MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener {
//    private MediaPlayer mediaPlayer = new MediaPlayer();
//    private String MediaURI;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        mediaPlayer.setOnCompletionListener(this);
//        mediaPlayer.setOnErrorListener(this);
//        mediaPlayer.setOnPreparedListener(this);
//        mediaPlayer.setOnBufferingUpdateListener(this);
//        mediaPlayer.setOnSeekCompleteListener(this);
//        mediaPlayer.setOnInfoListener(this);
//        mediaPlayer.reset();
//
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
//    }
//
//    @Override
//    public void onBufferingUpdate(MediaPlayer mp, int percent) {
//
//    }
//
//    @Override
//    public void onCompletion(MediaPlayer mp) {
//
//    }
//
//    @Override
//    public boolean onError(MediaPlayer mp, int what, int extra) {
//        return false;
//    }
//
//    @Override
//    public boolean onInfo(MediaPlayer mp, int what, int extra) {
//        return false;
//    }
//
//    @Override
//    public void onPrepared(MediaPlayer mp) {
//
//    }
//
//    @Override
//    public void onSeekComplete(MediaPlayer mp) {
//
//    }
//
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//}
