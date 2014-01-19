package level.tile;

import graphics.Screen;
import graphics.Sprite;

public class Torch extends Tile {

	public Torch(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTorchTile(x << 4, y << 4, this);
	}

}
