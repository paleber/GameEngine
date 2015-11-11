package collision_old;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import geo_old.ICircle;
import geo_old.ILine;
import geo_old.IPoint;
import geo_old.imp.GeoModule;

import org.testng.annotations.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public final class CollisionTest {

    private static final Injector INJECTOR = Guice
            .createInjector(new GeoModule());

    @Test
    public void checkPointCircle() {
        IPoint mid = INJECTOR.getInstance(IPoint.class);
        ICircle c = INJECTOR.getInstance(ICircle.class);
        c.setMid(mid);
        c.setRadius(2);

        IPoint p = INJECTOR.getInstance(IPoint.class);
        p.set(0, 1.9);
        assertTrue(Collision.check(p, c));

        p.set(0, 2.1);
        assertFalse(Collision.check(p, c));
    }

    @Test
    public void checkLineCircle() {
        IPoint start = INJECTOR.getInstance(IPoint.class);
        IPoint end = INJECTOR.getInstance(IPoint.class);
        IPoint mid = INJECTOR.getInstance(IPoint.class);

        ILine l = INJECTOR.getInstance(ILine.class);
        ICircle c = INJECTOR.getInstance(ICircle.class);

        l.setPoints(start, end);
        c.setRadius(2);
        c.setMid(mid);

        start.set(0, 0);
        end.set(10, 0);

        mid.set(-3, 0);
        assertFalse(Collision.check(l, c));

        mid.set(-1, 0);
        assertTrue(Collision.check(l, c));

        mid.set(13, 0);
        assertFalse(Collision.check(l, c));

        mid.set(11, 0);
        assertTrue(Collision.check(l, c));

        mid.set(5, 3);
        assertFalse(Collision.check(l, c));

        mid.set(5, 1);
        assertTrue(Collision.check(l, c));

    }

}
