package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;

import basic.IPolygon;
import basic.IShape;

public class Content {

	private double xTiles = 16;
	private double yTiles = 12;

	// private final List<IShape> shapes = new ArrayList<>();

	private final Map<IShape, Color> shapes = new HashMap<>(); // TODO, andere
																// Map-Art

	private final Container content = new JPanel() {

		private static final long serialVersionUID = 1L;

		double scale;
		double xOffset, yOffset;

		@Override
		public void paint(Graphics g) {
			scale = Math.min((getWidth() - 1) / xTiles, (getHeight() - 1) / yTiles);
			yOffset =  ((getHeight() - yTiles * scale) / 2);
			xOffset =  ((getWidth() - xTiles * scale) / 2);

			g.drawRect((int)xOffset, (int)yOffset, (int) (xTiles * scale), (int) (yTiles * scale));
			g.fillRect((int)xOffset, (int)yOffset, (int) scale, (int) scale);

			for (Entry<IShape, Color> entry : shapes.entrySet()) {
				g.setColor(entry.getValue());
				paintShape(g, entry.getKey());
			}
			
			g.setColor(Color.GRAY);
			for(int i = 1; i < yTiles; i++) {
				g.drawLine((int)xOffset, (int)(i*scale + yOffset), (int)(scale*xTiles + xOffset), (int)(i*scale + yOffset));
			}
			
			for(int i = 1; i < xTiles; i++) {
				g.drawLine((int)(i*scale) + (int)xOffset, (int)yOffset,  (int)(i*scale+xOffset), (int)(scale*yTiles + yOffset));
			}
			

		}

		public void paintShape(Graphics g, IShape shape) {

			if (shape instanceof IPolygon) {
				paintPolygon(g, (IPolygon) shape);
			}

		}

		private void paintPolygon(Graphics g, IPolygon poly) {
			int[] x = new int[poly.getNumberElements()];
			int[] y = new int[poly.getNumberElements()];

			for (int i = 0; i < poly.getNumberElements(); i++) {
				x[i] = (int)(xOffset +  (poly.getPoint(i).getX() * scale) + 0.5);
				y[i] = (int)(yOffset +  (poly.getPoint(i).getY() * scale) + 0.5);
			}

			g.fillPolygon(x, y, poly.getNumberElements());

		}

	};

	public Container getContainer() {
		return content;
	}

	public void init(int xTiles, int yTiles) {
		this.xTiles = xTiles;
		this.yTiles = yTiles;
	}

	public void addShape(IShape shape, Color color) {
		shapes.put(shape, color);
	}

	public void removeShape(IShape shape, Color c) {
		shapes.remove(shape);
	}

}
