package com.dot.desmp3;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

public class Desmp3 {

    private MediaPlayer mediaPlayer = new MediaPlayer();
    private Context context;
    Desmp3(){
        
    }
    public void setup(Context context){
        this.context = context;
    }


    private void initMediaPlayer(String url) {
        try {
            mediaPlayer.setDataSource(this.context,Uri.parse(url));
            mediaPlayer.setLooping(false);
            mediaPlayer.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String  start(String value) {
        initMediaPlayer(value);
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
