package com.twogathertales.mss.Missions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.twogathertales.mss.Inventory.Controller.ItemController;
import com.twogathertales.mss.Inventory.Controller.SalesController;

public class QuestsController {

    private boolean wantsHelp;
    private long startTimeMs;
    private long updateTimeMs;
    private boolean isQuestOngoing = false;
    private int questID;
    private int[] questKeys = {Input.Keys.NUM_1,
            Input.Keys.NUM_2,Input.Keys.NUM_3};
    private ItemController itemController;
    private BitmapFont bitmapFont;
    private SalesController salesController;
    private int currentQuest = 0;
    private Texture questionMarkImg;
    private Rectangle questionMark;
    int questionMarkX = 567;
    int questionMarkY = 407;
    final static int WIN_HEIGHT = 480;
    private float timeSinceClicking = 0;

    public void create(ItemController itemController){
        this.itemController = itemController;
        questionMarkImg = new Texture("questionmark.png");
        questionMark = new Rectangle(567, 407, 73, 73);
        salesController = new SalesController();
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans-SemiBold.ttf"));
        FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 14;
        parameter.shadowOffsetX = parameter.shadowOffsetY = 1;
        parameter.borderWidth = 1;
        bitmapFont = generator.generateFont(parameter);
        generator.dispose();
    }

    public void render(Batch batch){
        batch.draw(questionMarkImg, questionMarkX, questionMarkY);
        for(int x=0;x<questKeys.length;x++){
            if(Gdx.input.isKeyPressed(questKeys[x])){
                currentQuest = x;
            }
        }
        if(isQuestOngoing){
            updateTimer();
            drawCurrentQuest(batch);
        } else {
            startQuest(currentQuest);
        }
        clickedItem();
        if(wantsHelp)
            drawHelp(batch);
        drawSales(batch);
    }

    private void clickedItem(){
        timeSinceClicking += Gdx.graphics.getDeltaTime();
        if(timeSinceClicking > .1f) {
            if (Gdx.input.isTouched()) {
                Vector2 touchPos = new Vector2();
                touchPos.set(Gdx.input.getX(), -Gdx.input.getY()+WIN_HEIGHT);
                if (Intersector.intersectSegmentRectangle(
                        touchPos, touchPos, questionMark))
                    wantsHelp = (wantsHelp)?false:true;
            }
            timeSinceClicking = 0;
        }
    }





    private void startQuest(int questID){
        startTimeMs = TimeUtils.millis();
        updateTimeMs = TimeUtils.millis();
        isQuestOngoing = true;
        this.questID = questID;
    }

    private void updateTimer(){
        long currentTime = TimeUtils.millis();

        if(currentTime - updateTimeMs > 1000){
            updateTimeMs = currentTime;
        }

        if(currentTime - startTimeMs > 3000){
            Loots loots = new Loots();
            String[] loot = loots.getLoot(questID,0);

            itemController.addMissionLoot(loot);
            isQuestOngoing = false;
        }
    }

    private void drawSales(Batch batch){
        salesController.randomizeSalesValue();
        bitmapFont.draw(batch,"    "+
                salesController
                        .salesItem[salesController.randomizeSalesItemIndex()]
                +" is \n in high demand!",250,70);
    }

    private void drawHelp(Batch batch){
        bitmapFont.draw(batch,"Press 1, 2, or 3 to select and start a quest.",280,476);
        bitmapFont.draw(batch,"Each quest will award you 1 item\n at random from it's loot pool.",
                280,460);
        bitmapFont.draw(batch,"Clicking on your inventory's items,\n sells them" +
                " for extra points.",280,424);
    }

    private void drawCurrentQuest(Batch batch){
        long timeLeft = updateTimeMs - startTimeMs;
        timeLeft = 3-(timeLeft/1000);
        int timeLeftInt = (int) timeLeft;
        bitmapFont.draw(batch,"You're on a quest",30,400);
        bitmapFont.draw(batch,"Time left: "+timeLeftInt,30,384);
    }

}
