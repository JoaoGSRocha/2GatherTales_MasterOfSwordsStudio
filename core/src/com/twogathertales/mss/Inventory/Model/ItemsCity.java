package com.twogathertales.mss.Inventory.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemsCity  extends  AbstractItems {

    Item armour = new Item("armour", 10, new BitmapFont(),
            new Texture("armour.png"), new Rectangle(484, 163,43,66),true,
            510, 180);
    Item gloves = new Item("gloves", 10, new BitmapFont(),
            new Texture("gloves.png"), new Rectangle(482, 240, 47,23),true,
            510, 255);
    Item sword = new Item("sword", 10, new BitmapFont(),
            new Texture("sword.png"), new Rectangle(589,160,22, 73),true,
            595, 180);
    Item shield = new Item("shield", 10, new BitmapFont(),
            new Texture("shield.png"), new Rectangle(535,215, 48, 48),true,
            560, 230);
    Item boots = new Item("boots", 10, new BitmapFont(),
            new Texture("boots.png"), new Rectangle(535, 160, 48, 48),true,
            560, 180);

    ArrayList<Item> cityItems = new ArrayList<Item>(Arrays
            .asList(armour, gloves, sword, shield, boots));

    @Override
    public ArrayList<Item> getItems() { return cityItems; }

    @Override
    public void setItems(ArrayList<Item> items) { this.cityItems = items; }

    @Override
    public void dispose() {

    }
}
