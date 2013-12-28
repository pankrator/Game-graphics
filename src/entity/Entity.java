package entity;

import graphics.Screen;

import java.util.Random;

import level.Level;

public abstract class Entity {

	protected int x, y;
	private boolean removed = false;
	protected Level level;
	protected static final Random random = new Random();
	
	public void update() {
	}
	
	public void render(Screen screen) {
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
