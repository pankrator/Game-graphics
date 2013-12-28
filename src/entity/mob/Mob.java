package entity.mob;

import entity.Entity;
import graphics.Screen;
import graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean move = false;

	public void move(int xa, int ya) {
		if (xa > 0)
			dir = 1;
		if (xa < 0)
			dir = 3;
		if (ya > 0)
			dir = 2;
		if (ya < 0)
			dir = 0;

		if (!collison()) {
			x += xa;
			y += ya;
		}
	}

	public void update() {

	}

	public void render(Screen screen) {

	}

	public boolean collison() {
		return false;
	}

}
