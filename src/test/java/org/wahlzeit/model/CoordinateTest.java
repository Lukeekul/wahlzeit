package org.wahlzeit.model;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CoordinateTest {

	CartesianCoordinate cart1 = new CartesianCoordinate(1,2,3);
	CartesianCoordinate cart2 = new CartesianCoordinate(42.0, 100.1, 32.5);

	SphericCoordinate spher1 = new SphericCoordinate(1,2,3);
	SphericCoordinate spher2 = new SphericCoordinate(45.0, 90.0, 100.0);
	final double ETTA = 100;

	@Test
	public void testCoordinateConversion() {

		SphericCoordinate spher3 = cart2.asSphericCoordinate();
		CartesianCoordinate cart3 = spher3.asCartesianCoordinate();

		assertTrue(cart2.isEqual(cart2.asCartesianCoordinate()));
		assertTrue(spher2.isEqual(spher2.asSphericCoordinate()));

		assertTrue(spher3.isEqual(cart2));
		assertTrue(cart2.isEqual(spher3));
		assertTrue(cart3.isEqual(spher3));
		assertTrue(spher3.isEqual(cart3));
		assertTrue(cart2.isEqual(cart3));
		assertTrue(cart3.isEqual(cart2));

		assertFalse(cart1.isEqual(cart2));
		assertFalse(spher1.isEqual(spher2));
	}

	@Test
	public void testCoordinateDistance() {

		SphericCoordinate spher3 = cart1.asSphericCoordinate();
		SphericCoordinate spher4 = cart2.asSphericCoordinate();
		assertFalse(spher3.isEqual(spher4));

		double distance1 = cart1.getCartesianDistance(cart2);
		double distance2 = spher3.getCartesianDistance(cart2);
		double distance3 = spher4.getCartesianDistance(spher3);
		double distance4 = cart1.getCartesianDistance(spher4);

		assertTrue(Math.abs(distance1 - distance2) < ETTA);
		assertTrue(Math.abs(distance2 - distance3) < ETTA);
		assertTrue(Math.abs(distance3 - distance4) < ETTA);
		assertTrue(Math.abs(distance4 - distance1) < ETTA);
		assertTrue(spher1.getCartesianDistance(spher2) == spher2.getCartesianDistance(spher1));
	}

	@Test
	public void testCoordinateCentralAngle() {
		CartesianCoordinate cart3 = spher1.asCartesianCoordinate();
		CartesianCoordinate cart4 = spher2.asCartesianCoordinate();
		assertFalse(cart3.isEqual(cart4));

		double angle1 = spher1.getCentralAngle(spher2);
		double angle2 = cart3.getCentralAngle(spher2);
		double angle3 = cart4.getCentralAngle(cart3);
		double angle4 = spher1.getCentralAngle(cart4);

		assertTrue(Math.abs(angle1 - angle2) < ETTA);
		assertTrue(Math.abs(angle2 - angle3) < ETTA);
		assertTrue(Math.abs(angle3 - angle4) < ETTA);
		assertTrue(Math.abs(angle4 - angle1) < ETTA);
	}
}