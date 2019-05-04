package com.twogathertales.mss.Inventory.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemsPlayer extends AbstractItems {

    Item armour = new Item("armour", 10, new BitmapFont(),
            new Texture("armour.png"), new Rectangle(4, 160,43,66),true,
        30,180);
    Item gloves = new Item("gloves", 10, new BitmapFont(),
            new Texture("gloves.png"), new Rectangle(2, 246, 47,23),true,
            30, 255);
    Item sword = new Item("sword", 10, new BitmapFont(),
            new Texture("sword.png"), new Rectangle(109,170,22, 73),true,
            115, 180);
    Item shield = new Item("shield", 10, new BitmapFont(),
            new Texture("shield.png"), new Rectangle(55,220, 48, 48),true,
            80, 230);
    Item boots = new Item("boots", 10, new BitmapFont(),
            new Texture("boots.png"), new Rectangle(55, 164, 48, 48),true,
            80, 180);

    ArrayList<Item> playerItems = new ArrayList<Item>(Arrays
            .asList(armour, gloves, sword, shield, boots));

    public ArrayList<Item> getItems() { return playerItems; }

    public void setItems(ArrayList<Item> items) {
        this.playerItems = items;
    }

    @Override
    public void dispose() {

    }

}
