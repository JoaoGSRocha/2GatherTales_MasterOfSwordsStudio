package com.twogathertales.mss.Inventory.Model;

import java.util.ArrayList;

public abstract class AbstractItems {

public abstract ArrayList<Item> getItems();

public abstract void setItems(ArrayList<Item> items);

    public abstract void dispose();
}
