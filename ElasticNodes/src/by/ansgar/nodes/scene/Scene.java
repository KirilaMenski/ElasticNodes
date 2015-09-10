package by.ansgar.nodes.scene;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import by.ansgar.nodes.entity.Background;
import by.ansgar.nodes.entity.Cells;
import by.ansgar.nodes.entity.Nodes;
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
	public static List<Cells> cells = new ArrayList<Cells>();
	public static List<Nodes> nodes = new ArrayList<Nodes>();

	public Scene() {
		startProgramm = true;
		background = new Background();
		cells.add(new Cells(50, 50, Color.GREEN));
		cells.add(new Cells(150, 150, Color.RED));

		addMouseListener(new MouseInput());
		addMouseMotionListener(new MouseInput());

	}

	public void update() {

		for (int i = 0; i < cells.size(); i++) {

			if (MouseInput.mousePressed
					&& MouseInput.mouseX <= (cells.get(i).getX() + Cells.RADIUS)
					&& MouseInput.mouseX >= cells.get(i).getX()
					&& MouseInput.mouseY <= (cells.get(i).getY() + Cells.RADIUS)
					&& MouseInput.mouseY >= cells.get(i).getY()
					&& !cells.get(i).select) {

				cells.get(i).select = true;
			}
			if (cells.get(i).select) {
				cells.get(i).setX(MouseInput.mouseDX);
				cells.get(i).setY(MouseInput.mouseDY);

			}

			for (int j = 0; j < nodes.size(); j++) {
				nodes.get(j).setX1((int) cells.get(0).getX() + 25);
				nodes.get(j).setY1((int) cells.get(0).getY() + 25);
				nodes.get(j).setX2((int) cells.get(1).getX() + 25);
				nodes.get(j).setY2((int) cells.get(1).getY() + 25);
				// System.out.println("d = " + nodes.get(j).d + " "
				// + nodes.get(j).calcDist());
				if (nodes.get(j).calcDist()) {
					nodes.get(j).update();
				}

			}
			// collision
			// if (cells.get(0).intersect(cells.get(1))) {
			// cells.get(i).moving(1, 1);
			// }

			cells.get(i).update();
		}

	}

	public void render() {
		// draw background
		background.draw(g);
		
		//draw nodes
		if (cells.size() > 1) {

			for (int j = 0; j < cells.size(); j++) {
				nodes.add(new Nodes((int) cells.get(0).getX() + 25, (int) cells
						.get(0).getY() + 25, (int) cells.get(1).getX() + 25,
						(int) cells.get(1).getY() + 25, Color.black));
				
				nodes.get(j).draw(g);
			}
		}
		
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
				thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
