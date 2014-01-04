package entity.spawner;

import level.Level;
import entity.Entity;

public class Spawner extends Entity {

	public enum Type {
		MOB, PARTICLE
	}

	private Type type;

	public Spawner(int x, int y, Type type, int amount, Level level) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
}