package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CoordinateTest {

	@Test
	public void testCoordinateConversion() {

		CartesianCoordinate coordi_1 = new CartesianCoordinate(1,2,3);
		CartesianCoordinate coordi_2 = new CartesianCoordinate(42.0, 42.1, 42.5);

		SphericCoordinate coordi_3 = coordi_2.asSphericCoordinate();
		CartesianCoordinate coordi_4 = coordi_3.asCartesianCoordinate();
		assertTrue(coordi_1.isEqual(coordi_1));
		assertTrue(coordi_3.isEqual(coordi_2));
		assertTrue(coordi_2.isEqual(coordi_4));
	}
}