package com.twogathertales.mss.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class mapManager {
    private String Maps[] = {"0.jpg","1.jpg"};
    private int point=0;
    private Texture[] bgs;

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void create () {
        bgs = new Texture[4];

        for (int i = 0; i < 2; i++){
            String fileName = Maps[i];
            bgs[i] = new Texture(Gdx.files.internal("Maps/"+fileName));
        }
    }

    public void render (Batch batch) {
        batch.draw(bgs[0], 0, 0);
    }
}
