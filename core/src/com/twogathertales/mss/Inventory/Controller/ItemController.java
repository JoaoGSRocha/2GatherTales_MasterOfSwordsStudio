package com.twogathertales.mss.Inventory.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.twogathertales.mss.Inventory.Model.Item;
import com.twogathertales.mss.Inventory.Model.ItemsCity;
import com.twogathertales.mss.Inventory.Model.ItemsPlayer;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ItemController {
    final static int WIN_HEIGHT = 480;
    float timeSinceClicking = 0;
    ItemsCity itemsCity = new ItemsCity();
    ItemsPlayer itemsPlayer = new ItemsPlayer();
    ArrayList<Item> itemAL = new ArrayList<Item>();
    public void create(){
        itemAL.addAll(itemsCity.getItems());
        itemAL.addAll(itemsPlayer.getItems());
    }

    public void render(Batch batch){
        renderPlayerItems(batch);
        renderCityItems(batch);
        sellItems();
    }

    @Nullable
    /***
     * clickedItem()
     * Gdx.input.getY() uses a reversed coordiante.
     */
    private Item clickedItem(){
        for(Item item : itemAL) {
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
                if (clickedItem().getQuantity() > 0)
                    clickedItem().setQuantity(clickedItem()
                            .getQuantity()-1);
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
                if(lootItem.equals(item.getName()))
                    item.setQuantity(currQuant++);
        }
    }

    public void dispose(){
        itemsCity.dispose();
        itemsPlayer.dispose();
    }
}
