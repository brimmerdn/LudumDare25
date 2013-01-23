package com.davidb.mygdxgame.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.davidb.mygdxgame.MyGdxGame;
import com.davidb.mygdxgame.Model.Ship;

public class World {
	
	MyGdxGame game;
	Ship ship;

	public World(MyGdxGame game){
		this.game = game;
		ship = new Ship(new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2), 1, 1, 0, 5f);
	}
	
	public Ship getShip(){
		return ship;
	}
	
	public void update(){
		ship.update();
	}
	
	public void dispose(){
		
	}
	
}
