package frame;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.*;

import time.timer.ITimer;
import time.timer.ITrigger;
import time.timer.TimerModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public interface IFrame {

    void setTitle(String title);

    void setContentPane(Container content);

    void shutdown();

}
