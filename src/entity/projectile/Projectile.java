package entity.projectile;

import java.util.Random;

import entity.Entity;
import game.Game;
import graphics.Sprite;

public abstract class Projectile extends Entity {

	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x, y;
	protected double nx, ny;
	protected double distance;
	protected double speed, rateOfFire, range, damage;

	protected final Random rand = new Random();

	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		this.x = x;
		this.y = y;
		angle = dir;

	}

	protected void move() {

	}

	public Sprite getSprite() {
		return sprite;
	}

}
