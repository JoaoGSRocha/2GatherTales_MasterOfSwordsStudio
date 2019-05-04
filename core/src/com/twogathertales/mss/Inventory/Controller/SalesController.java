package com.twogathertales.mss.Inventory.Controller;

import com.badlogic.gdx.Gdx;

import java.util.Random;

public class SalesController {
    public static String[] salesItem = new String[]{"sword", "shield","armour",
            "boots","sword","gloves"};

    public static int currentItemIndex = 0;
    public static int currentSalesValue = 100;

    private Random random = new Random();
    private float timeSinceClicking;

    public int randomizeSalesItemIndex(){
        timeSinceClicking += Gdx.graphics.getDeltaTime();
        if(timeSinceClicking > 10f) {
            currentItemIndex = random.nextInt(7);
            timeSinceClicking = 0;
            currentSalesValue = randomizeSalesValue();
            return random.nextInt(6);
        }
        return currentItemIndex;
    }

    public int randomizeSalesValue(){
        return currentSalesValue = 100 *  (1+random.nextInt(5));
    }


}
