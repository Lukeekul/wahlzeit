package org.wahlzeit.model;

import org.wahlzeit.model.SphericCoordinate;
import org.wahlzeit.model.CartesianCoordinate;
import org.wahlzeit.model.CoordinateHelper;
import java.util.HashMap;


public class CoordinateFactory {

	private static final HashMap<Integer, CartesianCoordinate> m_CartesianCoordinateArray = new HashMap<Integer, CartesianCoordinate>();
	private static final HashMap<Integer, SphericCoordinate> m_SphericCoordinateArray = new HashMap<Integer, SphericCoordinate>();

	public static CartesianCoordinate getCartesianCoordinate(double x, double y, double z) {
		int coordinateHash = CoordinateHelper.hashCode(x, y, z);

		CartesianCoordinate coordinate = m_CartesianCoordinateArray.get(coordinateHash);
		if(coordinate == null) {
			coordinate = new CartesianCoordinate(x, y, z);
			m_CartesianCoordinateArray.put(coordinateHash, coordinate);
		}
		return coordinate;
	}

	public static CartesianCoordinate getCartesianCoordinate(CartesianCoordinate coordinate) {
		CartesianCoordinate result;
		if(coordinate != null && coordinate.getNoComponents() == 3) {
			double x = coordinate.getComponent(0);
			double y = coordinate.getComponent(1);
			double z = coordinate.getComponent(2);
			result = getCartesianCoordinate(x, y, z);
		} else {
			result = new CartesianCoordinate(coordinate);
		}
		return result;
	}

	public static SphericCoordinate getSphericCoordinate(double phi_degree, double theta_degree , double radius) {
		int coordinateHash = CoordinateHelper.hashCode(phi_degree, theta_degree, radius);

		SphericCoordinate coordinate = m_SphericCoordinateArray.get(coordinateHash);
		if(coordinate == null) {
			coordinate = new SphericCoordinate(phi_degree, theta_degree, radius);
			m_SphericCoordinateArray.put(coordinateHash, coordinate);
		}
		return coordinate;
	}

	public static SphericCoordinate getSphericCoordinate(SphericCoordinate coordinate) {
		SphericCoordinate result;
		if(coordinate != null && coordinate.getNoComponents() == 3) {
			double phi = coordinate.getComponent(0);
			double theta = coordinate.getComponent(1);
			double radius = coordinate.getComponent(2);
			result = getSphericCoordinate(phi, theta, radius);
		} else {
			result = new SphericCoordinate(coordinate);
		}
		return result;
	}
}