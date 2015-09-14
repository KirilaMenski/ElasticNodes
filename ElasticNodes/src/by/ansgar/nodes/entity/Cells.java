package by.ansgar.nodes.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import by.ansgar.nodes.scene.Scene;

public class Cells {

	private double x, y;
	private int x0, y0;
	private int speed;
	private Color color;
	private Rectangle size = new Rectangle();
	public static final int RADIUS = 50;

	public boolean select = false;

	public Cells() {

	}

	public Cells(int x, int y, int x0, int y0, Color color) {
		this.x = x;
		this.y = y;
		this.x0 = x0;
		this.y0 = y0;
		this.color = color;

		speed = 2;

	}

	public boolean intersect(Cells cells) {
		size.setBounds((int) x, (int) y, RADIUS, RADIUS);
		return size.intersects((int) x, (int) y, RADIUS, RADIUS);
	}

	public void update() {

		if ((x + RADIUS) >= Scene.WIDTH)
			x = Scene.WIDTH - RADIUS;
		if (x <= 0)
			x = 0;
		if (y + RADIUS >= Scene.HEIGHT)
			y = Scene.HEIGHT - RADIUS;
		if (y <= 0)
			y = 0;

		recoveryPosition();
	}

	public void moving(int dx, int dy) {
		x += dx;
		y += dy;
	}

	private void recoveryPosition() {
		if (x > x0) {
			moving(-1, 0);
		}
		if (x < x0) {
			moving(1, 0);
		}
		if (y > y0) {
			moving(0, -1);
		}
		if (y < y0) {
			moving(0, 1);
		}

	}

	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillOval((int) x, (int) y, RADIUS, RADIUS);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
