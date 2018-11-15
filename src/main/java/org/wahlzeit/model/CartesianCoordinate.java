package org.wahlzeit.model;

import org.wahlzeit.model.SphericCoordinate;
import java.lang.Math;

public class CartesianCoordinate implements CoordinateInterface{
	
	private double x;
	private double y;
	private double z;
	
	public CartesianCoordinate(double MyX, double MyY, double MyZ) {
		x = MyX;
		y = MyY;
		z = MyZ;
	}
	
	public double getCartesianDistance(CartesianCoordinate point) {
		
		double distanceX = Math.pow(point.x - x, 2);
		double distanceY = Math.pow(point.y - y, 2);
		double distanceZ = Math.pow(point.z - z, 2);
		
		return Math.sqrt(distanceX + distanceY + distanceZ);
	}

	public double getCartesianDistance(SphericCoordinate point) {
		return 0.0;
	}
	
	public boolean isEqual(CartesianCoordinate point) {
		
		if(point.x == x && point.y == y && point.z == z) {
			return true;
		}
		
		return false;
	}
	
	public boolean equals(CartesianCoordinate point) {
		return isEqual(point);
	}

	public boolean isEqual(SphericCoordinate point) {
		return isEqual(point.asCartesianCoordinate());
	}

	public double getCentralAngle(CartesianCoordinate point) {

		return 0.0;

	}

	public double getCentralAngle(SphericCoordinate point) {

		return 0.0;
	}

	public SphericCoordinate asSphericCoordinate() {
		return new SphericCoordinate(0.0,0.0,0.0);
	}

	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}


}

