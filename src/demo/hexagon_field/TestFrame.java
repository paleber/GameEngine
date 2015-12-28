package demo.hexagon_field;

import java.awt.Color;

import javax.swing.JFrame;

import com.google.inject.Guice;
import com.google.inject.Injector;

import basic.IPoint;
import basic.IPolygon;
import basic.IVector;
import geo.imp.imp1.BasicModule;

public class TestFrame {


	private static final Injector INJECTOR = Guice.createInjector(new BasicModule());
	
	
	
	public TestFrame() {
	
		Content content = new Content();
		
		IPoint mid = INJECTOR.getInstance(IPoint.class);
		mid.initWithXY(8, 6);
		
		IVector v = INJECTOR.getInstance(IVector.class);

		v.initWithAngleAndLength(0, 0.95 * (1 / Math.cos(Math.PI / 6)));
		
		IPoint[] p = new IPoint[6]; 
		for(int i = 0; i < p.length; i++) {
			p[i] = INJECTOR.getInstance(IPoint.class);
			p[i].initByCopying(mid);
			p[i].move(v);

			v.rotate( (2*Math.PI) / p.length);
		}

		IPolygon poly = INJECTOR.getInstance(IPolygon.class);
		poly.initWithPoints(p);
			
		content.addShape(poly, Color.RED);
		
		// 1. Ring
		v.initWithXY(2, 0);
		v.rotate(Math.PI / 6);
		
		IPolygon[] polys1 = new IPolygon[6];
		for(int i = 0; i < polys1.length; i++) {
			polys1[i] = INJECTOR.getInstance(IPolygon.class);
			polys1[i].initByCopying(poly);
			polys1[i].move(v);
			content.addShape(polys1[i], Color.CYAN);
			v.rotate(Math.PI / 3);
		}
		
		
		
		
		JFrame f = new JFrame("Test-Fenster");
		f.setVisible(true);
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(content.getContainer());
		
		
	}
	
	public static void main(String[] args) {
		new TestFrame();
	}
	
	
	
	
	
	
	
}
