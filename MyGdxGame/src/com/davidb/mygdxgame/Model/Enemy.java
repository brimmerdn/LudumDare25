package com.davidb.mygdxgame.Model;

import com.badlogic.gdx.math.Vector2;

public abstract class Enemy extends MoveableEntity {

	public Enemy(Vector2 position, float width, float height, float speed, float rotation) {
		super(position, width, height, speed, rotation);
	}

	public abstract void advance(float delta, Ship ship);

}
