package org.wahlzeit.model;


public interface CoordinateInterface{
	public CartesianCoordinate asCartesianCoordinate();
	public SphericCoordinate asSphericCoordinate();
	public double getCartesianDistance(SphericCoordinate point);
	public double getCentralAngle(SphericCoordinate point);
	public boolean isEqual(SphericCoordinate point);
	public double getCartesianDistance(CartesianCoordinate point);
	public double getCentralAngle(CartesianCoordinate point);
	public boolean isEqual(CartesianCoordinate point);
}