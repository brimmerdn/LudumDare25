package com.davidb.mygdxgame;

import com.badlogic.gdx.Game;
import com.davidb.mygdxgame.Screens.SplashScreen;


public class MyGdxGame extends Game {
	
	public static final String VERSION = "0.0.0.02 pre-alpha";
	public static final String LOG = "MYGDXGAME";
	
	@Override
	public void create() {			
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {

	}

	@Override
	public void render() {		
		super.render();
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
