package com.davidb.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;
import com.davidb.mygdxgame.Screens.GameScreen;


public class MyGdxGame extends Game {
	
	public static final String VERSION = "0.0.0.02 pre-alpha";
	public static final String LOG = "MYGDXGAME";
	FPSLogger log;
	
	@Override
	public void create() {			
		log = new FPSLogger();
		setScreen(new GameScreen(this));
	}

	@Override
	public void dispose() {

	}

	@Override
	public void render() {		
		super.render();
		log.log();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
