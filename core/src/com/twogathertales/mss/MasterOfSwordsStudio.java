package com.twogathertales.mss;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.twogathertales.mss.Inventory.Inventory;
import com.twogathertales.mss.Components.MapManager;
import com.twogathertales.mss.Missions.QuestsController;

public class MasterOfSwordsStudio extends ApplicationAdapter {
	SpriteBatch batch;
	Inventory inventory;
	MapManager mapManager;
	QuestsController questsController;
	@Override
	public void create () {
		inventory = new Inventory();
		batch = new SpriteBatch();
		mapManager = new MapManager();
		mapManager.create();
		inventory.create();
		questsController = new QuestsController();
		questsController.create(inventory.itemController);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		mapManager.render(batch);
		inventory.render(batch);
		questsController.render();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		inventory.dispose();
	}
}
