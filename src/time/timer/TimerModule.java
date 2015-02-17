package time.timer;

import com.google.inject.AbstractModule;

public class TimerModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(ITimer.class).to(Timer.class);
    }

}
