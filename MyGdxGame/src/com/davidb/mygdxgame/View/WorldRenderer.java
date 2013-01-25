package com.davidb.mygdxgame.View;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.davidb.mygdxgame.Model.Bullet;
import com.davidb.mygdxgame.Model.Follower;
import com.davidb.mygdxgame.Model.Ship;

public class WorldRenderer {

	World world;
	SpriteBatch spriteBatch;
	Ship ship;
	OrthographicCamera camera;
	Texture shipTexture, followerTexture, bulletTexture;
	float viewportWidth, viewportHeight;
	ShapeRenderer sr;
	Follower follower;
	Array<Bullet> bullets;
	Iterator<Bullet> bulletIterator;
	
	
	
	public WorldRenderer(World world){
		this.world = world;
		
		viewportWidth = (Gdx.graphics.getWidth() / 60);
		viewportHeight = (Gdx.graphics.getHeight() / 60);
		

		camera = new OrthographicCamera();
		camera.setToOrtho(false, viewportWidth, viewportHeight);
		camera.update();
		
		spriteBatch = new SpriteBatch();
		spriteBatch.setProjectionMatrix(camera.combined);
		
		
		shipTexture = new Texture("data/ship.png");
		shipTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		followerTexture = new Texture("data/follower.png");
		followerTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		bulletTexture = new Texture("data/bullet.png");
		bulletTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		sr = new ShapeRenderer();
		sr.setColor(Color.YELLOW);
		
	}
	
	public void render(){
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		ship = world.getShip();
		follower = world.getFollower();
		bullets = world.getBullets();
		
		camera.position.set(ship.getPosition().x, ship.getPosition().y, 0);
		camera.update();
		
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		spriteBatch.draw(shipTexture, ship.getPosition().x, ship.getPosition().y, ship.getWidth()/2, ship.getHeight()/2, ship.getWidth(),
							ship.getHeight(), 1, 1, ship.getRotation(), 0, 0, shipTexture.getWidth(), shipTexture.getHeight(), false, false);
		spriteBatch.draw(followerTexture, follower.getPosition().x, follower.getPosition().y, follower.getWidth()/2, follower.getHeight()/2, 
							follower.getWidth(), follower.getHeight(), 1, 1, follower.getRotation(), 0, 0, followerTexture.getWidth(), 
							followerTexture.getHeight(), false, false);
		
		bulletIterator = bullets.iterator();
		while(bulletIterator.hasNext()){
			Bullet bullet = bulletIterator.next();
			spriteBatch.draw(bulletTexture, bullet.getPosition().x, bullet.getPosition().y, bullet.getWidth()/2, bullet.getHeight()/2, bullet.getWidth(),
					bullet.getHeight(), 1, 1, bullet.getRotation(), 0, 0, bulletTexture.getWidth(), bulletTexture.getHeight(), false, false);
		}
		spriteBatch.end();
		
		displayBoundingBox(ship.getBounds(), Color.YELLOW);
		displayBoundingBox(follower.getBounds(),Color.CYAN);
		
		
	}
	
	public void displayBoundingBox(Rectangle rectangle, Color color){
		//Code for showing bounding boxes around object
				sr.setProjectionMatrix(camera.combined);
				sr.begin(ShapeType.Rectangle);
				sr.setColor(color);
				sr.rect(rectangle.x, rectangle.y, rectangle.getWidth(), rectangle.getHeight());
				sr.end();
	}
	
	public OrthographicCamera getCamera(){
		return camera;
	}
	
	public void dispose(){
		spriteBatch.dispose();
		shipTexture.dispose();
		sr.dispose();
	}
}
