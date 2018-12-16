package org.wahlzeit.interfaces;

import org.wahlzeit.model.CartesianCoordinate;
import org.wahlzeit.model.SphericCoordinate;


public interface Coordinate{
	public CartesianCoordinate asCartesianCoordinate();
	public SphericCoordinate asSphericCoordinate();
	public double getCentralAngle(Coordinate point);
	public double getCartesianDistance(Coordinate point);
	public boolean isEqual(Coordinate point);
	public Coordinate getCoordinate(double a, double b, double c);
}