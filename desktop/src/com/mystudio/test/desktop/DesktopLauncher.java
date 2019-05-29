package com.mystudio.test.desktop;

import org.mini2Dx.desktop.DesktopMini2DxConfig;

import com.badlogic.gdx.backends.lwjgl.DesktopMini2DxGame;

import com.mystudio.test.TestGame;



public class DesktopLauncher {
	public static void main (String[] arg) {
		DesktopMini2DxConfig config = new DesktopMini2DxConfig(TestGame.GAME_IDENTIFIER);
		config.vSyncEnabled = true;
		config.width = 64*16;
		config.height = 36*16;
		new DesktopMini2DxGame(new TestGame(), config);
	}
}
