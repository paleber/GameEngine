package geo.imp;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Tests for AbstractBoundingBox.
 */
public class AbstractBoundingBoxTest {

    private static final double DELTA = 1e-9;

    double value;

    private final BoundingBox subject = new BoundingBox() {

        @Override
        double updateXMin() {
            return value + 1;
        }

        @Override
        double updateXMax() {
            return value + 2;
        }

        @Override
        double updateYMin() {
            return value + 3;
        }

        @Override
        double updateYMax() {
            return value + 4;
        }
    };

    @Test
    public void testXYMinMax() {
        value = 10;
        subject.updateBoundingBox();
        assertEquals(11, subject.getXMin(), DELTA);
        assertEquals(12, subject.getXMax(), DELTA);
        assertEquals(13, subject.getYMin(), DELTA);
        assertEquals(14, subject.getYMax(), DELTA);

        value = 20;
        assertEquals(11, subject.getXMin(), DELTA);
        assertEquals(12, subject.getXMax(), DELTA);
        assertEquals(13, subject.getYMin(), DELTA);
        assertEquals(14, subject.getYMax(), DELTA);

        subject.updateBoundingBox();
        assertEquals(21, subject.getXMin(), DELTA);
        assertEquals(22, subject.getXMax(), DELTA);
        assertEquals(23, subject.getYMin(), DELTA);
        assertEquals(24, subject.getYMax(), DELTA);
    }

    @Test
    public void testCalculateMid() {
        value = 0;
        subject.updateBoundingBox();
        Point p = (Point) subject.calculateMid();
        assertEquals(1.5, p.getX(), DELTA);
        assertEquals(3.5, p.getY(), DELTA);
    }

}
