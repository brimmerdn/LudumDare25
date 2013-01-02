package com.davidb.mygdxgame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.davidb.mygdxgame.MyGdxGame;

public class MainMenu implements Screen{
	
	MyGdxGame game;
	Stage stage;
	BitmapFont black;
	BitmapFont white;
	TextureAtlas atlas;
	Skin skin;
	SpriteBatch spriteBatch;
	TextButton textButton;
	
	public MainMenu(MyGdxGame game){
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		
		spriteBatch.begin();
		stage.draw();
		white.draw(spriteBatch, "MyGdxGame", Gdx.graphics.getWidth()/2 - 15, Gdx.graphics.getHeight()/2 + 100);
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
		if(stage == null)
			stage = new Stage(width, height, true);
		stage.clear();
		
		Gdx.input.setInputProcessor(stage);
		
		TextButtonStyle style = new TextButtonStyle();
		style.up = skin.getDrawable("buttonnormal");
		style.down = skin.getDrawable("buttonpressed");
		style.downFontColor = Color.BLUE;
		style.font = black;
		
		textButton = new TextButton("Start!", style);
		textButton.setWidth(400);
		textButton.setHeight(100);
		textButton.setX(Gdx.graphics.getWidth() / 2 - (textButton.getWidth() / 2) );
		textButton.setY(Gdx.graphics.getHeight() / 2 - (textButton.getHeight() / 2) );
		
		textButton.addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
				System.out.println("down");
				return true;
			}
			
			public void touchUp(InputEvent event, float x, float y, int pointer, int button){
				System.out.println("up");
				game.setScreen(new Game(game));
				
			}
		});
		
		stage.addActor(textButton);
	}

	@Override
	public void show() {
		spriteBatch = new SpriteBatch();
		atlas = new TextureAtlas("data/button.pack");
		skin = new Skin();
		skin.addRegions(atlas);
		
		white = new BitmapFont(Gdx.files.internal("data/whitefont.fnt"), false);
		black = new BitmapFont(Gdx.files.internal("data/blackfont.fnt"), false);
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
		skin.dispose();
		atlas.dispose();
		white.dispose();
		black.dispose();
		stage.dispose();
	}

}
