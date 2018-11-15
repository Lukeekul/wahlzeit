package org.wahlzeit.model;

import org.wahlzeit.model.CartesianCoordinate;
import java.lang.Math;

public class SphericCoordinate implements {

	private double m_phi;
	private double m_theta;
	private double m_radius;

	public SphericCoordinate(double phi, double theta, double radius) {
		m_phi =  phi;
		m_theta = theta;
		m_radius = radius;
	}
	public CartesianCoordinate asCartesianCoordinate() {
		return new CartesianCoordinate(0.0,0.0,0.0);
	}

	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	public double getCartesianDistance(SphericCoordinate point) {
		return 0.0;
	}

	public double getCentralAngel(SphericCoordinate point) {
		return 0.0;
	}

	public double getCartesianDistance(CartesianCoordinate point) {
		return 0.0;
	}

	public double getCentralAngel(CartesianCoordinate point) {
		return 0.0;
	}

}