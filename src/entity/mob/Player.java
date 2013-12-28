package entity.mob;

import graphics.Screen;
import graphics.Sprite;
import input.KeyBoard;

public class Player extends Mob {

	private KeyBoard input;

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
		
		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;
		
		if(xa!=0 || ya!=0)
			move(xa,ya);
	}

	public void render(Screen screen) {
		screen.renderPlayer(x - 16, y - 16, Sprite.player);
	}

}
