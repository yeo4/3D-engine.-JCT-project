package unittests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import elements.*;
import geometries.*;
import primitives.*;


public class SphereTests {
	@Test
	public void testIntersectionPoints() throws Exception {
	  final int WIDTH = 3;
	  final int HEIGHT = 3;
	  Ray[][] rays = new Ray[HEIGHT][WIDTH];
	  Camera camera = new Camera(new Point3D(0.0, 0.0, 0.0),
	   new Vector(0.0, 1.0, 0.0),
	   new Vector(0.0, 0.0, -1.0));
	  
	  Sphere sphere = new Sphere(1, new Point3D(0.0, 0.0, -3.0));
	  Sphere sphere2 = new Sphere(10, new Point3D(0.0, 0.0, -3.0));
	  //Special Case Test: Tangent Line
	  Sphere sphere3 = new Sphere(1, new Point3D(1.0, 0.0, -4.0));
	  Sphere sphere4 = new Sphere(1, new Point3D(5.0, 0.0, -20.0));

	  // Only the center ray intersect the sphere in two locations
	  List <Point3D> intersectionPointsSphere = new ArrayList <Point3D> ();
	  // The sphere encapsulates the view plane - all rays intersect with the sphere once
	  List < Point3D > intersectionPointsSphere2 = new ArrayList <Point3D> ();
	  // Special Case: tangent to sphere (only 1 intersection point is expected)
	  List < Point3D > intersectionPointsSphere3 = new ArrayList <Point3D> ();
	  // No ray intersects this sphere
	  List < Point3D > intersectionPointsSphere4 = new ArrayList <Point3D> ();

	  System.out.println("Camera:\n " + camera);
	    for (int i = 0; i < HEIGHT; i++) {
		     for (int j = 0; j < WIDTH; j++) {
			      rays[i][j] = camera.constructRayThroughPixel(
			       WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
			      List < Point3D > rayIntersectionPoints = sphere.findIntersections(rays[i][j]);
			      List < Point3D > rayIntersectionPoints2 = sphere2.findIntersections(rays[i][j]);
			      List < Point3D > rayIntersectionPoints3 = sphere3.findIntersections(rays[i][j]);
			      List < Point3D > rayIntersectionPoints4 = sphere4.findIntersections(rays[i][j]);

			      for (Point3D iPoint: rayIntersectionPoints)
			       intersectionPointsSphere.add(iPoint);
			      for (Point3D iPoint: rayIntersectionPoints2)
			       intersectionPointsSphere2.add(iPoint);
			      for (Point3D iPoint: rayIntersectionPoints3)
				       intersectionPointsSphere3.add(iPoint);
			      for (Point3D iPoint: rayIntersectionPoints4)
				       intersectionPointsSphere4.add(iPoint);

		     }
	    }

	     assertTrue(intersectionPointsSphere.size() == 2);
	     assertTrue(intersectionPointsSphere2.size() == 9);
	     assertTrue(intersectionPointsSphere3.size() == 1);
	     assertTrue(intersectionPointsSphere4.size() == 0);
	     System.out.println(intersectionPointsSphere3);

	}
}
