package time.source;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public final class FakeTimeSourceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ITimeSource.class).to(FakeTimeSource.class).in(Singleton.class);
    }

}

class FakeTimeSource implements ITimeSource {

    private long nanoTime;
    
    @Override
    public long getNanoTime() {
        return nanoTime;
    }

    @Override
    public void setNanoTime(final long nanoTime) {
        this.nanoTime = nanoTime;
    }

}