package time.source;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public final class SystemTimeSourceModule extends AbstractModule {

    private class SystemTimeSource implements ITimeSource {

        @Override
        public long getNanoTime() {
            return System.nanoTime();
        }

        @Override
        public void setNanoTime(final long nanoTime) {
            throw new UnsupportedOperationException();
        }

    }

    @Override
    protected void configure() {
        bind(ITimeSource.class).to(SystemTimeSource.class).in(Singleton.class);
    }

}
