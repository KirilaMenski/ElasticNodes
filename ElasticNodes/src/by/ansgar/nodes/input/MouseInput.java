package by.ansgar.nodes.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import by.ansgar.nodes.entity.Cells;
import by.ansgar.nodes.scene.Scene;

public class MouseInput implements MouseListener, MouseMotionListener{

	public static int mouseX;
	public static int mouseY;
	public static int mouseDX;
	public static int mouseDY;
	public static boolean mousePressed = false;
	

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseDX = e.getX();
		mouseDY = e.getY();
//		System.out.println("MouseDX = " + mouseDX + " | MouseDY = " + mouseDY);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
//		mouseX = e.getX();
//		mouseY = e.getY();
//		System.out.println("MouseDX = " + mouseDX + " | MouseDY = " + mouseDY);
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
		mouseX = e.getX();
		mouseY = e.getY();
		mousePressed = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
		
		for(Cells allCells : Scene.cells){
			allCells.select = false;
		}
	}

}
