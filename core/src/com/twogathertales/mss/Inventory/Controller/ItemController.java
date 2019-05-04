package com.twogathertales.mss.Inventory.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.twogathertales.mss.Components.MapManager;
import com.twogathertales.mss.Inventory.Model.Item;
import com.twogathertales.mss.Inventory.Model.ItemsCity;
import com.twogathertales.mss.Inventory.Model.ItemsPlayer;

import java.util.ArrayList;

public class ItemController {
    private int pointsPerQuest = 150;
    private BitmapFont bitmapFont;
    private MapManager map;
    private boolean drawLoot = false;
    private String[] lootToDraw;
    private long startTimeMs;
    final static int WIN_HEIGHT = 480;
    float timeSinceClicking = 0;
    public static ItemsCity itemsCity = new ItemsCity();
    public static ItemsPlayer itemsPlayer = new ItemsPlayer();
    public void create(){
        map = new MapManager();

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans-SemiBold.ttf"));
        FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 14;
        parameter.color = new Color(100f/255f, 160f/255f, 20f/255f, 1);
        parameter.shadowOffsetX = parameter.shadowOffsetY = 2;
        parameter.borderWidth = 2;
        bitmapFont = generator.generateFont(parameter);
        generator.dispose();
    }

    public void render(Batch batch){
        renderPlayerItems(batch);
        renderCityItems(batch);
        sellItems();
        if(drawLoot) {
          showLootDraw(batch);
        }
    }

    /***
     * clickedItem()
     * Gdx.input.getY() uses a reversed coordinate.
     */

    private Item clickedItem(){
        for(Item item : itemsPlayer.getItems()) {
            if (Gdx.input.isTouched()) {
                Vector2 touchPos = new Vector2();
                touchPos.set(Gdx.input.getX(), -Gdx.input.getY()+WIN_HEIGHT);
                if (Intersector.intersectSegmentRectangle(
                        touchPos, touchPos, item.getRectangle()))
                    return item;
            }
        }
        return null;
    }

    private void sellItems(){
        timeSinceClicking += Gdx.graphics.getDeltaTime();
        if(timeSinceClicking > .1f) {
            if(clickedItem() != null)
                if (clickedItem().getQuantity() > 0) {
                    clickedItem().setQuantity(clickedItem()
                            .getQuantity() - 1);
                    for(Item item : itemsCity.getItems()){
                        if(item.getName().equals(clickedItem().getName())){
                            item.setQuantity(item.getQuantity()+1);
                        }
                    }
                    map.addPoints(100);
                }
            timeSinceClicking = 0;
        }
    }

    private void renderPlayerItems(Batch batch){
        for(Item item : itemsPlayer.getItems()) {
            batch.draw(item.getImg(), item.getRectangle().x,
                    item.getRectangle().y);
            item.getFont().draw(batch, String.valueOf(item.getQuantity()),
                    item.getLblCoord_X(), item.getLblCoord_Y());
        }
    }

    private void renderCityItems(Batch batch) {
        for (Item item : itemsCity.getItems()) {
            batch.draw(item.getImg(), item.getRectangle().x,
                    item.getRectangle().y);
            item.getFont().draw(batch, String.valueOf(item.getQuantity()),
                    item.getLblCoord_X(), item.getLblCoord_Y());
        }
    }

    public void addMissionLoot(String[] items){
        for(Item item : itemsPlayer.getItems()){
            int currQuant = item.getQuantity();
            for(String lootItem : items)
                if(lootItem.equals(item.getName())) {
                    item.setQuantity(++currQuant);
                    System.out.println("Adding one " + item.getName() + " " + item.getQuantity());
                }
        }
        showLoot(items);
        MapManager.points+=150;
    }

    public void showLoot(String[] items){
        lootToDraw = items;
        drawLoot = true;
        startTimeMs = TimeUtils.millis();
    }

    public void showLootDraw(Batch batch){
        bitmapFont.draw(batch,"Quest completed!",190,280);
        bitmapFont.draw(batch,"You obtained:",190,264);
        int y = 248;
        for(String s : lootToDraw){
            bitmapFont.draw(batch,"1x "+s,190,y);
            y-=16;
        }
        if(pointsPerQuest>0){
            bitmapFont.draw(batch,pointsPerQuest+" Points",190,y);
        }

        if(TimeUtils.millis()-startTimeMs>2500){
            drawLoot = false;
        }
    }

    public void dispose(){
        itemsCity.dispose();
        itemsPlayer.dispose();
    }
}
