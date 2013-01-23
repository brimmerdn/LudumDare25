package com.davidb.mygdxgame.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.davidb.mygdxgame.Model.Ship;

public class WorldRenderer {

	World world;
	SpriteBatch spriteBatch;
	Ship ship;
	Camera camera;
	Texture shipTexture;
	
	
	public WorldRenderer(World world){
		this.world = world;
		spriteBatch = new SpriteBatch();
		camera = new OrthographicCamera();
		shipTexture = new Texture("data/ship.png");
		
	}
	
	public void render(){
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		ship = world.getShip();
		spriteBatch.begin();
		spriteBatch.draw(shipTexture, ship.getPosition().x, ship.getPosition().y);
		spriteBatch.end();
	}
	
	public void dispose(){
		spriteBatch.dispose();
		shipTexture.dispose();
	}
}
