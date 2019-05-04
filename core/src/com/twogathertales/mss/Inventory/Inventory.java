package com.twogathertales.mss.Inventory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.twogathertales.mss.Inventory.Controller.ItemController;

public class Inventory {

    private Texture inv_grid;
    public static ItemController itemController;
    private BitmapFont bitmapFont;

    public void create () {
        itemController = new ItemController();
        inv_grid = new Texture("bg_full.png");
        itemController.create();
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans-SemiBold.ttf"));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = 18;
        parameter.color = new Color(220f/255f, 160f/255f, 50f/255f, 1);
        parameter.shadowOffsetX = parameter.shadowOffsetY = 2;
        parameter.borderWidth = 2;
        bitmapFont = generator.generateFont(parameter);
        generator.dispose();
    }

    public void render (Batch batch) {
        batch.draw(inv_grid, 0, 0);
        bitmapFont.draw(batch,"Inventory",24,300);
        bitmapFont.draw(batch,"City",530,300);
        itemController.render(batch);
    }

    public void dispose () {
        itemController.dispose();
    }
}
