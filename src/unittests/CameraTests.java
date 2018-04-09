package unittests;
import elements.*;
import primitives.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class CameraTests {

	@Test
	public void testConstructRay() throws Exception {
		int Nx = 150;
		int Ny = 150;
		int i = 3;
		int j = 3;
		double screenDistance = 100;
		double screenWidth = 3;
		double screenHeight = 3;
		Point3D p = new Point3D(0,0,0);
		Point3D p1 = new Point3D(1,0,0);
		Vector v1 = new Vector(p1);
		Point3D p2 = new Point3D(0,1,0);
		Vector v2 = new Vector(p2);
		Camera c = new Camera(p,v1,v2);
		Ray r = c.constructRayThroughPixel( Nx, Ny, i, j, screenDistance, screenWidth, screenHeight);
		Point3D p4 = new Point3D(1/Math.sqrt(6), 1/Math.sqrt(6), -Math.sqrt(2/3));
		Vector v4 = new Vector(p4);
		assertEquals(r.getDirection().length(), 50*Math.sqrt(6));
		assertEquals(r.getDirection(), v4);
		
	}

}
