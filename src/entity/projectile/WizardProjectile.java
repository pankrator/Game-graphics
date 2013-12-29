package entity.projectile;

import graphics.Screen;
import graphics.Sprite;

public class WizardProjectile extends Projectile {

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 2;
		damage = 20;
		rateOfFire = 15;
		speed = 4;
		sprite = Sprite.grass;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	@Override
	public void update() {
		move();
	}

	@Override
	protected void move() {
		x += nx;
		y += ny;

		if (distance() > range) {
			remove();
		}
	}

	private double distance() {
		double dist = 0;
		dist = Math.sqrt((xOrigin - x) * (xOrigin - x) + (yOrigin - y)
				* (yOrigin - y));
		return dist;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x, (int) y, this);
	}

}
