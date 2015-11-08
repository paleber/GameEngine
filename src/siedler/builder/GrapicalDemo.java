package siedler.builder;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

import com.google.inject.Guice;
import com.google.inject.Injector;

import basic.IPolygon;
import basic.imp.BasicModule;
import demo.Content;

public class GrapicalDemo {


	private static final Injector INJECTOR = Guice.createInjector(new BasicModule());
	
	
	
	public GrapicalDemo() {
	
		Content content = new Content();
		content.init(10, 10);
		
		
			
		StandardBoardBuilder b = new StandardBoardBuilder();
		b.build();
		
		System.out.println(b.getPolys().size());
		
		Random r = new Random();
		for(IPolygon poly: b.getPolys()) {
			content.addShape(poly, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		}
			
		
		JFrame f = new JFrame("Test-Fenster");
		f.setVisible(true);
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(content.getContainer());
		
		
	}
	
	public static void main(String[] args) {
		new GrapicalDemo();
	}
	
	
	
	
	
	
	
}
