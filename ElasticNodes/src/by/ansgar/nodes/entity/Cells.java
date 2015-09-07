package by.ansgar.nodes.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import by.ansgar.nodes.scene.Scene;

public class Cells {

	private double x;
	private double y;
	private double speed;
	private double dx;
	private double dy;
	private Color color;
	public static final int RADIUS= 50;
	
	public boolean select = false;
	
	public Cells(){
		
	}

	public Cells(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;

	}

	public void update() {
		
		if((x + RADIUS) >= Scene.WIDTH) x = Scene.WIDTH - RADIUS;
		if(x <= 0) x = 0;
		if(y + RADIUS >= Scene.HEIGHT) y = Scene.HEIGHT - RADIUS;
		if(y <= 0) y = 0;
	}

	public void draw(Graphics2D g) {
		g.setColor(color);
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
