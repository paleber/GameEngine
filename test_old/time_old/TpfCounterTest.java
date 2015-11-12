package time_old;
/*
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import time_old.source.FakeTimeSourceModule;
import time_old.source.ITimeSource;
import time_old.tpf.ITpfCounter;
import time_old.tpf.TpfCounterModule;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class TpfCounterTest {

    private static final Injector INJECTOR = Guice
            .createInjector(new AbstractModule() {

                @Override
                protected void configure() {
                    install(new TpfCounterModule());
                    install(new FakeTimeSourceModule());
                }

            });

    @Test
    public void tpfCounter() {
        ITimeSource timeSource = INJECTOR.getInstance(ITimeSource.class);
        ITpfCounter tpfCounter = INJECTOR.getInstance(ITpfCounter.class);
        timeSource.setNanoTime((long) 1e9);
        tpfCounter.init();
        timeSource.setNanoTime((long) 2e9);
        tpfCounter.count();
        assertEquals(1, tpfCounter.getTPF(), 1e-9);
    }

}
*/