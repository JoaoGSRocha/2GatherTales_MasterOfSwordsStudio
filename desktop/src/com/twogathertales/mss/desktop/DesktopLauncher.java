package com.twogathertales.mss.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.twogathertales.mss.MasterOfSwordsStudio;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 640;
		config.height = 480;
		config.resizable = false;
		config.title = "Master of Swords";
		new LwjglApplication(new MasterOfSwordsStudio(), config);
	}
}
