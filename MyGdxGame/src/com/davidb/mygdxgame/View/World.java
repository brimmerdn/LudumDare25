package com.davidb.mygdxgame.View;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.davidb.mygdxgame.MyGdxGame;
import com.davidb.mygdxgame.Model.Bullet;
import com.davidb.mygdxgame.Model.Follower;
import com.davidb.mygdxgame.Model.Ship;

public class World {
	
	MyGdxGame game;
	Ship ship;
	Follower follower;
	Array<Bullet> bullets = new Array<Bullet>();
	WorldRenderer wr;
	Iterator<Bullet> bulletIterator;

	public World(MyGdxGame game){
		this.game = game;
		ship = new Ship(new Vector2(5,5), 1, 1, 0, 5f);
		follower = new Follower(new Vector2(10,10),1,1,0,5f);
		Gdx.input.setInputProcessor(new InputHandler(this));
	}
	
	public Ship getShip(){
		return ship;
	}
	
	public Follower getFollower(){
		return follower;
	}
	
	public void update(){
		ship.update();
		follower.update(ship);
		
		bulletIterator = bullets.iterator();
		
		while(bulletIterator.hasNext()){
			Bullet bullet = bulletIterator.next();
			bullet.update(ship);
		}
		
		if(ship.getBounds().overlaps(follower.getBounds())){
			Gdx.app.log(MyGdxGame.LOG, "SHIP HIT!!!!");
		}
	}
	
	public void addBullet(Bullet b){
		bullets.add(b);
	}
	public Array<Bullet> getBullets(){
		return bullets;
	}
	public void setRenderer(WorldRenderer wr){
		this.wr = wr;
	}
	
	public WorldRenderer getRenderer(){
		return wr;
	}
	
	public void dispose(){
		
	}
	
}
