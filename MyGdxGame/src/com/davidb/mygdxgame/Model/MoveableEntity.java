package com.davidb.mygdxgame.Model;

import com.badlogic.gdx.math.Vector2;

public abstract class MoveableEntity extends Entity {

	protected Vector2 velocity;
	protected float speed;
	protected float rotation;
	
	public MoveableEntity(Vector2 position, float width, float height, float rotation, float speed){
		super(position, width, height);
		this.speed = speed;
	}
	

	/**
	 * @return the velocity
	 */
	public Vector2 getVelocity() {
		return velocity;
	}

	/**
	 * @param velocity the velocity to set
	 */
	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	/**
	 * @return the rotation
	 */
	public float getRotation() {
		return rotation;
	}

	/**
	 * @param rotation the rotation to set
	 */
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	
	public abstract void update();
	
	
}
