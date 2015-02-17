package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import sprite.Ball;
import sprite.IBall;
import time.source.SystemTimeSourceModule;
import time.timer.ITimer;
import time.timer.ITrigger;
import time.timer.TimerModule;
import time.tpf.ITpfCounter;
import time.tpf.TpfCounterModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

import frame.FrameModule;
import frame.IFrame;
import geo.IPoint;
import geo.imp.GeoModule;

public class Main implements ITrigger {

    private static final Injector INJECTOR = Guice.createInjector(
            new FrameModule(), new TimerModule(), new GeoModule(),
            new TpfCounterModule(), new SystemTimeSourceModule());

    private final ITimer logicTimer = INJECTOR.getInstance(ITimer.class);
    private final ITpfCounter tpfCounter = INJECTOR
            .getInstance(ITpfCounter.class);

    private final List<IBall> balls = new LinkedList<>();

    private final JPanel content = new JPanel() {

        private static final long serialVersionUID = 1L;

        public void paint(Graphics graphics) {

            Graphics2D g = (Graphics2D) graphics;

            g.addRenderingHints(new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON));

            g.addRenderingHints(new RenderingHints(
                    RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR));

            for (IBall b : balls) {

                IPoint mid = b.getCircle().getMid();
                double r = b.getCircle().getRadius();

                g.fillOval((int) (mid.getX() - r), (int) (mid.getY() - r),
                        (int) (2 * r), (int) (2 * r));
            }

        };
    };

    public Main() {

        IFrame frame = INJECTOR.getInstance(IFrame.class);
        frame.setTitle("Test-Frame");
        frame.setContentPane(content);

        tpfCounter.init();

        IBall b = new Ball();
        IPoint p = INJECTOR.getInstance(IPoint.class);
        p.set(100, 100);
        b.init(p, 45, 20, tpfCounter);
        balls.add(b);

        logicTimer.init(this, 10);
        logicTimer.start();

    }

    public static void main(String[] args) {

        new Main();

    }

    @Override
    public void onTrigger() {

        tpfCounter.count();
        for (IBall b : balls) {
            b.move();
        }

    }

}
