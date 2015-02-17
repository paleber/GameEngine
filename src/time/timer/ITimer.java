package time.timer;

public interface ITimer {

    void init(ITrigger trigger, int interval);

    void start();

    void stop();

}

