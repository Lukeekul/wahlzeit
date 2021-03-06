package org.wahlzeit.model;

import org.wahlzeit.model.CoordinateFactory;

public class Location {
	
	private CartesianCoordinate coordinate;

	public void setLocation(CartesianCoordinate c) throws IllegalArgumentException {
		coordinate = c;
	}

	public CartesianCoordinate getLocation() throws NullPointerException {
		CartesianCoordinate result = CoordinateFactory.getCartesianCoordinate(0,0,0);
		if( coordinate == null) {
			String msg = "Requested Coordinate is Null";
			throw new NullPointerException(msg);
		} else {
			result = coordinate;
		}
		return result;
	}
}
