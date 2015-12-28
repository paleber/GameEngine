package time.tpf;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;

import time.source.ITimeSource;

public final class TpfCounterModule extends AbstractModule {

    private final class TpfCounter implements ITpfCounter {

        private long last;
        private double tpf;

        private final ITimeSource timeSource;

        @Inject
        public TpfCounter(final ITimeSource timeSource) {
            this.timeSource = timeSource;
        }

        @Override
        public void init() {
            last = timeSource.getNanoTime();
        }

        @Override
        public void count() {
            long cur = timeSource.getNanoTime();
            tpf = (cur - last) * 1e-9;
            last = cur;
        }

        @Override
        public double getTPF() {
            return tpf;
        }

    }

    @Override
    protected void configure() {
        bind(ITpfCounter.class).to(TpfCounter.class);
    }

}


