package org.wahlzeit.model;

import org.wahlzeit.interfaces.Coordinate;

import java.lang.Double;
import java.util.*;
import org.wahlzeit.model.CoordinateHelper;



public abstract class AbstractCoordinate implements Coordinate{


	protected final double ETTA = 10e-7;

	public abstract CartesianCoordinate asCartesianCoordinate();

	public abstract SphericCoordinate asSphericCoordinate();

	public abstract double getCentralAngle(Coordinate point);

	public abstract double getCartesianDistance(Coordinate point);
	
	// public boolean isEqual(Coordinate point) {
	// 	return isAlmostEqual(point);
	// }

	protected boolean isAlmostEqual(Coordinate point) {
		assertIsNonNullArgument(point);
		assertClassInvariants();
		boolean result = false;
		if(getCartesianDistance(point) < ETTA ) {
			result = true;
		}
		assertClassInvariants();
		return result;
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

	protected abstract int getNoComponents();

	protected abstract double getComponent(int i);

	protected boolean equals(Coordinate o) {
		if((o == null) || !(o instanceof Coordinate)) {
			return false;
		}
		CartesianCoordinate c1 = this.asCartesianCoordinate();
		CartesianCoordinate c2 = o.asCartesianCoordinate();
		int noComponents = getNoComponents();
		for(int i = 0; i < noComponents; i++) {
			if(Math.abs(c1.getComponent(i) - c2.getComponent(i)) > ETTA) {
				return false;
			}
		}
		return true;
	}

	public Coordinate getCoordinate(double a, double b, double c) {
		return getHashArrayCoordinate(a, b, c);
	}

	protected abstract Coordinate getHashArrayCoordinate(double a, double b, double c);

}