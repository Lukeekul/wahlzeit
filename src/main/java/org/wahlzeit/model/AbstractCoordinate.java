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
}