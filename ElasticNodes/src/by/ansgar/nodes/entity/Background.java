package by.ansgar.nodes.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import by.ansgar.nodes.scene.Scene;

public class Background {

	
	
	public Background(){
		
	}
	
	public void draw(Graphics2D g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Scene.WIDTH, Scene.HEIGHT);
	}
	
}
