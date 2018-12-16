package org.wahlzeit.model;

public class CoordinateHelper {

	public static int hashCode(double a, double b, double c) {
		return 31 * 31 * Double.valueOf(a).hashCode()
				+ 31 * Double.valueOf(b).hashCode()
				+ Double.valueOf(c).hashCode();
	}
}