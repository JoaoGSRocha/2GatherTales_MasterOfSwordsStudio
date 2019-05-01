package com.twogathertales.mss.Missions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;
import com.twogathertales.mss.Inventory.Controller.ItemController;

public class QuestsController {

    private long startTimeMs;
    private long updateTimeMs;
    private boolean isQuestOngoing = false;
    private int questID;
    private int[] questKeys = {Input.Keys.NUM_1,Input.Keys.NUM_2,Input.Keys.NUM_3};
    private ItemController itemController;

    public void create(ItemController itemController){
        this.itemController = itemController;
    }

    public void render(){
        if(isQuestOngoing){
            updateTimer();
        } else {
            for(int x=0;x<questKeys.length;x++){
                if(Gdx.input.isKeyPressed(questKeys[x])){
                    startQuest(x);
                }
            }
        }
    }

    private void startQuest(int questID){
        startTimeMs = TimeUtils.millis();
        updateTimeMs = TimeUtils.millis();
        isQuestOngoing = true;
        this.questID = questID;

        System.out.println("Quest " + questID + " has started" + TimeUtils.millis());

    }

    private void updateTimer(){
        long currentTime = TimeUtils.millis();

        if(currentTime - updateTimeMs > 1000){
            System.out.println("A second has passed " + currentTime);
            updateTimeMs = currentTime;
        }

        if(currentTime - startTimeMs > 5000){
            System.out.println("Quest finished " + currentTime);
            Loots loots = new Loots();
            String[] loot = loots.getLoot(questID,0);

            itemController.addMissionLoot(loot);
            isQuestOngoing = false;
        }
    }

}
