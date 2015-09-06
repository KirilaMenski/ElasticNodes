package by.ansgar.nodes.main;

import java.awt.Dimension;

import javax.swing.JFrame;

import by.ansgar.nodes.input.KeyInput;
import by.ansgar.nodes.input.MouseInput;
import by.ansgar.nodes.scene.Scene;

public class MainStart {
	
	
	
	public static void main(String args[]){
		
		JFrame frame = new JFrame();
		Scene scene = new Scene();
		frame.setTitle(Scene.title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setSize(Scene.WIDTH, Scene.HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(scene);
		frame.addKeyListener(new KeyInput());
		frame.addMouseListener(new MouseInput());
		frame.addMouseMotionListener(new MouseInput());
		scene.start();
		
		
	}

}
