package frame;

import com.google.inject.Guice;
import com.google.inject.Injector;
import time.timer.ITimer;
import time.timer.ITrigger;
import time.timer.TimerModule;

import javax.swing.*;
import java.awt.*;

final class Frame extends JFrame implements IFrame, ITrigger {

    private static final long serialVersionUID = 1L;

    private static final Injector INJECTOR = Guice
            .createInjector(new TimerModule());

    private static final Dimension DEFAULT_SIZE = new Dimension(800, 600);
    private static final Dimension MINIMUM_SIZE = new Dimension(400, 300);
    private static final int TPF = 16; // 60 FPS

    private final ITimer timer = INJECTOR.getInstance(ITimer.class);

    public Frame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(DEFAULT_SIZE);
        getContentPane().setMinimumSize(MINIMUM_SIZE);
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
        timer.init(this, TPF);
        timer.start();
    }

    @Override
    public void shutdown() {
        timer.stop();
        dispose();
    }

    @Override
    public void onTrigger() {
        repaint();
    }

}