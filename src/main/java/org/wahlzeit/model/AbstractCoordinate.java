package org.wahlzeit.model;

import org.wahlzeit.interfaces.Coordinate;



public abstract class AbstractCoordinate implements Coordinate{

	public abstract CartesianCoordinate asCartesianCoordinate();

	public abstract SphericCoordinate asSphericCoordinate();

	public abstract double getCentralAngle(Coordinate point);


	public abstract double getCartesianDistance(Coordinate point);
	
	public abstract boolean isEqual(Coordinate point);
}