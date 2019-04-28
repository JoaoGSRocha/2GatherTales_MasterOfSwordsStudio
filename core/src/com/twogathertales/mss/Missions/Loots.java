package com.twogathertales.mss.Missions;

import java.util.Random;

public class Loots {

    Random random = new Random();

    String[][] questRewards = new String[][]{{"sword", "shield"},{"armour", "boots"},{"sword","gloves"}};

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
                int rand = random.nextInt(2);
                System.out.println(rand);
                return new int[]{rand};
            case 1:
                int numberOfItems = random.nextInt(2) + 1;
                int[] itemsArr = new int[numberOfItems];
                for(int x=0;x<numberOfItems;x++){
                    itemsArr[x] = random.nextInt(2);
                }
                return itemsArr;
            default:
                return new int[]{};
        }
    }
}
