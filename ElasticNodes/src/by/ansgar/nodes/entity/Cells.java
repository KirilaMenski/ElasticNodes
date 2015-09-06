package by.ansgar.nodes.entity;

import java.awt.Color;
import java.awt.Graphics2D;

public class Cells {

	private double x;
	private double y;
	private double speed;
	private double dx;
	private double dy;
	public static final int RADIUS= 50;

	public Cells() {
		x = 50;
		y = 50;
		
		dx = 0;
		dy = 0;

		speed = 1;

	}

	public void update() {
		x += dx;
		y += dy;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.green);
		g.fillOval((int)x, (int)y, RADIUS, RADIUS);
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

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}
	
	

}
