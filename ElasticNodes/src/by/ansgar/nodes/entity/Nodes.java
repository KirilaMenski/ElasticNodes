package by.ansgar.nodes.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import by.ansgar.nodes.scene.Scene;

public class Nodes {

	private int x1;
	private int x2;
	private int y1;
	private int y2;
	public static int d;
	public final int TENSION_MIN = 50;
	public final int TENSION_NOR = 150;
	public final int TENSION_MAX = 250;
	private Color color;

	public Nodes() {

	}

	public Nodes(int x1, int y1, int x2, int y2, Color color) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}

	public boolean calcDist() {
		d = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

		if (d >= TENSION_MAX) {
			return true;
		} else
			return false;
	}

	public void tention() {

		if (x1 < x2 && d != TENSION_MIN) {
			Scene.cells.get(0).moving(1, 0);
		}
		if (x1 > x2 && d != TENSION_MIN) {
			Scene.cells.get(0).moving(-1, 0);
		}
		if (y1 < y2 && d != TENSION_MIN) {
			Scene.cells.get(0).moving(0, 1);
		}
		if (y1 > y2 && d != TENSION_MIN) {
			Scene.cells.get(0).moving(0, -1);
		}
	}

	public void update() {
	}

	public void draw(Graphics2D g) {
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
