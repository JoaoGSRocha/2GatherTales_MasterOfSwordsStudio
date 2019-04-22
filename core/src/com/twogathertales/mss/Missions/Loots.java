package com.twogathertales.mss.Missions;

import java.util.Random;

public class Loots {

    Random random;

    String[][] questRewards = new String[][]{{"helmet", "shield"},{"armour", "boots"},{"sword","gloves"}};

    public Loots() {

    }

    public String[] getLoot(int questNumber, int riskLevel){
        int[] itemsArr = generateItem(riskLevel);
        String[] lootArr = new String[itemsArr.length];
        for(int x=0;x<itemsArr.length;x++){
            lootArr[x] = questRewards[questNumber][itemsArr[x]];
        }
        return lootArr;
    }

    private int[] generateItem(int riskLevel){
        switch(riskLevel){
            case 0:
                return new int[]{random.nextInt(1)};
            case 1:
                int numberOfItems = random.nextInt(1) + 1;
                int[] itemsArr = new int[numberOfItems];
                for(int x=0;x<numberOfItems;x++){
                    itemsArr[x] = random.nextInt(1);
                }
                return itemsArr;
            default:
                return new int[]{};
        }
    }
}
