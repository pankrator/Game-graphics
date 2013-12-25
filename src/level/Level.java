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
		screen.setOffSet(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.getWidth()) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.getHeight()) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTitle(x, y).render(x << 4, y << 4, screen);
			}
		}
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
