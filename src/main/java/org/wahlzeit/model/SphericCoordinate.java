package org.wahlzeit.model;

import org.wahlzeit.interfaces.Coordinate;
import org.wahlzeit.model.AbstractCoordinate;
import org.wahlzeit.model.CartesianCoordinate;
import org.wahlzeit.model.CoordinateFactory;
import org.wahlzeit.annotation.PatternInstance;
import java.lang.Math;
import java.util.*;

@PatternInstance(
	patternName = "Flyweight",
	participants = {
		"ConcreteFlyweight"
	}
)
public class SphericCoordinate extends AbstractCoordinate{

	private final double m_phi;
	private final double m_theta;
	private final double m_radius;

	/*
	 *
	 */
	private SphericCoordinate(double phi_degree, double theta_degree, double radius) {
		assertIsValidInput(phi_degree, theta_degree, radius);

		m_phi =  Math.toRadians(phi_degree);
		m_theta = Math.toRadians(theta_degree);
		m_radius = radius;

		assertIsValidCoordinate();
	}

	/*
	 *
	 */
	private SphericCoordinate(SphericCoordinate point){
		assertIsNonNullArgument(point);

		m_phi = point.m_phi;
		m_theta = point.m_theta;
		m_radius = point.m_radius;

		assertIsValidCoordinate();
	}

	public static SphericCoordinate getCoordinate(double phi_degree, double theta_degree, double radius) {
		return new SphericCoordinate(phi_degree, theta_degree, radius);
	}

	public static SphericCoordinate getCoordinate(SphericCoordinate c) {
		return new SphericCoordinate(c);
	}

	/*
	 *
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants();

		double x = m_radius * Math.sin(m_theta) * Math.cos(m_phi);
		double y = m_radius * Math.sin(m_theta) * Math.sin(m_phi);
		double z = m_radius * Math.cos(m_theta);
		CartesianCoordinate result = CoordinateFactory.getCartesianCoordinate(x, y ,z);

		assertClassInvariants();

		return result;
	}

	/*
	 *
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	/*
	 *
	 */
	@Override
	public double getCartesianDistance(Coordinate point) {
		assertIsNonNullArgument(point);
		assertClassInvariants();
		
		CartesianCoordinate tmp_this = this.asCartesianCoordinate();
		CartesianCoordinate tmp_other = point.asCartesianCoordinate();
		double result = tmp_this.getCartesianDistance(tmp_other);
		
		assertClassInvariants();
		assertIsValidValue(result);
		
		return result;
	}

	/*
	 *
	 */
	@Override
	public double getCentralAngle(Coordinate point) {
		assertIsNonNullArgument(point);
		assertClassInvariants();

		SphericCoordinate coordinate = point.asSphericCoordinate();
		double delta_x = Math.cos(coordinate.m_phi) * Math.cos(coordinate.m_theta) - Math.cos(m_phi) * Math.cos(m_theta);
		double delta_y = Math.cos(coordinate.m_phi) * Math.sin(coordinate.m_theta) - Math.cos(m_phi) * Math.sin(m_theta);
		double delta_z = Math.sin(coordinate.m_phi) - Math.sin(m_phi);

		double chord_length = Math.sqrt(Math.pow(delta_x, 2) + Math.pow(delta_y, 2) + Math.pow(delta_z, 2));

		double centralAngle = 2 * Math.asin( chord_length / 2);
		double result = Math.toDegrees(centralAngle);

		assertClassInvariants();
		assertIsValidAngle(result);

		return result;
	}

	public boolean isEqual(Coordinate point) {
		assertIsNonNullArgument(point);
		assertClassInvariants();
		return equals(point);
	}

	@Override
	protected void assertIsValidCoordinate() {
		if(m_radius < 0) {
			String msg = "radius cannot be negative";
			throw new IllegalArgumentException(msg);
		}
		if(m_phi < 0.0 || m_phi > 2* Math.PI) {
			String msg = "phi must be within 0 and 360 degrees";
			throw new IllegalArgumentException(msg);
		}
		if(m_theta < 0.0 || m_theta > Math.PI) {
			String msg = "theta must be within 0 and 180 degrees";
			throw new IllegalArgumentException(msg);
		}
	}

	@Override
	protected void assertIsValidInput(double phi, double theta, double radius) {
		if(radius < 0) {
			String msg = "radius cannot be negative";
			throw new IllegalArgumentException(msg);
		}
		if(phi < 0.0 || phi > 360.0) {
			String msg = "phi must be within 0 and 360 degrees";
			throw new IllegalArgumentException(msg);
		}
		if(theta < 0.0 || theta > 180.0) {
			String msg = "theta must be within 0 and 180 degrees";
			throw new IllegalArgumentException(msg);
		}
	}

	@Override
	protected int getNoComponents() {
		return 3;
	}

	protected double getComponent(int i) {
		double result = 0.0;
		switch(i){
			case 0:
				result = m_phi;
				break;
			case 1:
				result = m_theta;
				break;
			case 2:
				result = m_radius;
				break;
			default:
				break;
		}
		return result;
	}
}
