package unittests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Test;

import elements.*;
import geometries.*;
import primitives.*;


public class EllipsoidTests {
	@Test
	public void testIntersectionPoints() throws Exception {
	  final int WIDTH = 3;
	  final int HEIGHT = 3;
	  Ray[][] rays = new Ray[HEIGHT][WIDTH];
	  Camera camera = new Camera(new Point3D(0.0, 0.0, 0.0),
	   new Vector(0.0, 1.0, 0.0),
	   new Vector(0.0, 0.0, -1.0));
	  
	  Ellipsoid ellipsoid = new Ellipsoid(new Point3D(0.0, 0.0, 0.0), 1, 2, 3, new Color(0,0,0), new Material(1,1,1,0,0));
	  Ellipsoid ellipsoid2 = new Ellipsoid(new Point3D(0.0, 0.0, -4), 1, 2, 3, new Color(0,0,0), new Material(1,1,1,0,0));
	  //Special Case Test: Tangent Line
	  Ellipsoid ellipsoid3 = new Ellipsoid(new Point3D(1, 0.0, -6), 1, 2, 3, new Color(0,0,0), new Material(1,1,1,0,0));
	  
	  Ellipsoid ellipsoid4 = new Ellipsoid(new Point3D(6, 0.0, -8), 5, 2, 3, new Color(0,0,0), new Material(1,1,1,0,0));

	  // The ellipsoid encapsulates the view plane - all rays intersect with the ellipsoid once
	  List <Point3D> intersectionPointsEllipse = new ArrayList <Point3D> ();
	  // Only the center ray intersects the ellipsoid in two locations
	  List < Point3D > intersectionPointsEllipse2 = new ArrayList <Point3D> ();
	  // Special Case: tangent to ellipsoid (only 1 intersection point is expected)
	  List < Point3D > intersectionPointsEllipsoid3 = new ArrayList <Point3D> ();
	  // No ray intersects this ellipsoid
	  List < Point3D > intersectionPointsEllipsoid4 = new ArrayList <Point3D> ();

	  System.out.println("Camera:\n " + camera);
	    for (int i = 0; i < HEIGHT; i++) {
		     for (int j = 0; j < WIDTH; j++) {
			      rays[i][j] = camera.constructRayThroughPixel(
			       WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
			      Map<Geometry, List<Point3D>> rayIntersectionPoints = ellipsoid.findIntersections(rays[i][j]);
			      Map<Geometry, List<Point3D>> rayIntersectionPoints2 = ellipsoid2.findIntersections(rays[i][j]);
			      Map<Geometry, List<Point3D>> rayIntersectionPoints3 = ellipsoid3.findIntersections(rays[i][j]);
			      Map<Geometry, List<Point3D>> rayIntersectionPoints4 = ellipsoid4.findIntersections(rays[i][j]);

			      if(rayIntersectionPoints.size() !=0)
				      for (Point3D iPoint: rayIntersectionPoints.get(ellipsoid))
				       intersectionPointsEllipse.add(iPoint);
			      if(rayIntersectionPoints2.size() !=0)
				      for (Point3D iPoint: rayIntersectionPoints2.get(ellipsoid2))
				       intersectionPointsEllipse2.add(iPoint);
			      if(rayIntersectionPoints3.size() !=0)
				      for (Point3D iPoint: rayIntersectionPoints3.get(ellipsoid3))
					       intersectionPointsEllipsoid3.add(iPoint);
			      if(rayIntersectionPoints4.size() !=0)
				      for (Point3D iPoint: rayIntersectionPoints4.get(ellipsoid4))
					       intersectionPointsEllipsoid4.add(iPoint);

		     }
	    }
	    

	     assertTrue(intersectionPointsEllipse.size() == 9);
	     assertTrue(intersectionPointsEllipse2.size() == 2);
	     assertTrue(intersectionPointsEllipsoid3.size() == 1);
	     assertTrue(intersectionPointsEllipsoid4.size() == 0);
	}
}
