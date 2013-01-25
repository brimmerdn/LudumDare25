package com.davidb.mygdxgame.Screens;

import com.badlogic.gdx.Screen;
import com.davidb.mygdxgame.MyGdxGame;
import com.davidb.mygdxgame.View.World;
import com.davidb.mygdxgame.View.WorldRenderer;

public class GameScreen implements Screen {
	
	MyGdxGame game;
	World world;
	WorldRenderer worldRenderer;

	public GameScreen(MyGdxGame game){
		this.game = game;
		world = new World(game);
		worldRenderer = new WorldRenderer(world);
	}
	
	@Override
	public void render(float delta) {
		world.update();
		worldRenderer.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		world.dispose();
	}

}
