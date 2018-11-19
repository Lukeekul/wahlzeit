package org.wahlzeit.interfaces;

import org.wahlzeit.model.CartesianCoordinate;
import org.wahlzeit.model.SphericCoordinate;


public interface Coordinate{
	public CartesianCoordinate asCartesianCoordinate();
	public SphericCoordinate asSphericCoordinate();
	// public double getCartesianDistance(SphericCoordinate point);
	// public double getCentralAngle(SphericCoordinate point);
	public double getCentralAngle(Coordinate point);
	// public boolean isEqual(SphericCoordinate point);
	// public boolean isEqual(CartesianCoordinate point);
	public boolean isEqual(Coordinate point);
	public double getCartesianDistance(Coordinate point);
	// public double getCartesianDistance(CartesianCoordinate point);
	// public double getCentralAngle(CartesianCoordinate point);
}