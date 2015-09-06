package by.ansgar.nodes.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener{

	public static int MouseX;
	public static int MouseY;
	public static int MouseDX;
	public static int MouseDY;
	public static boolean mousePressed;
	

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		MouseDX = e.getX();
		MouseDY = e.getY();
		System.out.println("MouseDX = " + MouseDX + " | MouseDY = " + MouseDY);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		MouseX = e.getX();
		MouseY = e.getY();
		mousePressed = true;
		
		System.out.println(MouseX +"||" + MouseY);
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		mousePressed = true;
		
	}

}
