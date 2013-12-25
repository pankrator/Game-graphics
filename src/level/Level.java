package level;

import graphics.Screen;
import level.tile.Tile;

public class Level {

	protected int width, height;

	protected int[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		this.tiles = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}

	public void update() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.getWidth()) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.getHeight()) >> 4;
	}

	private void loadLevel(String path) {

	}

	protected void generateLevel() {

	}

	public Tile getTitle(int x, int y) {
		if (tiles[x + y * width] == 0)
			return Tile.grass;
		
		return Tile.voidTile;
	}
}