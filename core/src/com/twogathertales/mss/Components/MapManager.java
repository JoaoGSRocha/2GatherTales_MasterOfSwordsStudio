package com.twogathertales.mss.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class MapManager {
    private String Maps[] = {"0.jpg","1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg"};
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
        }else if(points>=100 && points<200){
            currentIndex=1;
        }else if(points>=200 && points<300){
            currentIndex=2;
        }else if(points>=300 && points<400){
            currentIndex=3;
        }else if(points>=300 && points<500){
            currentIndex=4;
        }else if(points>=400 && points<600){
            currentIndex=5;
        }else if(points>=500 && points<700){
            currentIndex=6;
        }else if(points>=600 && points<700){
            currentIndex=7;
        }else if(points>=10 && points<20){
            currentIndex=8;
        }
        batch.draw(bgs[currentIndex], 0, 0);
    }
}
