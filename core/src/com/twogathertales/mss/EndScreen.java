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
    private BitmapFont bitmapFontCredits;
    private BitmapFont bitmapFontCreditsMusic;

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

        FreeTypeFontParameter parameterCredits = new FreeTypeFontParameter();
        parameterCredits.size = 18;
        parameterCredits.shadowOffsetX = parameter.shadowOffsetY = 1;
        parameterCredits.borderWidth = 1;
        bitmapFontCredits = generatorSemibold.generateFont(parameterCredits);
        parameterCredits.size = 12;
        bitmapFontCreditsMusic = generatorSemibold.generateFont(parameterCredits);

        generatorExtrabold.dispose();
        generatorSemibold.dispose();

    }

    public void render(Batch batch){
        batch.draw(new Texture(Gdx.files.internal("Maps/4.jpg")), 0, 0);
        if(MapManager.points>=10000){
            bitmapFontVictory.draw(batch,"Victory",20,400);
        } else{
            bitmapFontDefeat.draw(batch,"Defeat",20,400);
        }
        bitmapFont.draw(batch,"Points: "+ MapManager.points,40,320);

        bitmapFontCredits.draw(batch,"Credits: ",40,240);
        bitmapFontCredits.draw(batch,"Lead Developer:",40,200);
        bitmapFontCredits.draw(batch,"Tiago \"Risky\" Cabral",40,180);

        bitmapFontCredits.draw(batch,"Developers:",40,140);
        bitmapFontCredits.draw(batch,"João Rocha",40,120);
        bitmapFontCredits.draw(batch,"Alexandre Nunes",40,100);

        bitmapFontCredits.draw(batch,"Artist:",300,200);
        bitmapFontCredits.draw(batch,"Érica Monteiro",300,180);

        bitmapFontCreditsMusic.draw(batch,"Music from https://filmmusic.io/:",260,140);
        bitmapFontCreditsMusic.draw(batch,"\"Achaidh Cheide\"",260,122);
        bitmapFontCreditsMusic.draw(batch,"by Kevin MacLeod (https://incompetech.com/)",260,104);
        bitmapFontCreditsMusic.draw(batch,"Licence:",260,86);
        bitmapFontCreditsMusic.draw(batch,"CC BY (http://creativecommons.org/licenses/by/4.0/)",260,68);

    }
}
