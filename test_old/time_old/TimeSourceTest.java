package time_old;
/*
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import time_old.source.FakeTimeSourceModule;
import time_old.source.ITimeSource;
import time_old.source.SystemTimeSourceModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TimeSourceTest {

    private static final Injector INJECTOR_SYSTEM = Guice
            .createInjector(new SystemTimeSourceModule());

    private static final Injector INJECTOR_FAKE = Guice
            .createInjector(new FakeTimeSourceModule());

    @Test
    public void systemGetNanoTime() {
        ITimeSource timeSource = INJECTOR_SYSTEM.getInstance(ITimeSource.class);
        long before = System.nanoTime();
        long cur = timeSource.getNanoTime();
        long after = System.nanoTime();
        assertTrue(cur >= before);
        assertTrue(cur <= after);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void systemSetNanoTime() {
        ITimeSource timeSource = INJECTOR_SYSTEM.getInstance(ITimeSource.class);
        timeSource.setNanoTime(1);
    }

    @Test
    public void fakeNanoTime() {
        ITimeSource timeSource = INJECTOR_FAKE.getInstance(ITimeSource.class);
        timeSource.setNanoTime(7);
        assertEquals(7, timeSource.getNanoTime());
    }

}
*/