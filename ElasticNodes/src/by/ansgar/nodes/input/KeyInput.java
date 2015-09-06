package by.ansgar.nodes.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}
		if(key == KeyEvent.VK_S){
			System.out.println("Hello!");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
