package com.davidb.mygdxgame.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Follower extends MoveableEntity {

	float ROTATION_SPEED = 50;
	
	public Follower(Vector2 position, float width, float height,
			float rotation, float speed) {
		super(position, width, height, rotation, speed);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Ship ship){
		position.lerp(ship.getPosition(), Gdx.graphics.getDeltaTime());
		
		rotation += Gdx.graphics.getDeltaTime() * ROTATION_SPEED;
		
	//	rotation = (float) Math.tan((ship.getPosition().y-position.y/ship.getPosition().x-position.x));
		
		if(rotation > 360)
			rotation -= 360;
		
		super.update(ship);
	}

}
