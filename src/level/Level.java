package level;

import graphics.Screen;

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
		
	}

	private void loadLevel(String path) {

	}

	protected void generateLevel() {

	}
}
