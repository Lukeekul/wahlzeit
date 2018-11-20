package org.wahlzeit.model;

import org.wahlzeit.model.AbstractCoordinate;
import org.wahlzeit.interfaces.Coordinate;
import org.wahlzeit.model.SphericCoordinate;
import java.lang.Math;

public class CartesianCoordinate extends AbstractCoordinate{
	
	private double m_x;
	private double m_y;
	private double m_z;
	private final double ETTA = 10e-7;

	/*
	 *
	 */
	public CartesianCoordinate(double x, double y, double z) {
		assert x >= 0.0;
		assert y >= 0.0;
		assert z >= 0.0;
		m_x = x;
		m_y = y;
		m_z = z;
	}

	/*
	 *
	 */
	public CartesianCoordinate(CartesianCoordinate point) {
		m_x = point.m_x;
		m_y = point.m_y;
		m_z = point.m_z;
	}

	/*
	 *
	 */
	@Override
	public double getCartesianDistance(Coordinate point) {
		CartesianCoordinate tmp = point.asCartesianCoordinate();
		double distanceX = Math.pow(tmp.m_x - m_x, 2);
		double distanceY = Math.pow(tmp.m_y - m_y, 2);
		double distanceZ = Math.pow(tmp.m_z - m_z, 2);
		
		return Math.sqrt(distanceX + distanceY + distanceZ);
	}

	/*
	 *
	 */
	public boolean isAlmostEqual(CartesianCoordinate point, double etta) {
		double diff_x = Math.abs(m_x - point.m_x);
		double diff_y = Math.abs(m_y - point.m_y);
		double diff_z = Math.abs(m_z - point.m_z);
		
		if(diff_x < etta && diff_y < etta && diff_z < etta) {
			return true;
		}
		
		return false;
	}

	/*
	 *
	 */
	@Override
	public boolean isEqual(Coordinate point) {
		return isAlmostEqual(point.asCartesianCoordinate(), ETTA);
	}

	/*
	 *
	 */
	public boolean equals(CartesianCoordinate point) {
		return isEqual(point);
	}

	/*
	 *
	 */
	@Override
	public double getCentralAngle(Coordinate point) {
		SphericCoordinate tmp_this = this.asSphericCoordinate();
		SphericCoordinate tmp_other = point.asSphericCoordinate();
		return tmp_this.getCentralAngle(tmp_other);
	}

	/*
	 *
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(Math.pow(m_x, 2) + Math.pow(m_y, 2) + Math.pow(m_z, 2));
		double theta = Math.acos(m_z/radius);
		double phi = Math.atan(m_y/m_x);
		return new SphericCoordinate(Math.toDegrees(phi), Math.toDegrees(theta), radius);
	}

	/*
	 *
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

}

