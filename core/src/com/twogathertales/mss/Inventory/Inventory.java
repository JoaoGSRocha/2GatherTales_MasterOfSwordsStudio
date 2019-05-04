package com.twogathertales.mss.Inventory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.twogathertales.mss.Inventory.Controller.ItemController;

public class Inventory {

    private Texture inv_grid;
    public static ItemController itemController;

    public void create () {
        itemController = new ItemController();
        //inv_grid = new Texture("Backg_Grid_Vert.jpg"); //160 265
        inv_grid = new Texture("bg_full.png");
        itemController.create();
    }

    public void render (Batch batch) {
        batch.draw(inv_grid, 0, 0);
        //batch.draw(inv_grid, 480, 0);
        itemController.render(batch);
    }

    public void dispose () {
        itemController.dispose();
    }
}
