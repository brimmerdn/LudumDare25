package com.davidb.mygdxgame.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends MoveableEntity {

	public Bullet(Vector2 position, Vector2 velocity, float width, float height, float rotation, float speed) {
		super(position, width, height, rotation, speed);
		this.velocity = velocity;
	}
	
	@Override
	public void update(Ship ship){
		position.add(velocity.tmp().mul(Gdx.graphics.getDeltaTime() * speed));
		rotation = velocity.angle() - 90;
		super.update(ship);
	}

}
