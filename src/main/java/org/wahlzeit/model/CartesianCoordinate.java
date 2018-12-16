package org.wahlzeit.model;

import org.wahlzeit.model.AbstractCoordinate;
import org.wahlzeit.interfaces.Coordinate;
import org.wahlzeit.model.SphericCoordinate;
import java.lang.Math;

public class CartesianCoordinate extends AbstractCoordinate{
	
	private final double m_x;
	private final double m_y;
	private final double m_z;

	/*
	 *
	 */
	private CartesianCoordinate(double x, double y, double z) {
		assertIsValidInput(x, y, z);

		m_x = x;
		m_y = y;
		m_z = z;

		assertIsValidCoordinate();
	}

	/*
	 *
	 */
	private CartesianCoordinate(CartesianCoordinate point) {
		assertIsNonNullArgument(point);

		m_x = point.m_x;
		m_y = point.m_y;
		m_z = point.m_z;

		assertIsValidCoordinate();
	}

	/*
	 *
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	/*
	 *
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();

		double radius = Math.sqrt(Math.pow(m_x, 2) + Math.pow(m_y, 2) + Math.pow(m_z, 2));
		double theta = Math.acos(m_z/radius);
		double phi = Math.atan(m_y/m_x);
		SphericCoordinate result = new SphericCoordinate(Math.toDegrees(phi), Math.toDegrees(theta), radius);

		assertClassInvariants();
		return result;
	}

	/*
	 *
	 */
	@Override
	public double getCartesianDistance(Coordinate point) {
		assertIsNonNullArgument(point);
		assertClassInvariants();

		CartesianCoordinate tmp = point.asCartesianCoordinate();
		double distanceX = Math.pow(tmp.m_x - m_x, 2);
		double distanceY = Math.pow(tmp.m_y - m_y, 2);
		double distanceZ = Math.pow(tmp.m_z - m_z, 2);
		double result = Math.sqrt(distanceX + distanceY + distanceZ);

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

		SphericCoordinate tmp_this = this.asSphericCoordinate();
		SphericCoordinate tmp_other = point.asSphericCoordinate();
		double result = tmp_this.getCentralAngle(tmp_other);

		assertClassInvariants();
		assertIsValidAngle(result);
		
		return result;
	}

	/*
	 *
	 */
	public boolean equals(CartesianCoordinate point) {
		assertIsNonNullArgument(point);
		assertClassInvariants();
		return isEqual(point);
	}

	@Override
	protected void assertIsValidCoordinate() {
		assertIsValidInput(m_x, m_y, m_z);
	}

	@Override
	protected void assertIsValidInput(double x, double y, double z) {
		if(x < 0 || x >= Double.POSITIVE_INFINITY) {
			String msg = "x cannot be negative";
			throw new IllegalArgumentException(msg);
		}
		if(y < 0 || y >= Double.POSITIVE_INFINITY) {
			String msg = "y cannot be negative";
			throw new IllegalArgumentException(msg);
		}
		if(z < 0 || z >= Double.POSITIVE_INFINITY) {
			String msg = "z cannot be negative";
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
				result = m_x;
				break;
			case 1:
				result = m_y;
				break;
			case 2:
				result = m_z;
				break;
			default:
				break;
		}
		return result;
	}
}

