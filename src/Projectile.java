import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	int height;
	int width;
	int x;
	int y;
	int speed = 10;

	public Projectile(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}

	public void update() {
		y = y - speed;
		if (y < 0) {
			isAlive = false;

		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		System.out.println("H");
	}

}
