package graphics;

import java.util.Random;

public class Sprite {

	public final int SIZE;

	private int x, y;

	protected SpriteSheet sheet;

	private int width, height;

	public int[] pixels;

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles, true);
	public static Sprite voidSprite = new Sprite(16, 0x0000ffff);

	public static Sprite player = new Sprite(32, 0, 1, SpriteSheet.tiles, false);

	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles, true);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles, true);

	// Particles
	public static Sprite particle_normal = new Sprite(3, 0xAAAAAA);

	protected Sprite(SpriteSheet sheet, int width, int height) {
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.sheet = sheet;
	}

	public Sprite(int size, int x, int y, SpriteSheet sheet, boolean lightning) {
		this.SIZE = size;
		this.width = size;
		this.height = size;
		this.pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load(lightning);
	}

	public Sprite(int width, int height, int color) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColor(color);
	}

	public Sprite(int size, int color) {
		this.SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	public Sprite(int[] pixels, int width, int height) {
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	private void setColor(int color) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = color;
		}
	}

	public static int darkenColor(int color, int percent) {
		int amt = (int) Math.round(2.55 * percent);
		int R = ((color >> 16) & 0x00ff) + amt;
		int G = ((color >> 8) & 0x00ff) + amt;
		int B = (color & 0x00ff) + amt;
		// int R = (color >> 16);
		// int G = (color >> 8 & 0x00FF);
		// int B = (color & 0x0000FF);
		if (R > 255)
			R = 255;

		if (R < 0)
			R = 0;

		if (G > 255)
			G = 255;

		if (G < 0)
			G = 0;

		if (B > 255)
			B = 255;

		if (B < 0)
			B = 0;

		return (R << 16) + (G << 8) + B;
		// return (0x1000000 + (R < 255 ? R < 1 ? 0 : R : 255) * 0x10000
		// + (G < 255 ? G < 1 ? 0 : G : 255) * 0x100 + (B < 255 ? B < 1 ? 0
		// : B
		// : 255));
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private void load(boolean lightning) {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				int color = sheet.pixels[x + this.x + (y + this.y) * sheet.SIZE];
				if (lightning)
					color = darkenColor(color, -60);
				pixels[x + y * SIZE] = color;
				// pixels[x + y * SIZE] = sheet.pixels[x + this.x + (y + this.y)
				// * sheet.SIZE];
			}
		}
	}

}
