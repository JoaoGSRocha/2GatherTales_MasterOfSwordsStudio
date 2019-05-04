package com.twogathertales.mss.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.TimeUtils;

public class MapManager {

    private String Maps[] = {"0.jpg","1.jpg","2.jpg","3.jpg","4.jpg"};
    private int mapsLenght;
    private static int time =0;
    private int currentIndex=0;
    private Texture[] bgs;
    public static int points = 0;
    private long updateTimeMs = 0;
    private long updatePointsMs = 0;
    private BitmapFont bitmapFont;

    public int getPoints() {
        return points;
    }

    public void addPoints(int point) {
        this.points += point;
    }

    public int getTime() {
        return time;
    }

    public void addTime(int time) {
        this.time += time;
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

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans-ExtraBold.ttf"));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = 24;
        parameter.shadowOffsetX = parameter.shadowOffsetY = 2;
        parameter.borderWidth = 1;
        bitmapFont = generator.generateFont(parameter);
        generator.dispose();
    }

    public void addPointsOverTime() {
        long currentPoints = TimeUtils.millis();

        if(currentPoints - updatePointsMs > 5000){
            addPoints(15);
            System.out.println("points: "+points);
            updatePointsMs = currentPoints;
        }
    }

    public void timePass() {
        long currentTime = TimeUtils.millis();

        if(currentTime - updateTimeMs > 300){
            addTime(1);
            System.out.println("time: "+time);
            updateTimeMs = currentTime;
        }
    }

    public void render (Batch batch) {
        timePass();
        addPointsOverTime();
        if(time <10){
            currentIndex=0;
        }else if(time >=50 && time <100){
            currentIndex=1;
        }else if(time >=100 && time <200){
            currentIndex=2;
        }else if(time >=200 && time <300){
            currentIndex=3;
        }else if(time >=300){
            currentIndex=4;
        }

        batch.draw(bgs[currentIndex], 0, 0);
        bitmapFont.draw(batch,"Points: "+points,20,Gdx.graphics.getHeight()-20);

    }
}
