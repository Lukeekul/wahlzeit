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

	public static SphericCoordinate getSphericCoordinate(double phi_degree, double theta_degree , double radius) {
		int coordinateHash = CoordinateHelper.hashCode(phi_degree, theta_degree, radius);

		SphericCoordinate coordinate = m_SphericCoordinateArray.get(coordinateHash);
		if(coordinate == null) {
			coordinate = new SphericCoordinate(phi_degree, theta_degree, radius);
			m_SphericCoordinateArray.put(coordinateHash, coordinate);
		}
		return coordinate;
	}
}