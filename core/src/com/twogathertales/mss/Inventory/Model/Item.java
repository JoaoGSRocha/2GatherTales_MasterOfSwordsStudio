package com.twogathertales.mss.Inventory.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;

public class Item {
    private  String name = "Item";
    private int quantity = 0;
    private BitmapFont font = new BitmapFont();
    private Texture img;
    private Rectangle rectangle;
    private boolean isPlayersItem = true;
    private int lblCoord_X = 0;
    private int lblCoord_Y = 0;

    public Item(String name, int quantity, BitmapFont font, Texture img,
                Rectangle collider, boolean isPlayersItem, int lblCoord_X,
                int lblCoord_Y) {
        this.name = name;
        this.quantity = quantity;
        this.font = font;
        this.img = img;
        this.rectangle = collider;
        this.isPlayersItem = isPlayersItem;
        this.lblCoord_X = lblCoord_X;
        this.lblCoord_Y = lblCoord_Y;
    }

    public int getLblCoord_X() { return lblCoord_X; }

    public void setLblCoord_X(int lblCoord_X) { this.lblCoord_X = lblCoord_X; }

    public int getLblCoord_Y() { return lblCoord_Y; }

    public void setLblCoord_Y(int lblCoord_Y) { this.lblCoord_Y = lblCoord_Y; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public BitmapFont getFont() { return font; }

    public void setFont(BitmapFont font) { this.font = font; }

    public Texture getImg() { return img; }

    public void setImg(Texture img) { this.img = img; }

    public Rectangle getRectangle() { return rectangle; }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public boolean isPlayersItem() { return isPlayersItem; }

    public void setPlayersItem(boolean playersItem) {
        isPlayersItem = playersItem;
    }
}
