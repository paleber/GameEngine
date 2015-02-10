package geo.imp;

import java.util.Locale;

import geo.IPoint;
import geo.IVector;

public final class Vector implements IVector {

	private static final double FULL_ROTATION = 2 * Math.PI;

	private double length;
	private double angleRadian;

	@Override
	public double getX() {
		return Math.cos(angleRadian) * length;
	}

	@Override
	public double getY() {
		return Math.sin(angleRadian) * length;
	}

	@Override
	public double getLength() {
		return length;
	}

	@Override
	public void setLength(final double length) {
		this.length = length;
	}

	@Override
	public double getAngle() {
		return Math.toDegrees(angleRadian);
	}

	@Override
	public void set(final double x, final double y) {
		angleRadian = Math.atan2(y, x);
		limitAngle();
		length = Math.sqrt(x * x + y * y);
	}

	@Override
	public void copy(final IVector other) {
		length = other.getLength();
		angleRadian = Math.toRadians(other.getAngle());
		limitAngle();
	}

	@Override
	public void stretchBetween(final IPoint from, final IPoint to) {
		set(to.getX() - from.getX(), to.getY() - from.getY());
	}

	@Override
	public void setAngle(double degree, double length) {
		angleRadian = Math.toRadians(degree);
		limitAngle();
		this.length = length;
	}

	@Override
	public void swap() {
		angleRadian += Math.PI;
		limitAngle();
	}

	@Override
	public void rotate(final double angleDegree) {
		angleRadian += Math.toRadians(angleDegree);
		limitAngle();

	}

	private void limitAngle() {
		if (angleRadian < 0 || angleRadian >= FULL_ROTATION) {
			angleRadian = angleRadian % FULL_ROTATION;
			if (angleRadian < 0) {
				angleRadian += FULL_ROTATION;
			}
		}
	}

	@Override
	public String toString() {
		return String.format(Locale.ENGLISH, "<%.3f|%.3f>", getX(), getY());
	}
}
