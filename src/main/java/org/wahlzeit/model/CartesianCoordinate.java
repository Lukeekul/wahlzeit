package org.wahlzeit.model;

import org.wahlzeit.interfaces.Coordinate;
import org.wahlzeit.model.SphericCoordinate;
import java.lang.Math;

public class CartesianCoordinate implements Coordinate{
	
	private double m_x;
	private double m_y;
	private double m_z;
	private final double ETTA = 10e-7;
	
	public CartesianCoordinate(double x, double y, double z) {
		assert x >= 0.0;
		assert y >= 0.0;
		assert z >= 0.0;
		m_x = x;
		m_y = y;
		m_z = z;
	}

	public CartesianCoordinate(CartesianCoordinate point) {
		m_x = point.m_x;
		m_y = point.m_y;
		m_z = point.m_z;
	}
	
	public double getCartesianDistance(CartesianCoordinate point) {
		
		double distanceX = Math.pow(point.m_x - m_x, 2);
		double distanceY = Math.pow(point.m_y - m_y, 2);
		double distanceZ = Math.pow(point.m_z - m_z, 2);
		
		return Math.sqrt(distanceX + distanceY + distanceZ);
	}

	public double getCartesianDistance(SphericCoordinate point) {
		CartesianCoordinate tmp = point.asCartesianCoordinate();
		return getCartesianDistance(tmp);
	}
	
	public boolean isAlmostEqual(CartesianCoordinate point, double etta) {

		double diff_x = Math.abs(m_x - point.m_x);
		double diff_y = Math.abs(m_y - point.m_y);
		double diff_z = Math.abs(m_z - point.m_z);
		
		if(diff_x < etta && diff_y < etta && diff_z < etta) {
			return true;
		}
		
		return false;
	}

	public boolean isEqual(CartesianCoordinate point) {
		return isAlmostEqual(point, ETTA);
	}
	
	public boolean equals(CartesianCoordinate point) {
		return isEqual(point);
	}

	public boolean isEqual(SphericCoordinate point) {
		return isEqual(point.asCartesianCoordinate());
	}

	public double getCentralAngle(CartesianCoordinate point) {
		SphericCoordinate tmp_this = this.asSphericCoordinate();
		SphericCoordinate tmp_other = point.asSphericCoordinate();
		return tmp_this.getCentralAngle(tmp_other);

	}

	public double getCentralAngle(SphericCoordinate point) {
		SphericCoordinate tmp = this.asSphericCoordinate();
		return tmp.getCentralAngle(point);
	}

	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(Math.pow(m_x, 2) + Math.pow(m_y, 2) + Math.pow(m_z, 2));
		double theta = Math.acos(m_z/radius);
		double phi = Math.atan(m_y/m_x);
		return new SphericCoordinate(Math.toDegrees(phi), Math.toDegrees(theta), radius);
	}

	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

}

