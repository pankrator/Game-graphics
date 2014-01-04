package graphics;

public class Sprite {

	public final int SIZE;

	private int x, y;

	private SpriteSheet sheet;

	private int width, height;

	public int[] pixels;

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x0000ffff);

	public static Sprite player = new Sprite(32, 0, 1, SpriteSheet.tiles);

	public static Sprite player_forward_1 = new Sprite(32, 0, 2,
			SpriteSheet.tiles);
	public static Sprite player_forward_2 = new Sprite(32, 0, 2,
			SpriteSheet.tiles);

	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);

	// Particles
	public static Sprite particle_normal = new Sprite(3, 0xAAAAAA);

	public Sprite(int size, SpriteSheet sheet) {

	}

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		this.width = size;
		this.height = size;
		this.pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
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

	private void setColor(int color) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = color;
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private void load() {
		for (int y = 0; y < SIZE; y++)
			for (int x = 0; x < SIZE; x++)
				pixels[x + y * SIZE] = sheet.pixels[x + this.x + (y + this.y)
						* sheet.SIZE];
	}
}
