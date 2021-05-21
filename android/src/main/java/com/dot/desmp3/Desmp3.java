package com.dot.desmp3;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import com.getcapacitor.Plugin;

import com.getcapacitor.PluginCall;

public class Desmp3 {

    private MediaPlayer mediaPlayer = new MediaPlayer();
    private Context context;
    public Desmp3Plugin desmp3Plugin;
    Desmp3(){
        
    }
    public void setup(Desmp3Plugin desmp3Plugin){
        this.desmp3Plugin = desmp3Plugin;
        this.context = desmp3Plugin.getContext();
    }


    private void initMediaPlayer(PluginCall call,String url) {
        try {
            Log.e("dot","initMediaPlayer:"+url);
            if (mediaPlayer != null) { 
                mediaPlayer.stop();
            }
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(this.context,Uri.parse(url));
            mediaPlayer.setLooping(false);
            mediaPlayer.prepare();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    Log.e("dot","onCompletion");
                    desmp3Plugin.onCompleted();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String  start(PluginCall call,String value) {
        initMediaPlayer(call,value);
         if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            return "yes";
        }
        return "";
    }

    public String pause() {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            return "yes";
        }
        return "";
    }

    public String stop() {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.reset();
            return "yes";
        }
        return "";
    }

    public String echo(String value) {
        return value;
    }
}
