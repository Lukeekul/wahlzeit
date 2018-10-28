package org.wahlzeit.model;

import java.lang.Math;


public class Coordinate {
	
	private double x;
	private double y;
	private double z;
	
	public double getDistance(Coordinate point) {
		
		double distanceX = Math.pow(point.x - x, 2);
		double distanceY = Math.pow(point.y - y, 2);
		double distanceZ = Math.pow(point.z - z, 2);
		
		return Math.sqrt(distanceX + distanceY + distanceZ);
	}
	
	public boolean isEqual(Coordinate point) {
		
		if(point.x == x && point.y == y && point.z == z) {
			return true;
		}
		
		return false;
	}
	
	public boolean equals(Coordinate point) {
		return isEqual(point);
	}

}
