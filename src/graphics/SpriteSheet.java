package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;

	public final int SIZE;
	public final int WIDTH, HEIGHT;
	public int[] pixels;

	public static SpriteSheet tiles = new SpriteSheet(
			"/textures/spritesheet.png", 256);

	private Sprite[] sprites;

	public SpriteSheet(SpriteSheet sheet, int x, int y, int width, int height,
			int spriteSize) {
		int xx = x * spriteSize;
		int yy = y * spriteSize;
		int w = width * spriteSize;
		int h = height * spriteSize;
		if (width == height)
			this.SIZE = width;
		else
			this.SIZE = -1;
		this.WIDTH = w;
		this.HEIGHT = h;
		this.pixels = new int[w * h];
		for (int yf = 0; yf < h; yf++) {
			int yp = yy + yf;
			for (int xf = 0; xf < w; xf++) {
				int xp = xx + xf;
				pixels[xf + yf * w] = sheet.pixels[xp + yp * sheet.WIDTH];
			}
		}

		int frame = 0;
		sprites = new Sprite[width * height];
		for (int ya = 0; ya < height; ya++) {
			for (int xa = 0; xa < width; xa++) {
				frame++;
				int[] spritePixels = new int[spriteSize * spriteSize];
				for (int yf = 0; yf < spriteSize; yf++) {
					for (int xf = 0; xf < spriteSize; xf++) {

						spritePixels[xf + yf * spriteSize] = pixels[(xf + xa
								* spriteSize)
								+ (yf + ya * spriteSize) * WIDTH];
					}
				}
				Sprite sprite = new Sprite(spritePixels, spriteSize, spriteSize);
				sprites[frame++] = sprite;

			}
		}

	}

	public SpriteSheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		this.WIDTH = size;
		this.HEIGHT = size;
		this.pixels = new int[SIZE * SIZE];
		load();
	}

	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		SIZE = -1;
		this.WIDTH = width;
		this.HEIGHT = height;
		pixels = new int[width * height];
		load();
	}

	public Sprite[] getSprites() {
		return sprites;
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class
					.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
