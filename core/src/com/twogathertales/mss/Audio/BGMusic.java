package com.twogathertales.mss.Audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.*;
import com.badlogic.gdx.files.FileHandle;

public class BGMusic {

    private Music musicObject;

    public BGMusic(FileHandle file, float volume, boolean loop) {
        this.musicObject = Gdx.audio.newMusic(file);
        musicObject.setVolume(volume);
        musicObject.setLooping(loop);
        musicObject.play();
    }

    public void clean(){
        if(musicObject.isPlaying()) musicObject.stop();
        musicObject.dispose();
    }
}
