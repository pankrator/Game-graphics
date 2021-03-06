package entity.mob;

import entity.Entity;
import entity.projectile.Projectile;
import entity.projectile.WizardProjectile;
import graphics.Screen;
import graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean move = false;

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}

		if (xa > 0)
			dir = 1;
		if (xa < 0)
			dir = 3;
		if (ya > 0)
			dir = 2;
		if (ya < 0)
			dir = 0;

		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	public void update() {

	}

	protected void shoot(int x, int y, double dir) {
		// dir *= 180 / Math.PI;
		Projectile p = new WizardProjectile(x, y, dir);
		level.add(p);
	}

	public void render(Screen screen) {

	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) { /* Corner code goes here */
			int xt = ((x + xa) + c % 2 * 12 - 8) / 16;
			int yt = ((y + ya) + c / 2 * 12 + 3) / 16;
			if (level.getTitle(xt, yt).isSolid())
				solid = true;
		}
		return solid;
	}

}
