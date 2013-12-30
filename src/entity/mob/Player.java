package entity.mob;

import entity.projectile.Projectile;
import game.Game;
import graphics.Screen;
import graphics.Sprite;
import input.KeyBoard;
import input.Mouse;

public class Player extends Mob {

	private KeyBoard input;
	private int anim = 0;
	private boolean walking = false;

	public Player(KeyBoard input) {
		this.input = input;
		sprite = Sprite.player;
	}

	public Player(int x, int y, KeyBoard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		clear();
		updateShooting();
	}

	private void clear() {
		for (int i = 0; i < level.getProjectiles().size(); i++) {
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved())
				level.getProjectiles().remove(i);
		}
	}

	private void updateShooting() {
		if (Mouse.getButton() == 1) {
			double dx = Mouse.getX() - (Game.getWindowWidth()) / 2;
			double dy = Mouse.getY() - (Game.getWindowHeight()) / 2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
		}
	}

	public void render(Screen screen) {
		// If anim is odd number use some of the sprites and if anim is even use
		// the others
		screen.renderPlayer(x - 16, y - 16, sprite, 0);
	}

}
