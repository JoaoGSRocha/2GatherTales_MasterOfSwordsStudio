package com.twogathertales.mss.Missions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.TimeUtils;
import com.twogathertales.mss.Inventory.Controller.ItemController;

public class QuestsController {

    private long startTimeMs;
    private long updateTimeMs;
    private boolean isQuestOngoing = false;
    private int questID;
    private int[] questKeys = {Input.Keys.NUM_1,
            Input.Keys.NUM_2,Input.Keys.NUM_3};
    private ItemController itemController;
    private BitmapFont bitmapFont;

    public void create(ItemController itemController){
        this.itemController = itemController;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans-SemiBold.ttf"));
        FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 14;
        parameter.shadowOffsetX = parameter.shadowOffsetY = 1;
        parameter.borderWidth = 1;
        bitmapFont = generator.generateFont(parameter);
        generator.dispose();
    }

    public void render(Batch batch){
        if(isQuestOngoing){
            updateTimer();
            drawCurrentQuest(batch);
        } else {
            drawHelp(batch);
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

    private void drawHelp(Batch batch){
        bitmapFont.draw(batch,"You're currently not questing.",30,400);
        bitmapFont.draw(batch,"Press 1, 2, or 3 to select and start a quest.",30,384);
        bitmapFont.draw(batch,"Each quest will award you 1 item at random from it's loot pool.",30,368);
    }

    private void drawCurrentQuest(Batch batch){
        long timeLeft = updateTimeMs - startTimeMs;
        timeLeft = 5-(timeLeft/1000);
        int timeLeftInt = (int) timeLeft;
        bitmapFont.draw(batch,"You're on a quest",30,400);
        bitmapFont.draw(batch,"Time left: "+timeLeftInt,30,384);
    }

}
