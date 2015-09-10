package by.ansgar.nodes.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import by.ansgar.nodes.scene.Scene;

public class KeyInput implements KeyListener {

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
		if (key == KeyEvent.VK_R) {
			Scene.cells.get(0).setX(Scene.cells.get(0).getX() - 100);
		}
		if (key == KeyEvent.VK_S) {
			System.out.println("Hello!");
		}

	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

}
