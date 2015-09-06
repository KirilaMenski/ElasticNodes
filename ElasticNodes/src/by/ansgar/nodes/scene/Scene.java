package by.ansgar.nodes.scene;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import by.ansgar.nodes.entity.Background;
import by.ansgar.nodes.entity.Cells;
import by.ansgar.nodes.input.KeyInput;
import by.ansgar.nodes.input.MouseInput;

public class Scene extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final String title = "Elastic Nodes";
	public static final int WIDTH = 700;
	public static final int HEIGHT = 600;

	private BufferedImage bufImage;
	private Graphics2D g;
	private Thread thread;
	private boolean startProgramm;

	private Background background;
	private List<Cells> cells = new ArrayList<Cells>();

	public Scene() {
		startProgramm = true;
		background = new Background();
		cells.add(new Cells());

	}

	public void update() {

		for (int i = 0; i < cells.size(); i++) {

			if (MouseInput.MouseX <= (cells.get(i).getX() + Cells.RADIUS)
					&& MouseInput.MouseX >= cells.get(i).getX()
					&& MouseInput.MouseY <= (cells.get(i).getY() + Cells.RADIUS)
					&& MouseInput.MouseY >= cells.get(i).getY()) {

				if (MouseInput.mousePressed) {
					cells.get(i).setX(MouseInput.MouseDX);
					cells.get(i).setY(MouseInput.MouseDY);
					cells.get(i).update();
				}
			}

		}

	}

	public void render() {
		// draw background
		background.draw(g);

		// draw cells
		for (int i = 0; i < cells.size(); i++) {
			cells.get(i).draw(g);
		}
	}

	public void draw() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(bufImage, 0, 0, null);
		g2.dispose();
	}

	public void start() {
		thread = new Thread(this);
		thread.start();
	}

	@SuppressWarnings("static-access")
	public void run() {

		bufImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) bufImage.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		while (startProgramm) {

			update();
			render();
			draw();

			try {
				thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
