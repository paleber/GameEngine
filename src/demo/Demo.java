package demo;

import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;

import com.google.inject.Guice;
import com.google.inject.Injector;

import basic.IPoint;
import basic.IPolygon;
import basic.imp.BasicModule;

public class Demo {

    private static final int WIDTH = 16;
    private static final int HEIGHT = 12;
    
    
    
    private static final Injector INJECTOR = Guice.createInjector(new BasicModule());
    
    // R�nder erstellen
    private final IPolygon[] boarder = new IPolygon[1];
    
    {
        boarder[0] = INJECTOR.getInstance(IPolygon.class);
        IPoint[] points = new IPoint[4];
        for(int i = 0; i < points.length; i++) {
            points[i] = INJECTOR.getInstance(IPoint.class);
        }
        points[0].initWithXY(0, 0);
        points[1].initWithXY(1, 1);
        points[2].initWithXY(WIDTH - 1, 1);
        points[3].initWithXY(WIDTH, 0);
        boarder[0].initWithPoints(points);

    }

    
    
    
    
    private final JFrame frame = new JFrame() {
        
        {   // Constructor
            setVisible(true);
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        public void paint(Graphics g) {
            g.fillPolygon(convert(boarder[0]));
            g.drawLine(0, 0, 200, 200);
        }

    };
        
  
   
    
    

    
    
    
    
    public static void main(String[] args) {
        new Demo();
    }

    
    private static Polygon convert(IPolygon poly) {
        Polygon p = new Polygon();
        for(int i = 0; i < poly.getNumberElements(); i++) {
            p.addPoint((int)poly.getPoint(i).getX(), (int)poly.getPoint(i).getY());
        }
        return p;

    }
    
}
