package org.wahlzeit.model;

import org.wahlzeit.interfaces.Coordinate;



public abstract class AbstractCoordinate implements Coordinate{

	protected final double ETTA = 10e-7;

	public abstract CartesianCoordinate asCartesianCoordinate();

	public abstract SphericCoordinate asSphericCoordinate();

	public abstract double getCentralAngle(Coordinate point);

	public abstract double getCartesianDistance(Coordinate point);
	
	public boolean isEqual(Coordinate point) {
		return isAlmostEqual(point);
	}

	protected boolean isAlmostEqual(Coordinate point) {
		if(getCartesianDistance(point) < ETTA ) {
			return true;
		}
		return false;
	}

	protected abstract void assertIsValidCoordinate() throws IllegalArgumentException;

	protected void assertIsNonNullArgument(Coordinate point) throws NullPointerException {
		if(point == null) {
			String msg = " Coordinate is null";
			throw new NullPointerException(msg);
		}
	}

	protected abstract void assertIsValidInput(double a, double b, double c) throws IllegalArgumentException;

	protected void assertClassInvariants() throws IllegalStateException {
		assertIsValidCoordinate();
	}

	protected void assertIsValidValue(double value) throws IllegalStateException {
		if(!(value >= 0 && value < Double.POSITIVE_INFINITY)) {
			String msg = "Value " + String.valueOf(value) + " must be positive and smaller than inf";
			throw new IllegalStateException(msg);
		}
	}

	protected void assertIsValidAngle(double value) throws IllegalStateException {
		if(!(value >= 0 && value < 360.0)) {
			String msg = "Angle " + String.valueOf(value) + " must be positive and smaller than inf";
			throw new IllegalStateException(msg);
		}
	}

}