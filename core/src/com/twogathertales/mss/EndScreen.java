package com.twogathertales.mss;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.twogathertales.mss.Components.MapManager;

import java.util.Map;


public class EndScreen {

    private BitmapFont bitmapFontVictory;
    private BitmapFont bitmapFontDefeat;
    private BitmapFont bitmapFont;

    public void create(){
        FreeTypeFontGenerator generatorExtrabold = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans-ExtraBold.ttf"));
        FreeTypeFontGenerator generatorSemibold = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans-SemiBold.ttf"));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = 72;
        parameter.borderWidth = 4;
        parameter.borderColor = Color.WHITE;
        parameter.color = new Color(100f/255f, 160f/255f, 20f/255f, 1);
        bitmapFontVictory = generatorExtrabold.generateFont(parameter);
        parameter.color = Color.RED;
        bitmapFontDefeat = generatorExtrabold.generateFont(parameter);
        parameter.size = 24;
        parameter.borderWidth = 2;
        parameter.color = Color.BLACK;
        bitmapFont = generatorSemibold.generateFont(parameter);
        generatorExtrabold.dispose();
        generatorSemibold.dispose();



    }

    public void render(Batch batch){
        batch.draw(new Texture(Gdx.files.internal("Maps/4.jpg")), 0, 0);
        if(MapManager.points>=3000){
            bitmapFontVictory.draw(batch,"Victory",20,400);
        } else{
            bitmapFontDefeat.draw(batch,"Defeat",20,400);
        }
        bitmapFont.draw(batch,"Points: "+ MapManager.points,40,320);
    }
}
