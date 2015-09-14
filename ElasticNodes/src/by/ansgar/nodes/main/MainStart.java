package by.ansgar.nodes.main;


import javax.swing.JFrame;

import by.ansgar.nodes.input.KeyInput;
import by.ansgar.nodes.scene.Scene;

public class MainStart {
	
	public static final String TITLE = "Elastic Nodes";

	public static void main(String args[]){
		
		JFrame frame = new JFrame();
		Scene scene = new Scene();
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setSize(Scene.WIDTH, Scene.HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(scene);
		frame.addKeyListener(new KeyInput());
		scene.start();
			
	}

}
