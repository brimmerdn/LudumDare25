package com.davidb.mygdxgame.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Ship extends MoveableEntity {

	public Ship(Vector2 position, float width, float height, float rotation, float speed) {
		super(position, width, height, rotation, speed);
	}

	
	public void update() {
		position.add(velocity.tmp().mul(Gdx.graphics.getDeltaTime() * speed));
		if(velocity.x != 0 || velocity.y !=0)
			rotation = velocity.angle() - 90;
		
		bounds.x=position.x;
		bounds.y=position.y;
		
	}

}
