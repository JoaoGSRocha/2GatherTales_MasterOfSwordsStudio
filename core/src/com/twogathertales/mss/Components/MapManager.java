package com.twogathertales.mss.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class MapManager {
    private String Maps[] = {"0.jpg","1.jpg"};
    private int mapsLenght;
    private int points=0;
    private int currentIndex=0;
    private Texture[] bgs;

    public int getPoints() {
        return points;
    }

    public void addPoints(int point) {
        this.points += point;
    }

    public void removePoints(int point) {
        this.points -= point;
    }

    public void create () {
        mapsLenght = Maps.length;
        bgs = new Texture[mapsLenght];

        for (int i = 0; i < mapsLenght; i++){
            String fileName = Maps[i];
            bgs[i] = new Texture(Gdx.files.internal("Maps/"+fileName));
        }
    }

    public void render (Batch batch) {
        if(points<10){
            currentIndex=0;
        }else if(points>=10 && points<20){
            currentIndex=1;
        }
        batch.draw(bgs[currentIndex], 0, 0);
    }
}
