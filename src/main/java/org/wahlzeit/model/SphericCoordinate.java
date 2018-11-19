package org.wahlzeit.model;

import org.wahlzeit.interfaces.Coordinate;
import org.wahlzeit.model.CartesianCoordinate;
import java.lang.Math;

public class SphericCoordinate implements Coordinate{

	private double m_phi;
	private double m_theta;
	private double m_radius;
	private final double ETTA = 10e-7;

	/*
	 *
	 */
	public SphericCoordinate(double phi_degree, double theta_degree, double radius) {
		assert radius >= 0.0;
		assert phi_degree >= 0.0 && phi_degree < 360.0;
		assert theta_degree >= 0.0 && theta_degree < 180.0;
		m_phi =  Math.toRadians(phi_degree);
		m_theta = Math.toRadians(theta_degree);
		m_radius = radius;
	}

	/*
	 *
	 */
	public SphericCoordinate(SphericCoordinate point){
		m_phi = point.m_phi;
		m_theta = point.m_theta;
		m_radius = point.m_radius;
	}

	/*
	 *
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		double x = m_radius * Math.sin(m_theta) * Math.cos(m_phi);
		double y = m_radius * Math.sin(m_theta) * Math.sin(m_phi);
		double z = m_radius * Math.cos(m_theta);
		return new CartesianCoordinate(x, y, z);
	}

	/*
	 *
	 */
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	/*
	 *
	 */
	public double getCartesianDistance(Coordinate point) {
		CartesianCoordinate tmp_this = this.asCartesianCoordinate();
		CartesianCoordinate tmp_other = point.asCartesianCoordinate();
		return tmp_this.getCartesianDistance(tmp_other);
	}

	/*
	 *
	 */
	public double getCentralAngle(Coordinate point) {
		SphericCoordinate coordinate = point.asSphericCoordinate();
		double delta_x = Math.cos(coordinate.m_phi) * Math.cos(coordinate.m_theta) - Math.cos(m_phi) * Math.cos(m_theta);
		double delta_y = Math.cos(coordinate.m_phi) * Math.sin(coordinate.m_theta) - Math.cos(m_phi) * Math.sin(m_theta);
		double delta_z = Math.sin(coordinate.m_phi) - Math.sin(m_phi);

		double chord_length = Math.sqrt(Math.pow(delta_x, 2) + Math.pow(delta_y, 2) + Math.pow(delta_z, 2));

		double centralAngle = 2 * Math.asin( chord_length / 2);
		return Math.toDegrees(centralAngle);
	}

	/*
	 *
	 */
	public boolean isEqual(CartesianCoordinate point) {
		SphericCoordinate tmp = point.asSphericCoordinate();
		return isEqual(tmp);
	}

	/*
	 *
	 */
	public boolean isEqual(Coordinate point) {
		return isAlmostEqual(point.asSphericCoordinate(), ETTA);
	}

	/*
	 *
	 */
	private boolean isAlmostEqual(SphericCoordinate point, double etta) {
		double diff_phi = Math.abs(m_phi - point.m_phi);
		double diff_theta = Math.abs(m_theta - point.m_theta);
		double diff_radius = Math.abs(m_radius - point.m_radius);

		if (diff_phi < etta && diff_theta < etta  && diff_radius < etta){
			return true;
		}
		return false;
	}
}