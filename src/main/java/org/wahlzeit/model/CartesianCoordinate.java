package org.wahlzeit.model;

import org.wahlzeit.model.SphericCoordinate;
import java.lang.Math;

public class CartesianCoordinate implements CoordinateInterface{
	
	private double m_x;
	private double m_y;
	private double m_z;
	
	public CartesianCoordinate(double x, double y, double z) {
		m_x = x;
		m_y = y;
		m_z = z;
	}
	
	public double getCartesianDistance(CartesianCoordinate point) {
		
		double distanceX = Math.pow(point.m_x - m_x, 2);
		double distanceY = Math.pow(point.m_y - m_y, 2);
		double distanceZ = Math.pow(point.m_z - m_z, 2);
		
		return Math.sqrt(distanceX + distanceY + distanceZ);
	}

	public double getCartesianDistance(SphericCoordinate point) {
		return 0.0;
	}
	
	public boolean isEqual(CartesianCoordinate point) {
		
		if(point.m_x == m_x && point.m_y == m_y && point.m_z == m_z) {
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

