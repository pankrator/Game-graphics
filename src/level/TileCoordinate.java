package level;

public class TileCoordinate {

	private int x, y;

	private final int TILE_SIZE = 16;

	public TileCoordinate(int x, int y) {
		this.x = x * TILE_SIZE;
		this.y = y * TILE_SIZE;
	}

	public int x() {
		return this.x;
	}

	public int y() {
		return this.y;
	}

	public int[] xy() {
		return new int[] { this.x, this.y };
	}

}
