package unittests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import elements.Camera;
import geometries.Geometry;
import geometries.Tube;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class TubeTests {

	@Test
	public void testIntersectionPoints() throws Exception {
		  final int WIDTH = 3;
		  final int HEIGHT = 3;
		  Ray[][] rays = new Ray[HEIGHT][WIDTH];
		  Camera camera = new Camera(new Point3D(0.0, 0.0, 0.0),
		   new Vector(0.0, 1.0, 0.0),
		   new Vector(0.0, 0.0, -1.0));
		  Tube tube = new Tube(1, new Point3D(1, 0.0, -3.0), new Vector(0,0,1), new Color(0,0,0), new Material(1,1,1,0,0));
		  Tube tube2 = new Tube(10, new Point3D(0.0, 0.0, -3.0), new Vector(0,0,1), new Color(0,0,0), new Material(1,1,1,0,0));
		  Tube tube3 = new Tube(1, new Point3D(0.0, 0.0, -3.0), new Vector(1,0,0), new Color(0,0,0), new Material(1,1,1,0,0));
		  Tube tube4 = new Tube(5, new Point3D(0.0, 0.0, 0), new Vector(1,0,0), new Color(0,0,0), new Material(1,1,1,0,0));
		  //special case: tangent to tube
		  Tube tube5 = new Tube(1, new Point3D(4, 1, 0), new Vector(0,0,1), new Color(0,0,0), new Material(1,1,1,0,0));
		  //special case: middle ray is encompassed in tube 
		  //three other rays still intersect so THREE intersection points are expected
		  Tube tube6 = new Tube(1, new Point3D(0, 1, 0), new Vector(0,0,1), new Color(0,0,0), new Material(1,1,1,0,0));
		  
		  List <Point3D> intersectionPointsTube = new ArrayList <Point3D> ();
		  List <Point3D> intersectionPointsTube2 = new ArrayList <Point3D> ();
		  List <Point3D> intersectionPointsTube3 = new ArrayList <Point3D> ();
		  List <Point3D> intersectionPointsTube4 = new ArrayList <Point3D> ();
		  List <Point3D> intersectionPointsTube5 = new ArrayList <Point3D> ();
		  List <Point3D> intersectionPointsTube6 = new ArrayList <Point3D> ();

		  System.out.println("Camera:\n " + camera);
		    for (int i = 0; i < HEIGHT; i++) {
			     for (int j = 0; j < WIDTH; j++) {
				      rays[i][j] = camera.constructRayThroughPixel(
				       WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
				      
				      Map<Geometry, List<Point3D>> rayIntersectionPoints = tube.findIntersections(rays[i][j]);
				      Map<Geometry, List<Point3D>> rayIntersectionPoints2 = tube2.findIntersections(rays[i][j]);
				      Map<Geometry, List<Point3D>> rayIntersectionPoints3 = tube3.findIntersections(rays[i][j]);
				      Map<Geometry, List<Point3D>> rayIntersectionPoints4 = tube4.findIntersections(rays[i][j]);
				      Map<Geometry, List<Point3D>> rayIntersectionPoints5 = tube5.findIntersections(rays[i][j]);
				      Map<Geometry, List<Point3D>> rayIntersectionPoints6 = tube6.findIntersections(rays[i][j]);

				      if(rayIntersectionPoints.size() !=0)
					      for (Point3D iPoint: rayIntersectionPoints.get(tube))
					       intersectionPointsTube.add(iPoint);
				      if(rayIntersectionPoints2.size() !=0)
					      for (Point3D iPoint: rayIntersectionPoints2.get(tube2))
					       intersectionPointsTube2.add(iPoint);
				      if(rayIntersectionPoints3.size() !=0)
					      for (Point3D iPoint: rayIntersectionPoints3.get(tube3))
						       intersectionPointsTube3.add(iPoint);
				      if(rayIntersectionPoints4.size() !=0)
					      for (Point3D iPoint: rayIntersectionPoints4.get(tube4))
						       intersectionPointsTube4.add(iPoint);
				      if(rayIntersectionPoints5.size() !=0)
					      for (Point3D iPoint: rayIntersectionPoints5.get(tube5))
						       intersectionPointsTube5.add(iPoint);
				      if(rayIntersectionPoints6.size() !=0)
					      for (Point3D iPoint: rayIntersectionPoints6.get(tube6))
						       intersectionPointsTube6.add(iPoint);
			     }
		    }

		    assertTrue(intersectionPointsTube.size() == 3);
		    assertTrue(intersectionPointsTube2.size() == 8);
		    assertTrue(intersectionPointsTube3.size() == 6);
		    assertTrue(intersectionPointsTube4.size() == 9);
		    assertTrue(intersectionPointsTube5.size() == 1);
		    assertTrue(intersectionPointsTube6.size() == 3);

	}

}
